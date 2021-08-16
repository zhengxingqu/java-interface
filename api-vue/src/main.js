// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Element from "element-ui"
import axios from "axios"
import 'element-ui/lib/theme-chalk/index.css'
import md5 from 'js-md5';
Vue.prototype.$md5 = md5;
Vue.use(Element);
Vue.config.productionTip = false

Vue.prototype.$axios = axios;
axios.defaults.baseURL = "http://127.0.0.1:8090";
axios.defaults.headers.post['Content-Type'] = 'application/json; charset=UTF-8';
axios.defaults.headers.get['Content-Type'] = 'application/json; charset=UTF-8';
axios.defaults.headers.put['Content-Type'] = 'application/json; charset=UTF-8';
axios.defaults.headers.delete['Content-Type'] = 'application/json; charset=UTF-8';

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
