Vue.component('operatorList-div', {
    data: function () {
        return {
            oplist: [],
            listPage: true,
            curModOperator: null,
            ckPwd: '',
            isFaild: false,
            isAdmin: false,
        };
    },
    computed: {
        pckPwd: {
            get: function () {
                return this.ckPwd;
            },
            set: function (value) {
                this.isFaild = value !== this.curModOperator.operatorPwd;
                this.ckPwd = value;
            }
        },
    },
    created: function () {
        this.loadData();
    },
    methods: {
        loadData: function () {
            let _this = this;
            axios.post('/queryOperator').then(function (resp) {
                _this.oplist = resp.data;
            });
        },
        xon: function (x) {
            this.curModOperator = {};
            for (let y in x) {
                this.curModOperator[y] = x[y];
            }
            this.curModOperator.operatorPwd = this.ckPwd = '';
            this.isAdmin = x.isAdmin;
            this.listPage = false;
            console.log(this.curModOperator);
        },
        UpdateOperator: function () {
            axios({
                url: '/updateOperator',
                method: 'post',
                data: {
                    operatorId: this.curModOperator.operatorId,
                    operatorName: this.curModOperator.operatorName,
                    operatorPwd: this.curModOperator.operatorPwd,
                    isAdmin: this.isAdmin,
                },
            }).then(respanse => {
                alert(respanse.data ? "修改操作员成功" : "修改操作员失败");
                this.loadData();
                this.listPage = true;
            });
            console.log(this.curModOperator.operatorId);
            console.log(this.curModOperator.operatorName);
            console.log(this.curModOperator.operatorPwd);
            console.log(this.isAdmin);
        }
    },
    template: `
    <div>
        <table border="1" width="100%" height="89" v-if="listPage">
              <tr>
                <td width="25%" align="center" height="16">登录ID</td>
                <td width="25%" align="center" height="16">姓名</td>
                <td width="25%" align="center" height="16">是否管理员</td>
                <td width="25%" align="center" height="16">修改</td>
              </tr>
              <tr v-for="x in oplist">
                <td width="25%" align="center" height="17">{{ x.operatorId }}</td>
                <td width="25%" align="center" height="17">{{ x.operatorName }}</td>
                <td width="25%" align="center" height="17">{{ x.isAdmin=='Y' ? '是':'否' }}</td>
                <td width="25%" align="center" height="17"><a href="#" @click.stop.prevent="xon(x)">&gt;&gt;</a></td>
              </tr>
            </table>
            <form v-else>
              <a href="" @click.stop.prevent="listPage=true">  &lt;-返回列表  </a>
              <p>登录ID：{{ curModOperator.operatorId }}</p>
              <p>姓 名：<input type="text" v-model="curModOperator.operatorName" size="20"></p>
              <p>密码：<input type="password" v-model="curModOperator.operatorPwd" size="20"></p>
              <p>密码确认：<input type="password" v-model="pckPwd" size="20">
              <span v-show="isFaild" style="color: red;">密码必须一致</span>
              </p>
              <p>是否管理员：<input type="radio" v-model="isAdmin" value="Y">是&nbsp;&nbsp;&nbsp; 
              <input type="radio" v-model="isAdmin" value="N">否</p>
              <p> <button type="button" @click.stop.prevent="UpdateOperator">提交</button> </p>
            </form>
    </div>
    `
});

