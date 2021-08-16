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
                    <el-input placeholder="输入查询条件" v-model="caseGroupName"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-button-group>
                    <el-button type="primary" icon="el-icon-search" @click="searchCaseGroup()">查询</el-button>
                    <el-button type="primary" icon="el-icon-share" @click="getPageCaseGroup()">全部</el-button>
                    <el-button type="primary" icon="el-icon-plus" @click="addCaseGroup()">添加</el-button>
                  </el-button-group>
                </el-col>
                <el-select v-model="envName" placeholder="请选择">
                  <el-option
                    v-for="item in urlList"
                    :key="item.environmentalName"
                    :label="item.environmentalName"
                    :value="item.environmentalName">
                  </el-option>
                </el-select>
              </el-row>

            </el-form>

            <el-table
              :data="pageCaseGroupList"
              style="width: 100%" @selection-change="handleSelectionChange">
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
                prop="caseGroupName"
                label="用例组名称"
                width="60">
              </el-table-column>
              <el-table-column
                prop="caseName"
                label="用例名称"
                width="60">
              </el-table-column>
              <el-table-column
                prop="regex"
                label="正则表达式"
                width="60">
              </el-table-column>
              <el-table-column
                label="操作">
                <template slot-scope="scope">
                  <el-button type="success" size="mini" @click="updateCaseGroup(scope.row)">编辑</el-button>
                  <el-button type="info" size="mini" @click="deleteCaseGroup(scope.row)">删除</el-button>
                  <el-button type="info" size="mini" @click="runInterfaceGroup(scope.row)">运行</el-button>
                  <el-button type="info" size="mini" @click="copyCaseGroup(scope.row)">复制</el-button>
                </template>
              </el-table-column>
            </el-table>

            <el-row>
              <el-col :span="8" style="text-align: left">
                <el-button type="danger" icon="el-icon-delete" size="mini" style="margin-top: 20px"
                           @click="delectCasesGroup()">批量删除
                </el-button>
                <el-button icon="el-icon-delete" type="primary" size="mini" style="margin-top: 20px"
                           @click="runManyInterfacesGroup()">批量运行
                </el-button>
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
                       :model="caseGroupForm" :rules="rules" ref="caseGroupForm" class="demo-ruleForm">
                <!--                <el-upload-->
                <!--                  class="avatar-uploader"-->
                <!--                  :show-file-list="false"-->
                <!--                  :http-request="UploadImage" :disabled="isView">-->
                <!--                  <img v-if="studentForm.image" :src="studentForm.imageUrl" class="avatar">-->
                <!--                  <i v-else class="el-icon-plus avatar-uploader-icon"></i>-->
                <!--                </el-upload>-->

                <!--                <el-form-item label="项目名称" prop="projectName">-->
                <!--                  <el-input suffix-icon="el-icon-edit" v-model="caseForm.projectName"-->
                <!--                  ></el-input>-->
                <!--                </el-form-item>-->

                <el-form-item label="用例名称" prop="caseName">
                  <el-autocomplete
                    class="inline-input"
                    v-model="caseGroupForm.caseName"
                    :fetch-suggestions="querySearch"
                    placeholder="请输入内容"
                    @select="handleSelect"
                  ></el-autocomplete>
                </el-form-item>
                <el-form-item label="用例组名称" prop="caseGroupName">
                  <el-input suffix-icon="el-icon-edit" v-model="caseGroupForm.caseGroupName"
                  ></el-input>
                </el-form-item>
                <el-form-item label="正则表达式" prop="regex">
                  <el-input suffix-icon="el-icon-edit" v-model="caseGroupForm.regex"
                  ></el-input>
                </el-form-item>
              </el-form>

              <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="submitForm('caseGroupForm')"
                    >确 定</el-button>
            <el-button @click="closeDialog('caseGroupForm')">取 消</el-button>

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
        name: "CaseGroupManagement",
        data() {
            return {
                caseGroupForm: {
                    "caseGroupName": "",
                    "caseName": "",
                    "regex": "",
                },
                rules: {
                    caseGroupName: [{required: true, message: "用例组名称不能为空", trigger: 'blur'}],
                    caseName: [{required: true, message: "用例名称不能为空", trigger: 'blur'}],
                },
                dialogVisible: false,
                dialogTitle: "",
                isEdit: false,
                total: 0,
                pageSize: 10,
                currentPage: 1,
                pageCaseGroupList: [],
                caseGroupName: "",
                isRun: false,
                urlList: [],
                envName: "",
                multipleSelection: [],
                idList: [],
                CaseGroupList: [],
                restaurants: [],

            }
        },

        mounted() {
            this.getPageCaseGroup();
            this.getUrl();
            this.searchCaseName();
        },

        methods: {
            handleSizeChange(size) {
                this.pageSize = size;
                this.getPageCaseGroup();
            },

            handleSelect(item) {
                console.log(item);
            },
            querySearch(queryString, cb) {
                var restaurants = this.restaurants;
                console.log(restaurants)
                var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
                // 调用 callback 返回建议列表的数据
                cb(results);
            },
            createFilter(queryString) {
                return (restaurant) => {
                    console.log(restaurant);
                    return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
                };
            },

            searchCaseName(){
                let that = this;
                that.$axios.get("/case/all/caseName").then(function (res) {
                    if(res.data.code === 20000){
                        that.restaurants = res.data.data;
                        console.log(that.restaurants)
                    }
                }).catch(function (res) {

                })
            },

        handleCurrentChange(page) {
            this.currentPage = page;
            this.getPageProject();
        },

        getUrl() {
            let that = this;
            that.urlList = [];
            that.$axios.get("/environmental/all", {
                params: {
                    "page": that.currentPage,
                    "size": that.pageSize
                }
            }).then(function (res) {
                console.log(res)
                that.urlList = res.data.data.data
                that.total = res.data.data.total;
            }).catch(function (err) {
                console.log(err)
            })
        },

        getPageCaseGroup() {
            let that = this;
            that.pageCaseGroupList = [];
            that.$axios.get("/caseGroup/all", {
                params: {
                    "page": that.currentPage,
                    "size": that.pageSize
                }
            }).then(function (res) {
                that.pageCaseGroupList = res.data.data.data;
                that.total = res.data.data.total;
            }).catch(function (err) {
                console.log(err)
            })
        },

        closeDialog(formName) {
            this.$refs[formName].resetFields();
            this.dialogVisible = false;
        },

        addCaseGroup() {
            let that = this;
            that.caseGroupForm = {};
            that.dialogVisible = true;
            that.dialogTitle = "新增用例组";
            that.isEdit = false;
        },

        updateCaseGroup(row) {
            let that = this;
            that.searchCaseName();
            that.caseGroupForm = {};
            that.dialogVisible = true;
            that.dialogTitle = "修改用例组";
            that.isEdit = true;
            this.caseGroupForm = JSON.parse(JSON.stringify(row));
        },

        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    if (this.isEdit) {
                        this.editCaseGroup();
                    } else {
                        this.createCaseGroup();
                    }
                } else {
                    console.log('error submit!!');
                    return false;
                }
            })
        },

        editCaseGroup() {
            let that = this;
            that.$axios.put("/caseGroup/update/" + that.caseGroupForm.id, that.caseGroupForm).then(function (res) {
                if (res.data.code === 20000) {
                    that.$message({
                        message: res.data.message,
                        type: 'success'
                    });
                    that.dialogVisible = false;
                    that.getPageCaseGroup();
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

        createCaseGroup() {
            let that = this;
            that.$axios.post("/caseGroup/add", that.caseGroupForm).then(function (res) {
                if (res.data.code === 20000) {
                    that.$message({
                        message: res.data.message,
                        type: 'success'
                    });
                    that.dialogVisible = false;
                    that.getPageCaseGroup();
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

        deleteCaseGroup(row) {
            let that = this;
            that.caseGroupForm = JSON.parse(JSON.stringify(row));
            that.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                that.$axios.delete('/caseGroup/delete/' + that.caseGroupForm.id).then(function (res) {
                    if (res.data.code === 20000) {
                        that.$message({
                            type: 'success',
                            message: res.data.message
                        });
                        that.dialogVisible = false;
                        that.getPageCaseGroup();
                        that.reload();
                    }
                }).catch(function (err) {
                    that.$message.error(res.data.message);
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

        delectCases() {
            let that = this;
            that.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                that.multipleSelection.forEach(i => {
                    that.idList.push(i.id)
                });
                that.$axios.delete('caseGroup/deletes', {
                    data: {
                        "ids": that.idList,
                        "envName": that.envName
                    }
                }).then((res) => {
                    that.getPageCaseGroup();
                    that.reload();
                    this.$message({
                        type: 'success',
                        message: '删除成功!'
                    });
                    that.idList = [];
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

        searchCaseGroup: function () {
            let that = this;
            that.$axios.get("/caseGroup/search", {
                params: {
                    "caseNameGroup": that.caseNameGroup,
                    "page": that.currentPage,
                    "size": that.pageSize
                }
            }).then(function (res) {
                if (res.data.code === 20000) {
                    that.pageCaseGroupList = res.data.data.data;
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

        copyCaseGroup(row) {
            let that = this;
            that.caseGroupForm = JSON.parse(JSON.stringify(row));
            delete that.caseGroupForm.id;
            that.$axios.post("/caseGroup/copy", that.caseGroupForm).then(function (res) {
                if (res.data.code === 20000) {
                    that.getPageCaseGroup();
                    that.$message.success("复制成功")
                }
            }).catch(function (err) {
                that.$message.success("复制失败")
            })
        }
    }
    }
</script>

<style scoped>

</style>
