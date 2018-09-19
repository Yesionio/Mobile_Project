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

Vue.component('newuser-div', {
    props: ['customerId'],
    data: function () {
        return{
            mobileNumber: '',
            seed: true,
            tlenOk: true,
            roamingStatus: 'P',
            comLevel: 'L',
            accuId: '',
            userObj: null,
            isNewAccu: true,
        }
    },
    methods: {
        nextStep: function () {
            this.userObj = {
                roamingStatus: this.roamingStatus,
                comLevel: this.comLevel,
                mobileNumber: this.mobileNumber,
                customerId: this.customerId
            };
            let _this = this;
            axios.post('/open/chkAccount', {
                idType: this.idTyNum.idType,
            }).then(function (resp) {
                if (resp.data) {
                    this.$root.curAddr = "合账";
                    this.isNewAccu = false;
                } else {
                    this.$root.curAddr = "新增账户";
                    this.isNewAccu = true;
                }
            });
        }
    },
    computed: {
        ckMobileNumber: {
            set: function (value) {
                if (value.length === 11) {
                    this.tlenOk = false;
                    let _this = this;
                    axios.post('/open/chknumber', {number: value}).then(resp => {
                        _this.seed = resp.data <= 0;
                    });
                } else {
                    this.tlenOk = true;
                }
                this.mobileNumber = value;
            },
            get: function () {
                return this.mobileNumber;
            }
        },
    },
    template: `
    <div>
     <form>
      <p>手机号码：
          <input type="text" v-model.lazy="ckMobileNumber" size="20"> 
          <span style="color: red" v-show="tlenOk"> &Chi;号码必须是11位 </span>
          <span style="color: red" v-show="!tlenOk && seed"> &chi;该号码不存在 </span>
          <span style="color: lawngreen" v-show="!seed"> &checkmark; </span>
      </p>
      <p>漫游状态：
          <input type="radio" v-model="roamingStatus" value="P">省内漫游
          <input type="radio" v-model="roamingStatus" value="D">国内漫游
          <input type="radio" v-model="roamingStatus" value="I">国际漫游
      </p>
      <p>通话级别：
          <input type="radio" v-model="comLevel" value="L">本地通话 
          <input type="radio" v-model="comLevel" value="D">国内长途 
          <input type="radio" v-model="comLevel" value="T">国际长途
      </p>
      
      <p>客户ID：<input type="text" :value="customerId" size="20" readonly></p>
      
      <p>账号：<input type="text" v-model="accuId" size="20">  </p>
      <p> <button type="button" @click="nextStep" :disabled="seed">下一步&gt;&gt;</button> </p>
    </form>
    <account-div :userObj="userObj" :isNewAccu="isNewAccu"></account-div>
    </div>
    `,
});