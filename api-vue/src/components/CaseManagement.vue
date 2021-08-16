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
                    <el-input placeholder="输入查询条件" v-model="caseName"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-button-group>
                    <el-button type="primary" icon="el-icon-search" @click="searchCase()">查询</el-button>
                    <el-button type="primary" icon="el-icon-share" @click="getPageCase()">全部</el-button>
                    <el-button type="primary" icon="el-icon-plus" @click="addCase()">添加</el-button>

                  </el-button-group>
                </el-col>
                <el-col :span="2">
                  <el-upload
                    class="upload-demo"
                    action=""
                    :show-file-list="false" :http-request="UploadCaseExcel"
                    accept=".xlsx,.xls"
                    :before-upload="beforeExcelUpload">
                    <el-button type="primary">点击上传</el-button>
                  </el-upload>
                </el-col>
                <el-col :span="2">
                <el-button type="primary" @click="downloadExcel()">下载</el-button>
                </el-col>
                <el-col :span="4">
                <el-select v-model="envName" placeholder="请选择环境名称">
                  <el-option
                    v-for="item in urlList"
                    :key="item.environmentalName"
                    :label="item.environmentalName"
                    :value="item.environmentalName">
                  </el-option>
                </el-select>
                </el-col>

                <el-col :span="4">
                  <el-select v-model="projectName" placeholder="请选择项目名称" @change="findProjectName">
                    <el-option
                      v-for="item in projectList"
                      :key="item.projectName"
                      :label="item.projectName"
                      :value="item.projectName">
                    </el-option>
                  </el-select>
                </el-col>


              </el-row>

            </el-form>

            <el-table
              :data="pageCaseList"
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
                prop="projectName"
                label="项目名称"
                width="60">
              </el-table-column>
              <el-table-column
                prop="moduleName"
                label="模块名称"
                width="60">
              </el-table-column>
              <el-table-column
                prop="caseName"
                label="用例名称"
                width="60">
              </el-table-column>
              <el-table-column
                prop="header"
                label="请求头"
                width="60" :show-overflow-tooltip="true">
              </el-table-column>
              <el-table-column
                prop="requestMethod"
                label="请求方式"
                width="60">
              </el-table-column>
              <el-table-column
                prop="result"
                label="结果"
                width="60">
              </el-table-column>
              <el-table-column
                prop="createTime"
                label="创建时间"
                width="80">
              </el-table-column>
              <el-table-column
                prop="errorResponse"
                label="错误信息"
                width="80" :show-overflow-tooltip="true">
              </el-table-column>
              <el-table-column label="是否调用其他用例" prop="switchs">
                <template slot-scope="scope">
                  <el-switch
                    v-model="scope.row.switchs"
                    active-color="#02538C"
                    inactive-color="#B9B9B9"
                    @change="changeSwitch(scope.row)"/>
                </template>
              </el-table-column>
              <el-table-column
                label="操作">
                <template slot-scope="scope">
                  <el-button type="success" size="mini" @click="updateCase(scope.row)">编辑</el-button>
                  <el-button type="info" size="mini" @click="deleteCase(scope.row)">删除</el-button>
                  <el-button type="info" size="mini" @click="runInterface(scope.row)">运行</el-button>
                  <el-button type="info" size="mini" @click="copyCase(scope.row)">复制</el-button>
                </template>
              </el-table-column>
            </el-table>

            <el-row>
              <el-col :span="8" style="text-align: left">
                <el-button type="danger" icon="el-icon-delete" size="mini" style="margin-top: 20px"
                           @click="delectCases()">批量删除
                </el-button>
                <el-button icon="el-icon-delete" type="primary" size="mini" style="margin-top: 20px"
                           @click="runManyInterfaces()">批量运行
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
                       :model="caseForm" :rules="rules" ref="caseForm" class="demo-ruleForm">
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

                <el-form-item label="模块名称" prop="moduleName">
                  <el-select v-model="caseForm.moduleName" placeholder="请选择">
                    <el-option
                      v-for="item in moduleList"
                      :key="item.moduleName"
                      :label="item.moduleName"
                      :value="item.moduleName">
                    </el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="用例名称" prop="caseName">
                  <el-input suffix-icon="el-icon-edit" v-model="caseForm.caseName"
                  ></el-input>
                </el-form-item>
                <el-form-item label="请求地址" prop="url">
                  <el-input suffix-icon="el-icon-edit" v-model="caseForm.url"
                  ></el-input>
                </el-form-item>
                <el-form-item label="请求头" prop="header">
                  <el-select v-model="caseForm.header" placeholder="请选择">
                    <el-option
                      v-for="item in headerList"
                      :key="item.header"
                      :label="item.header"
                      :value="item.header">
                    </el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="请求方式" prop="requestMethod">
                  <el-select v-model="caseForm.requestMethod" placeholder="请选择">
                    <el-option
                      v-for="item in requestMethodList"
                      :key="item"
                      :label="item"
                      :value="item">
                    </el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="请求参数" prop="requestParam">
                  <el-input suffix-icon="el-icon-edit" v-model="caseForm.requestParam"
                  ></el-input>
                </el-form-item>
                <el-form-item label="校验方式" prop="assertMethod">
                  <el-select v-model="caseForm.assertMethod" placeholder="请选择">
                    <el-option
                      v-for="item in assertMethodList"
                      :key="item"
                      :label="item"
                      :value="item">
                    </el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="期望结果" prop="resultAssert">
                  <el-input suffix-icon="el-icon-edit" v-model="caseForm.resultAssert"
                  ></el-input>
                </el-form-item>
                <el-form-item label="正则名称" prop="regexName">
                  <el-input suffix-icon="el-icon-edit" v-model="caseForm.regexName"
                  ></el-input>
                </el-form-item>
                <el-form-item label="正则表达式" prop="regex">
                  <el-input suffix-icon="el-icon-edit" v-model="caseForm.regex"
                  ></el-input>
                </el-form-item>
                <el-form-item label="其他用例" prop="quoteCase">
                  <el-select v-model="caseForm.quoteCase" multiple filterable>
                    <el-option
                      v-for="caseName in quoteCaseList"
                      :key="caseName"
                      :value="caseName"
                      filterable
                      :disabled="caseName === caseForm.caseName ? disable = true: disable = false">
                    </el-option>
                  </el-select>
                </el-form-item>
              </el-form>

              <span slot="footer" class="dialog-footer">
                    <el-button type="primary" @click="submitForm('caseForm')"
                    >确 定</el-button>
            <el-button @click="closeDialog('caseForm')">取 消</el-button>

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
        name: "CaseManagement",
        data() {
            return {
                caseForm: {
                    "caseName": "",
                    "header": "",
                    "requestMethod": "",
                    "moduleName": "",
                    "requestParam": "",
                    "assertMethod": "",
                    "resultAssert": "",
                    "url": "",
                    "regex": "",
                    "quoteCase": "",
                    "switchs": false,
                    "regexName": "",

                },
                rules: {
                    caseName: [{required: true, message: "用例名称不能为空", trigger: 'blur'}],
                    header: [{required: true, message: "请求头不能为空", trigger: 'blur'}],
                    requestMethod: [{required: true, message: "请求方式不能为空", trigger: 'blur'}],
                    moduleName: [{required: true, message: "模块名称不能为空", trigger: 'blur'}],
                    requestParam: [{required: true, message: "请求参数不能为空", trigger: 'blur'}],
                    assertMethod: [{required: true, message: "校验方式不能为空", trigger: 'blur'}],
                    resultAssert: [{required: true, message: "期望结果不能为空", trigger: 'blur'}],
                    url: [{required: true, message: "请求地址不能为空", trigger: 'blur'}],

                },
                dialogVisible: false,
                dialogTitle: "",
                isEdit: false,
                total: 0,
                pageSize: 10,
                currentPage: 1,
                pageCaseList: [],
                caseName: "",
                assertMethodList: ["in", "=", "code"],
                moduleList: [],
                requestMethodList: ["post", "get", "put", "delete"],
                headerList: [],
                isRun: false,
                urlList: [],
                envName: "",
                multipleSelection: [],
                idList: [],
                interfaceList: [],
                quoteCaseList: [],
                disable: false,
                projectName: "",
                projectList: [],


            }
        },

        mounted() {
            this.getPageCase();
            this.getUrl();
            this.getAllProject();
        },


        methods: {
            handleSizeChange(size) {
                this.pageSize = size;
                this.getPageCase();
            },

            beforeExcelUpload(file) {
                // 打印file，帮助我们了解我们需要的参数
                console.log(file);
                const isExcel = file.name.split(".")[1] === "xlsx" || file.name.split(".")[1] === "xls";
                if (!isExcel) {
                    this.$message({
                        message: "只能上传xls或xlsx文件!",
                        type: "error"
                    });
                }
            },

            UploadCaseExcel(params) {
                let that = this;
                const fd = new FormData();
                fd.append("file", params.file);
                fd.append("FileName", params.file.name);
                // console.log(fd)
                // query是放在query中接收的参数，fd是放在了body中接收
                // that.$axios.post("/case/upload", {"excel": fd}).then(function (res) {
                //
                // }).catch(function (err) {
                //
                // })
                return that.$axios({
                    method: 'post',
                    url: '/case/upload',
                    // headers: {"Content-Type": "multipart/form-data"},
                    data: fd
                })
            },

            handleCurrentChange(page) {
                this.currentPage = page;
                this.getPageProject();
            },

            getAllCaseName() {
                let that = this;
                that.$axios.get("/case/all/caseName").then(function (res) {
                    console.log(res);
                    that.quoteCaseList = res.data.data;
                }).catch(function (err) {

                })
            },

            changeSwitch(row) {
                let that = this;
                that.caseForm.switchs = row.switchs;
                that.$axios.put("/case/update/" + row.id, row).then(function (res) {
                    if (res.data.code === 20000) {
                        that.$message({
                            message: res.data.message,
                            type: 'success'
                        });
                        that.dialogVisible = false;
                        that.getPageCase();
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

            getAllProject(){
                let that = this;
                that.projectList = [];
                that.$axios.get("/project/all/projectName").then(function (res) {
                    console.log(res)
                    if(res.data.code === 20000){
                        that.projectList = res.data.data;
                        that.reload();
                    }
                }).catch(function (err) {

                })
            },

            // findProjectName(){
            //     let that = this;
            //     that
            // },

            getUrl() {
                let that = this;
                that.urlList = [];
                that.$axios.get("/environmental/all", {
                    params: {
                        "page": that.currentPage,
                        "size": that.pageSize
                    }
                }).then(function (res) {
                    that.urlList = res.data.data.data
                    that.total = res.data.data.total;
                }).catch(function (err) {
                    console.log(err)
                })

            },

            downloadExcel() {
                let that = this;
                that.idList = [];
                that.multipleSelection.forEach(i => {
                    that.idList.push(i.id)
                })

                that.$axios.post("/case/download", {"ids": that.idList}).then(function (res) {
                    if (res.data.code === 20000) {

                    }
                }).catch(function (err) {

                })
            },

            getPageCase() {
                let that = this;
                that.pageCaseList = [];
                that.$axios.get("/case/all", {
                    params: {
                        "page": that.currentPage,
                        "size": that.pageSize
                    }
                }).then(function (res) {
                    that.pageCaseList = res.data.data.data;
                    that.total = res.data.data.total;
                }).catch(function (err) {
                    console.log(err)
                })
            },

            closeDialog(formName) {
                this.$refs[formName].resetFields();
                this.dialogVisible = false;
            },

            addCase() {
                let that = this;
                that.caseForm = {};
                that.dialogVisible = true;
                that.dialogTitle = "新增模块";
                that.isEdit = false;
                that.getModule();
                that.getHeader();
                that.getAllCaseName();
            },

            updateCase(row) {
                let that = this;
                that.caseForm = {};
                that.dialogVisible = true;
                that.dialogTitle = "修改模块";
                that.isEdit = true;
                that.caseForm = JSON.parse(JSON.stringify(row));
                that.caseForm.quoteCase = JSON.parse(that.caseForm.quoteCase);
                console.log(that.caseForm.quoteCase);
                that.getModule();
                that.getHeader();
                that.getAllCaseName();

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
                            this.editCase();
                        } else {
                            this.createCase();
                        }
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                })
            },

            runInterface(row) {
                let that = this;
                that.caseForm = JSON.parse(JSON.stringify(row));
                this.$axios.post("/case/request/" + that.caseForm.id, {
                    "envName": that.envName,
                    "requestMethod": that.caseForm.requestMethod,
                    "requestParam": that.caseForm.requestParam,
                    "header": that.caseForm.header,
                    "resultAssert": that.caseForm.resultAssert,
                    "url": that.caseForm.url,
                    "assertMethod": that.caseForm.assertMethod,
                    "quoteCase": that.caseForm.quoteCase,
                    "switchs": that.caseForm.switchs
                }).then(function (res) {
                    if (res.data.code !== 20000) {
                        that.$message({
                            message: res.data.message,
                            type: 'success'
                        });
                    }
                    that.getPageCase();
                }).catch(function (err) {

                })
            },

            editCase() {
                let that = this;
                that.caseForm.quoteCase = JSON.stringify(that.caseForm.quoteCase);
                that.$axios.put("/case/update/" + that.caseForm.id, that.caseForm).then(function (res) {
                    if (res.data.code === 20000) {
                        that.$message({
                            message: res.data.message,
                            type: 'success'
                        });
                        that.dialogVisible = false;
                        that.getPageCase();
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

            createCase() {
                let that = this;
                that.caseForm.quoteCase = JSON.stringify(that.caseForm.quoteCase);
                that.$axios.post("/case/add", that.caseForm).then(function (res) {
                    if (res.data.code === 20000) {
                        that.$message({
                            message: res.data.message,
                            type: 'success'
                        });
                        that.dialogVisible = false;
                        that.getPageCase();
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

            deleteCase(row) {
                let that = this;
                that.caseForm = JSON.parse(JSON.stringify(row));
                that.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    that.$axios.delete('/case/delete/' + that.caseForm.id).then(function (res) {
                        if (res.data.code === 20000) {
                            that.$message({
                                type: 'success',
                                message: res.data.message
                            });
                            that.dialogVisible = false;
                            that.getPageCase();
                            that.reload();
                        }
                    }).catch(function (err) {

                        console.log(err)
                        that.$message.error(err);
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
                    // this.delete_status = true;
                    that.$axios.delete('case/deletes', {
                        data: {
                            "ids": that.idList,
                            "envName": that.envName
                        }
                    }).then((res) => {
                        // if (res.data !== '') {
                        //     this.delete_status = false
                        // }
                        that.getPageCase();
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

            runManyInterfaces() {
                let that = this;
                that.interfaceList = [];
                that.multipleSelection.forEach(i => {
                    that.interfaceList.push(i.id)
                });
                that.$axios.post('case/request', {
                    "ids": that.interfaceList,
                    "envName": that.envName
                }).then((res) => {
                    if (res.data.code === 20000) {
                        this.$message({
                            type: 'success',
                            message: '运行成功!'
                        });
                    } else {
                        that.$message.error(res.data.message);
                    }
                    that.interfaceList = [];
                    that.getPageCase();
                    that.$forceUpdate();
                }).catch((err) => {
                    that.$message.error(err.data.message);
                })
            },

            searchCase: function () {
                let that = this;
                that.$axios.get("/case/search", {
                    params: {
                        "caseName": that.caseName,
                        "page": that.currentPage,
                        "size": that.pageSize
                    }
                }).then(function (res) {
                    if (res.data.code === 20000) {
                        that.pageCaseList = res.data.data.data;
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

            copyCase(row) {
                let that = this;
                that.caseForm = JSON.parse(JSON.stringify(row));
                delete that.caseForm.id;
                that.$axios.post("/case/copy", that.caseForm).then(function (res) {
                    if (res.data.code === 20000) {
                        that.getPageCase();
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
