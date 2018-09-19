Vue.component('resource-div', {
    data: function () {
        return{
            MType: 'SIM',
            MFrom: '',
            MTo: '',
            invalid: true,
        }
    },
    methods: {
        mSubmit: function () {
            let _this = this;
            axios.post('/rec/saveResource', {
                mtype: this.MType,
                mfrom: this.MFrom,
                mto: this.MTo,
            }).then(function (resp) {
                alert(resp.data);
                _this.MType = 'SIM';
                _this.MFrom = '';
                _this.MTo = '';
            })
        }
    },
    computed: {
        CKMFrom: {
            get: function () {
                return this.MFrom;
            },
            set: function (value) {
                this.invalid = value.length !== 11 || this.MTo.length !== 11;
                this.MFrom = value;
            }
        },
        CKMTo: {
            get: function () {
                return this.MTo;
            },
            set: function (value) {
                this.invalid = value.length !== 11 || this.MFrom.length !== 11;
                this.MTo = value;
            }
        }
    },
    template: `
    <form>
    <p>号码类型：<input type="radio" v-model="MType" value="SIM">SIM &nbsp;&nbsp;<input type="radio" v-model="MType" value="UIM">UIM</p>
    <p>指定号段：从<input type="text" v-model="CKMFrom" size="20">到
    <input type="text" v-model="CKMTo" size="20"> <span v-show="invalid" style="color: red">号码必须是十一位</span>
    <br>
    <button type="button" :disabled="invalid" @click="mSubmit">提交</button></p>
    </form>
    `,
});