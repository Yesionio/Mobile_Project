window.onload = function () {
    axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
    axios.defaults.transformRequest = [function(data) {
        let ret = '';
        for (let it in data) {
            ret += encodeURIComponent(it) + '=' + encodeURIComponent(data[it]) + '&'
        }
        return ret;
    }];
    tdata = {};
    axios
        .post('/fetchOperator')
        .then(function (resp) {
                tdata = resp.data;
                tdata.curAddr = "登录成功";
                tdata.mainContent = '你好';
                tdata.cmt = 'default-div';
                var vm = new Vue({
                    el: '#app',
                    data: tdata,
                    created: function () {
                        this.isAdmin = this.isAdmin === 'Y';
                        document.querySelector('#app').style.display = 'block';
                    },
                    methods: {
                        newOperator: function (cmtName, curAddr) {
                            this.curAddr = curAddr;// "新增操作员";
                            this.cmt = cmtName;
                        }
                    },
                    components: {
                        'default-div': {template: '<p></p>'},
                    }
                });
            }
        );
};