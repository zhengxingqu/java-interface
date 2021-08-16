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
                    <el-input placeholder="输入查询条件" v-model="email"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-button-group>
                    <el-button type="primary" icon="el-icon-search" @click="searchUser()">查询</el-button>
                    <el-button type="primary" icon="el-icon-share" @click="getPageUser()">全部</el-button>
                    <el-button type="primary" icon="el-icon-plus" @click="addUser()">添加</el-button>
                  </el-button-group>
                </el-col>
              </el-row>
            </el-form>

            <el-table
              :data="pageUserList"
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
                prop="email"
                label="邮箱"
                width="60">
              </el-table-column>
              <el-table-column
                prop="username"
                label="用户名"
                width="80">
              </el-table-column>
              <el-table-column
                prop="registerTime"
                label="注册时间"
                width="80">
              </el-table-column>
              <el-table-column
                label="操作">
                <template slot-scope="scope">
                  <el-button type="success" size="mini" @click="updateUser(scope.row)">编辑</el-button>
                  <el-button type="info" size="mini" @click="deleteUser(scope.row)">删除</el-button>
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
                       :model="userForm" :rules="rules" ref="userForm" class="demo-ruleForm">
                <el-form-item label="邮箱" prop="email">
                  <el-input suffix-icon="el-icon-edit" v-model="userForm.email"
                  ></el-input>
                </el-form-item>

                <el-form-item label="用户名" prop="username">
                  <el-input suffix-icon="el-icon-edit" v-model="userForm.username"
                  ></el-input>
                </el-form-item>

                <el-form-item label="密码" prop="password">
                  <el-input suffix-icon="el-icon-edit" v-model="userForm.password" show-password>
                    >
                  </el-input>
                </el-form-item>
              </el-form>


              <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="submitForm('userForm')"
                    >确 定</el-button>
            <el-button @click="closeDialog('userForm')">取 消</el-button>

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
        name: "User",
        data() {
            return {
                userForm: {
                    "username": "",
                    "password": "",
                    "email": ""
                },
                rules: {
                    username: [{required: true, message: "用户名不能为空", trigger: 'blur'}],
                    email: [{required: true, message: "邮箱不能为空", trigger: 'blur'},
                        {
                            pattern: /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g,
                            message: "请输入正确的邮箱",
                            trigger: "blur"
                        }],
                    password: [{required: true, message: "密码不能为空", trigger: 'blur'}],


                },
                dialogVisible: false,
                dialogTitle: "",
                isEdit: false,
                total: 0,
                pageSize: 10,
                currentPage: 1,
                pageUserList: [],
                email: "",
            }
        },

        mounted() {
            this.getPageUser();
        },


        methods: {
            handleSizeChange(size) {
                this.pageSize = size;
                this.getPageUser();
            },

            handleCurrentChange(page) {
                this.currentPage = page;
                this.getPageUser();
            },

            getPageUser() {
                let that = this;
                that.pageUserList = [];
                that.$axios.get("/user/all", {
                    params: {
                        "page": that.currentPage,
                        "size": that.pageSize
                    }
                }).then(function (res) {
                    console.log(res)
                    that.pageUserList = res.data.data.data
                    that.total = res.data.data.total;
                }).catch(function (err) {
                    console.log(err)
                })
            },

            closeDialog(formName) {
                this.dialogVisible = false;
            },

            addUser() {
                let that = this;
                that.userForm = {};
                that.dialogVisible = true;
                that.dialogTitle = "新增模块";
                that.isEdit = false;
            },

            updateUser(row) {
                let that = this;
                that.userForm = {};
                that.dialogVisible = true;
                that.dialogTitle = "修改模块";
                that.isEdit = true;
                this.userForm = JSON.parse(JSON.stringify(row));
            },

            submitForm() {
                if (this.isEdit === true) {
                    this.editUser();
                } else {
                    this.createUser();
                }
            },

            editUser() {
                let that = this;
                that.$axios.put("/user/update/" + that.userForm.id, that.userForm).then(function (res) {
                    if (res.data.code === 20000) {
                        that.$message({
                            message: res.data.message,
                            type: 'success'
                        });
                        that.dialogVisible = false;
                        that.getPageUser();
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

            createUser() {
                let that = this;
                that.userForm.password = that.$md5(that.userForm.password);
                that.$axios.post("/user/add", that.userForm).then(function (res) {
                    if (res.data.code === 20000) {
                        that.$message({
                            message: res.data.message,
                            type: 'success'
                        });
                        that.dialogVisible = false;
                        that.getPageUser();
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

            deleteUser(row) {
                let that = this;
                that.userForm = JSON.parse(JSON.stringify(row));
                that.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    that.$axios.delete('/user/delete/' + that.userForm.id).then(function (res) {
                        if (res.data.code === 20000) {
                            that.$message({
                                type: 'success',
                                message: res.data.message
                            });
                            that.dialogVisible = false;
                            that.getPageUser();
                            that.reload();
                        }
                    }).catch(function (err) {
                        that.$message.error(res.data.message);
                    })
                    // this.$message({
                    //     type: 'success',
                    //     message: '删除成功!'
                    // });
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            searchUser: function () {
                let that = this;
                that.$axios.get("/user/search", {
                    params: {
                        "email": that.email,
                        "page": that.currentPage,
                        "size": that.pageSize
                    }
                }).then(function (res) {
                    if (res.data.code === 20000) {
                        that.pageUserList = res.data.data.data;
                        that.total = res.data.data.total;
                        if (that.total === 0) {
                            that.pageSize = 10;
                            that.currentPage = 1;
                            that.reload();
                        }
                    }

                }).catch(function (err) {

                })
            },

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
</style>
