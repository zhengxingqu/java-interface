<template>
  <div style="height: 100%">
    <el-container>
      <el-header>接口测试平台</el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu
            default-active="2"
            class="el-menu-vertical-demo">
            <el-menu-item index="1">
              <i class="el-icon-menu"></i>
              <span slot="title"><router-link to="/project" style="text-decoration:none;">项目管理</router-link></span>
            </el-menu-item>
            <el-menu-item index="2">
              <i class="el-icon-document"></i>
              <span slot="title"><router-link to="/module" style="text-decoration:none;">模块管理</router-link></span>
            </el-menu-item>
            <el-menu-item index="3">
              <i class="el-icon-setting"></i>
              <span slot="title"><router-link to="/environmental"
                                              style="text-decoration:none;">环境管理</router-link></span>
            </el-menu-item>
            <el-menu-item index="4">
              <i class="el-icon-setting"></i>
              <span slot="title"><router-link to="/header" style="text-decoration:none;">请求头管理</router-link></span>
            </el-menu-item>

            <el-menu-item index="5">
              <i class="el-icon-setting"></i>
              <span slot="title"><router-link to="/case" style="text-decoration:none;">用例管理</router-link></span>
            </el-menu-item>

            <el-menu-item index="6">
              <i class="el-icon-setting"></i>
              <span slot="title"><router-link to="/caseGroup" style="text-decoration:none;">用例组</router-link></span>
            </el-menu-item>

            <el-menu-item index="7">
              <i class="el-icon-setting"></i>
              <span slot="title"><router-link to="/user" style="text-decoration:none;">用户</router-link></span>
            </el-menu-item>

            <el-menu-item index="8">
              <i class="el-icon-setting"></i>
              <span slot="title"><router-link to="/user" style="text-decoration:none;">登陆接口</router-link></span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-container>
          <el-main>
            <el-breadcrumb separator-class="el-icon-arrow-right">
              <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item>接口平台管理</el-breadcrumb-item>
            </el-breadcrumb>

            <el-form :inline="true" style="margin-top: 20px">
              <el-row>
                <el-col :span="8">
                  <el-form-item label="请输入查询条件">
                    <el-input placeholder="输入查询条件" v-model="projectName"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-button-group>
                    <el-button type="primary" icon="el-icon-search" @click="searchLogin()">查询</el-button>
                    <el-button type="primary" icon="el-icon-share" @click="getPageLogin()">全部</el-button>
                    <el-button type="primary" icon="el-icon-plus" @click="addLogin()">添加</el-button>
                  </el-button-group>
                </el-col>
              </el-row>

            </el-form>

            <el-table
              :data="pageLoginList"
              style="width: 100%">
              <el-table-column
                prop="date"
                type="selection">
              </el-table-column>
              <el-table-column
                label="序号"
                width="60"
                type="index">
              </el-table-column>
              <el-table-column
                prop="interfaceName"
                label="登陆接口名称"
                width="60">
              </el-table-column>
              <el-table-column
                prop="url"
                label="请求地址"
                width="80">
              </el-table-column>
              <el-table-column
                prop="header"
                label="请求头"
                width="80">
              </el-table-column>
              <el-table-column
                prop="loginWay"
                label="登陆方式"
                width="80">
              </el-table-column>
              <el-table-column
                prop="result"
                label="结果"
                width="80">
              </el-table-column>
              <el-table-column
                label="操作">
                <template slot-scope="scope">
                  <el-button type="success" size="mini" @click="updateLogin(scope.row)">编辑</el-button>
                  <el-button type="info" size="mini" @click="deleteLogin(scope.row)">删除</el-button>
                </template>
              </el-table-column>
            </el-table>

            <el-row>
              <el-col :span="8" style="text-align: left">
                <el-button type="danger" icon="el-icon-delete" size="mini" style="margin-top: 20px">批量删除</el-button>
              </el-col>
              <el-col :span="16" style="text-align: right;margin-top: 20px">
                <div class="block">
                  <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="currentPage"
                    :page-sizes="[10, 30, 100]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total">
                  </el-pagination>
                </div>
              </el-col>
            </el-row>

            <el-dialog
              :title="dialogTitle"
              :visible.sync="dialogVisible"
              width="60%"
            >
              <el-form style="margin-left: 20px;" :inline="true" label-width="80px" label-position="right"
                       :model="loginForm" :rules="rules" ref="loginForm" class="demo-ruleForm">

                <el-form-item label="登陆接口名称" prop="interfaceName">
                  <el-input suffix-icon="el-icon-edit" v-model="loginForm.interfaceName"
                  ></el-input>
                </el-form-item>

                <el-form-item label="请求地址" prop="url">
                  <el-input suffix-icon="el-icon-edit" v-model="loginForm.url"
                  ></el-input>
                </el-form-item>

                <el-form-item label="请求头" prop="header">
                  <el-input suffix-icon="el-icon-edit" v-model="loginForm.header"
                  ></el-input>
                </el-form-item>

                <el-form-item label="登陆方式" prop="loginWay">
                  <el-input suffix-icon="el-icon-edit" v-model="loginForm.loginWay"
                  ></el-input>
                </el-form-item>
              </el-form>


              <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="submitForm('loginForm')"
                    >确 定</el-button>
            <el-button @click="closeDialog('loginForm')">取 消</el-button>

  </span>
            </el-dialog>
          </el-main>
          <el-footer>xxx私人所有 版本所有：Server of test</el-footer>
        </el-container>
      </el-container>
    </el-container>

  </div>
