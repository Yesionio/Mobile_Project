Vue.component('newoperator-div', {
    data: function () {
        let data = {
            isFaild: false,
            operatorId: '',
            operatorName: '',
            operatorPwd: '',
            ckPwd: '',
            isAdmin: 'N',

        };
        return data;
    },
    computed: {
        tckPwd: {
            get: function () {
                return this.ckPwd;
            },
            set: function (value) {
                this.isFaild = value !== this.operatorPwd;
                this.ckPwd = value;
            }
        }
    },
    methods: {
        TiJiao: function () {

            axios({
                url:'/saveOperator',
                method: 'post',
                data: {
                    operatorId: this.operatorId,
                    operatorName: this.operatorName,
                    operatorPwd: this.operatorPwd,
                    isAdmin: this.isAdmin,
                },
            }).then(respanse=>{
                alert(respanse.data ? "新增操作员成功" : "新增操作员失败");
            });
        }
    },
    template: `
      <form>
      <p>登录ID：<input type="text" v-model="operatorId" size="20"></p>
      <p>姓 名：<input type="text" v-model="operatorName" size="20"></p>
      <p>密码：<input type="password" v-model="operatorPwd" size="20"></p>
      <p>密码确认：<input type="password" v-model="tckPwd" size="20"> <span v-show="isFaild" style="color: red;">密码必须一致</span> </p>
      <p>是否管理员：<input type="radio" v-model="isAdmin" value="Y">是&nbsp;&nbsp;&nbsp; 
      <input type="radio" v-model="isAdmin" value="N">否</p>
      <p><button type="button" @click="TiJiao" :disabled="isFaild">提交</button></p>
    </form>
    `
});