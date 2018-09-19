Vue.component('chargeconfig-div', {
    data: function () {
        return {
            chargeList: [],
            selCharge: null,
            charge: 0,
            selChargeCode: [],
            funcId: 'O',
            chargeRuleList: [],
        }
    },
    created: function () {
        this.loadData();
    },
    computed: {
        isOk: function () {
            if (this.chargeRuleList.length !== this.selChargeCode.length) return false;
            let flag = true;
            for (let x of this.chargeRuleList) {
                if (!this.selChargeCode.includes(x)) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }
    },
    methods: {
        loadData: function () {
            let _this = this;
            axios.post('/chr/queryCharge').then(function (resp) {
                _this.chargeList = resp.data.chargeList;
                resp.data.chargeRuleList.forEach(value => {
                    _this.chargeRuleList.push(value.chargeCode);
                });
                _this.selChargeCode = _this.chargeRuleList;
            })/*.catch(function (error) {
                alert("获取数据失败");
            })*/;
        },
        fetchPrice: function () {
            this.charge = this.selCharge.charge;
        },
        kankan: function () {
            let _this = this;
            axios.post('/chr/updateCharge', {
                chargeCode: this.selCharge.chargeCode,
                chargeName: this.selCharge.chargeName,
                charge: this.charge,
            }).then(resp => {
                _this.loadData();
                alert(resp.data);
                _this.selCharge = null;
                _this.charge = 0;
            });
        },
        tchange: function () {
            let _this = this;
            axios.post('/chr/updateChargeRule', {
                funcId: "O",
                funcName: "开户业务",
                chargeRuleList: _this.selChargeCode,
            }).then(resp => {
                _this.loadData();
                alert(resp.data ? "修改项目成功" : "修改项目失败");
            });

        }
    },
    template: `
    <div>
    <h2>收费细项</h2>
    <form>
      <p>收费项目：<select size="1" v-model="selCharge" @change="fetchPrice">
        <option disabled :value="null">请选择</option>
        <option v-for="x in chargeList" :value="x">{{ x.chargeName }}</option>
      </select></p>
      <p>收费金额：<input type="number" v-model="charge" size="20" min="0"></p>
      <p><button type="button" @click="kankan" :disabled="selCharge == null">提交</button></p>
    </form>
    <hr>
    <h2>业务收费</h2>
    <form>
      <p>业务：<select v-model="funcId">
        <option value="O">开户业务</option>
      </select></p>
      <p>收费项目：<label v-for="x in chargeList">
      <input type="checkbox" v-model="selChargeCode" :value="x.chargeCode">{{ x.chargeName }}
      </label>
      <p><button type="button" @click="tchange" :disabled="isOk">提交</button></p>
    </form>   
    </div>
    `,
});