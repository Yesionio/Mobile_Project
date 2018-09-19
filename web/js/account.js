Vue.component('account-div', {
    props: ['userObj', 'isNewAccu'],
    data: function () {
        return{
            accountId: '',
            contactPerson: '',
            contactAddress: '',
            accountBalance: 0,
            balance: 0,
            seed: true,
        }
    },
    methods: {
    },
    computed: {
    },
    template: `
     <form>
      <p>账号：<input type="text" size="20" readonly></p>
      <p>姓名：<input type="text" name="T2" size="20" :readonly="!isNewAccu"></p>
      <p>联系地址：<input type="text" name="T3" size="20" :readonly="!isNewAccu"></p>
      <p>{{ isNewAccu ? '开户金额' : '账户余额'}}：
      <input type="text" size="20">
      </p>
      
      <p> <button type="button" @click="nextStep">提交</button> </p>
    </form>
    `,
});