</template>

<script>
    export default {
        name: "LoginInterface",
        data() {
            return {
                loginForm: {
                    "interfaceName": "",
                    "url": "",
                    "header": "",
                    "loginWay": "",
                },
                rules: {
                    interfaceName: [{required: true, message: "登陆接口名称不能为空", trigger: 'blur'}],
                    url: [{required: true, message: "请求地址不能为空", trigger: 'blur'}],
                    header: [{required: true, message: "请求头不能为空", trigger: 'blur'}],
                    loginWay: [{required: true, message: "登陆方式不能为空", trigger: 'blur'}],
                },
                dialogVisible: false,
                dialogTitle: "",
                isEdit: false,
                total: 0,
                pageSize: 10,
                currentPage: 1,
                pageLoginList: [],
                interfaceName: "",
            }
        },


        mounted() {
            this.getPageLogin();
            // this.getUrl();
        },


        methods: {
            handleSizeChange(size) {
                this.pageSize = size;
                this.getPageLogin();
            },


            handleCurrentChange(page) {
                this.currentPage = page;
                this.getPageLogin();
            },

            changeSwitch(row) {
                let that = this;
                that.loginForm.switchs = row.switchs;
                that.$axios.put("/login/update/" + row.id, row).then(function (res) {
                    if (res.data.code === 20000) {
                        that.$message({
                            message: res.data.message,
                            type: 'success'
                        });
                        that.dialogVisible = false;
                        that.getPageLogin();
                        that.reload();
                    } else {
                        that.$message({
                            message: res.data.message,
                            type: 'warning'
                        });
                    }
                }).catch(function (err) {

                })

            },


            getPageLogin() {
                let that = this;
                that.pageLoginList = [];
                that.$axios.get("/login/all", {
                    params: {
                        "page": that.currentPage,
                        "size": that.pageSize
                    }
                }).then(function (res) {
                    that.pageLoginList = res.data.data.data;
                    that.total = res.data.data.total;
                }).catch(function (err) {
                    console.log(err)
                })
            },

            closeDialog(formName) {
                this.$refs[formName].resetFields();
                this.dialogVisible = false;
            },

            addLogin() {
                let that = this;
                that.loginForm = {};
                that.dialogVisible = true;
                that.dialogTitle = "新增模块";
                that.isEdit = false;
                // that.getModule();
                that.getHeader();
                // that.getAllCaseName();
            },

            updateLogin(row) {
                let that = this;
                that.loginForm = {};
                that.dialogVisible = true;
                that.dialogTitle = "修改模块";
                that.isEdit = true;
                that.loginForm = JSON.parse(JSON.stringify(row));
                // that.getModule();
                that.getHeader();
                // that.getAllCaseName();

            },

            getModule() {
                let that = this;
                that.$axios.get("/module/all", {
                    params: {
                        "page": that.currentPage,
                        "size": that.pageSize
                    }
                }).then(function (res) {
                    that.moduleList = res.data.data.data;
                }).catch(function (err) {

                })
            },

            getHeader() {
                let that = this;
                that.$axios.get("/header/all", {
                    params: {
                        "page": that.currentPage,
                        "size": that.pageSize
                    }
                }).then(function (res) {
                    that.headerList = res.data.data.data;
                }).catch(function (err) {

                })
            },

            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        if (this.isEdit) {
                            this.editLogin();
                        } else {
                            this.createLogin();
                        }
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                })
            },


            editLogin() {
                let that = this;
                that.$axios.put("/login/update/" + that.loginForm.id, that.loginForm).then(function (res) {
                    if (res.data.code === 20000) {
                        that.$message({
                            message: res.data.message,
                            type: 'success'
                        });
                        that.dialogVisible = false;
                        that.getPageLogin();
                        that.reload();
                    } else {
                        that.$message({
                            message: res.data.message,
                            type: 'warning'
                        });
                    }
                }).catch(function (err) {

                })
            },

            createLogin() {
                let that = this;
                that.$axios.post("/login/add", that.loginForm).then(function (res) {
                    if (res.data.code === 20000) {
                        that.$message({
                            message: res.data.message,
                            type: 'success'
                        });
                        that.dialogVisible = false;
                        that.getPageLogin();
                        that.reload();
                    } else {
                        that.$message({
                            message: res.data.message,
                            type: 'warning'
                        });
                    }
                }).catch(function (err) {

                })
            },

            deleteLogin(row) {
                let that = this;
                that.loginForm = JSON.parse(JSON.stringify(row));
                that.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    that.$axios.delete('/login/delete/' + that.loginForm.id).then(function (res) {
                        if (res.data.code === 20000) {
                            that.$message({
                                type: 'success',
                                message: res.data.message
                            });
                            that.dialogVisible = false;
                            that.getPageLogin();
                            that.reload();
                        }
                    }).catch(function (err) {

                        console.log(err)
                        that.$message.error(err);
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },

            handleSelectionChange(multipleSelection) {
                this.multipleSelection = multipleSelection;
            },

            delectLogins() {
                let that = this;
                that.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    that.idList = [];
                    that.multipleSelection.forEach(i => {
                        that.idList.push(i.id)
                    });
                    // this.delete_status = true;
                    that.$axios.delete('/login/deletes', {
                        data: {
                            "ids": that.idList,
                        }
                    }).then((res) => {
                        if(res.data.code === 20000) {
                            that.getPageLogin();
                            that.reload();
                            this.$message({
                                type: 'success',
                                message: '删除成功!'
                            });
                            that.idList = [];
                        }
                    }).catch((err) => {
                        console.log(err)
                    })

                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                    that.idList = [];
                });
            },

            searchLogin: function () {
                let that = this;
                that.$axios.get("/login/search", {
                    params: {
                        "interfaceName": that.interfaceName,
                        "page": that.currentPage,
                        "size": that.pageSize
                    }
                }).then(function (res) {
                    if (res.data.code === 20000) {
                        that.pageLoginList = res.data.data.data;
                        that.total = res.data.data.total;
                        if (that.total === 0) {
                            that.pageSize = 10;
                            that.currentPage = 1;
                            that.reload();
                        }
                    }
                }).catch(function (err) {

                })
            }
        }
    }
</script>

<style scoped>
  html, body, #app, .el-container {
    margin: 0px;
    padding: 0px;
    height: 100%;
  }

  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
  }

  body > .el-container {
    margin-bottom: 40px;
    margin: 0px;
    padding: 0px;
    height: 100%;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

  .el-table .cell {
    white-space: nowrap;
  / / 强制不换行 overflow: hidden;
  / / 溢出隐藏 text-overflow: ellipsis / / 替换为省略号
  }
</style>
