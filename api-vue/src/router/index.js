import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import ModuleManagement from "../components/ModuleManagement";
import Header from "../components/Header";
import EnvironmentalManagement from "../components/EnvironmentalManagement";
import ProjectManagement from "../components/ProjectManagement";
import CaseManagement from "../components/CaseManagement";
import CaseGroupManagement from "../components/CaseGroupManagement";
import User from "../components/User";
import LoginInterface from "../components/LoginInterface";


Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/module',
      name: 'ModuleManagement',
      component: ModuleManagement
    },
    {
      path: '/header',
      name: 'Header',
      component: Header
    },
    {
      path: '/environmental',
      name: 'Environmental',
      component: EnvironmentalManagement
    },
    {
      path: '/project',
      name: 'Project',
      component: ProjectManagement
    },
    {
      path: '/case',
      name: 'Case',
      component: CaseManagement
    },

    {path: '/caseGroup',
      name: 'CaseGroup',
      component: CaseGroupManagement
    },

    {path: '/user',
      name: 'User',
      component: User
    },

    {path: '/login/interface',
      name: 'LoginInterface',
      component: LoginInterface
    },

  ]
})
