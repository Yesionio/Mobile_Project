Vue.component('newCustomer2-div', {
    props: ['idTyNum', 'idNumber'],
    data: function () {
        return{
            cusName: '',
            cusSex: 'F',
            cusBirth: '',
            cusAddr: '',
            customerId: null,
            seed: true,
        }
    },
    methods: {
        nextStep: function () {
            this.customerId = 1;
            this.$root.curAddr = "新增用户";
            this.seed = false;
            /*let _this = this;
            axios.post('/open/saveCustomer', {
                idType: this.idTyNum.idType,
                idNumber: this.idNumber,
                cusName: this.cusName,
                cusBirth: this.cusBirth,
                cusSex: this.cusSex,
                cusAddr: this.cusAddr,
            }).then(function (resp) {
                if (resp.data !== null) {
                    _this.customerId = resp.data;
                    this.$root.curAddr = "新增用户";
                    this.seed = false;
                } else {
                    alert('保存失败');
                }
            });*/

        }
    },
    computed: {
    },
    template: `
    <div>
    <form v-if="seed">
      <p>证件类型：{{ idTyNum.Name }}</p>
      <p>证件号码：{{ idNumber }}</p>
      <p>姓名：<input type="text" v-model="cusName" size="20"></p>
      <p>性别：<input type="radio" v-model="cusSex" value="F">男&nbsp;&nbsp; 
      <input type="radio" v-model="cusSex" value="M">女</p>
      <p>生日：<input type="date" v-model="cusBirth" size="20"></p>
      <p>联系地址：<input type="text" v-model="cusAddr" size="20"></p>
      <p>　</p>
      <p> <button type="button" @click="nextStep">下一步&gt;&gt;</button> </p>
    </form>
    <template v-else>
        <newuser-div :customerId="customerId"></newuser-div>
    </template>
    </div>
    `,
});

Vue.component('newCustomer-div', {
    data: function () {
        return{
            idType: null,
            idNumber: '',
            seed: true
        }
    },
    methods: {
        nextStep: function () {
            let _this = this;
            if (this.idType === null) {
                alert('请选择证件类型');
                return;
            } else if (this.idNumber === '') {
                alert('请输入证件号码');
                return;
            }
            axios.post('/open/chkIdNum', {idNumber: this.idNumber})
                .then(resp => {
                    if (resp.data) {
                        _this.$parent.curAddr = "新增客户>第二步";
                        _this.seed = false;
                    } else {
                        alert('已存在该身份证，请重新输入');
                        _this.idType = null;
                        _this.idNumber = '';
                    }
                });
        }
    },
    computed: {
        canNext: function () {
            return this.idNumber.length !== 18;
        }
    },
    template: `
    <div id="sonPage">
    <form v-if="seed">
      <p>证件类型：<select size="1" v-model="idType">
        <option :value="null" disabled>请选择</option>
        <option :value="{idType: 'D', Name: '居民身份证'}">居民身份证</option>
        <option :value="{idType: 'A', Name: '护照'}">护照</option>
        <option :value="{idType: 'P', Name: '军官证'}">军官证</option>
      </select></p>
      <p>证件号码：<input type="text" v-model="idNumber" size="20"> <span v-show="canNext" style="color: red">身份证必须十八位</span>
      </p>      
      <p>　</p>
      <p> <button type="button" @click="nextStep" :disabled="canNext">下一步&gt;&gt;</button> </p>
    </form>
    <template v-else>
        <newCustomer2-div :idTyNum="idType" :idNumber="idNumber"></newCustomer2-div>
    </template>
    </div>
    `,
});


/*
Vue.component('-div', {
    data: function () {
        return{
        }
    },
    methods: {
    },
    computed: {
    },
    template: `
    `,
});*/
