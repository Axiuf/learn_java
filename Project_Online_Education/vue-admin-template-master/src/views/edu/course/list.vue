<template>
    <div class="app-container">
                  <!--查询表单-->
    <h2>课程列表</h2>

      <!--查询表单-->
<el-form :inline="true" class="demo-form-inline">

  <!-- 所属分类：级联下拉列表 -->
  <!-- 一级分类 -->
  <el-form-item label="课程类别">
    <el-select
      v-model="courseQuery.subjectParentId"
      placeholder="请选择"
      @change="subjectLevelOneChange">
      <el-option
        v-for="subject in primarySubjectList"
        :key="subject.id"
        :label="subject.title"
        :value="subject.id"/>
    </el-select>

    <!-- 二级分类 -->
    <el-select v-model="courseQuery.subjectId" placeholder="请选择" @change="forceChange()">
      <el-option
        v-for="subject in secondarySubjectList"
        :key="subject.id"
        :label="subject.title"
        :value="subject.id"/>
    </el-select>
  </el-form-item>

  <!-- 标题 -->
  <el-form-item label="课程标题">
    <el-input v-model="courseQuery.title" placeholder="课程标题"/>
  </el-form-item>
  <!-- 讲师 -->
  <el-form-item label="请选择讲师">
    <el-select
      v-model="courseQuery.teacherId"
      placeholder="请选择讲师">
      <el-option
        v-for="teacher in teacherList"
        :key="teacher.id"
        :label="teacher.name"
        :value="teacher.id"/>
    </el-select>
  </el-form-item>

  <el-button type="primary" icon="el-icon-search" @click="getList()">查询</el-button>
  <el-button type="default" @click="resetData()">清空</el-button>
</el-form>

        
<!-- 表格 -->
<el-table
  :data="list"
  element-loading-text="数据加载中"
  border
  fit
  highlight-current-row>

  <el-table-column
    label="序号"
    width="70"
    align="center">
    <template slot-scope="scope">
      {{ (page - 1) * limit + scope.$index + 1 }}
    </template>
  </el-table-column>

  <el-table-column label="课程信息" width="250" align="center">
    <template slot-scope="scope">
      <div class="info">
        <!-- <div class="pic">
          <img :src="scope.row.cover" alt="scope.row.title" width="150px">
        </div> -->
        <div class="title">
          <a href="">{{ scope.row.title }}</a>
        </div>
      </div>
    </template>
  </el-table-column>

  <el-table-column label="课时" align="center">
    <template slot-scope="scope">
      {{ scope.row.lessonNum }}
    </template>
  </el-table-column>

  <el-table-column label="创建时间" align="center">
    <template slot-scope="scope">
      {{ scope.row.gmtCreate.substr(0, 10) }}
    </template>
  </el-table-column>

  <el-table-column label="发布时间" align="center">
    <template slot-scope="scope">
      {{ scope.row.gmtModified.substr(0, 10) }}
    </template>
  </el-table-column>
  <el-table-column label="价格" width="100" align="center" >
    <template slot-scope="scope">
      {{ Number(scope.row.price) === 0 ? '免费' :
      '¥' + scope.row.price.toFixed(2) }}
    </template>
  </el-table-column>
  <el-table-column prop="buyCount" label="付费学员" width="100" align="center" >
    <template slot-scope="scope">
      {{ scope.row.buyCount }}人
    </template>
  </el-table-column>

  <el-table-column label="操作" width="150" align="center">
    <template slot-scope="scope">
      <router-link :to="'/course/info/'+scope.row.id">
        <el-button type="text" size="mini" icon="el-icon-edit">编辑课程信息</el-button>
      </router-link>
      <router-link :to="'/course/chapter/'+scope.row.id">
        <el-button type="text" size="mini" icon="el-icon-edit">编辑课程大纲</el-button>
      </router-link>
      <el-button type="text" size="mini" icon="el-icon-delete" @click="removeCourseById(scope.row.id)">删除</el-button>
    </template>
  </el-table-column>
</el-table>
       <!-- 分页 -->
    <el-pagination
      background
      :current-page="page"
      :page-size="limit"
      :total="total"
      style="padding: 30px 0; text-align: center;"
      layout="total, prev, pager, next, jumper"
      @current-change="getList"
    />
    </div>
</template>

<script>
import course from '@/api/edu/course'
import subject from '@/api/edu/subject'

export default {
    // 写核心代码
    data() {
        return {
            list:null,
            page:1,
            limit:7,
            total:0, 
            courseQuery:{
            },
            primarySubjectList: [],
            teacherList: [],
            secondarySubjectList: []

        }
    },

    created() {
        this.getList()
        this.getListTeacher()
        this.getPrimarySubject()
    },

    

    methods:{

      forceChange(){
         this.$forceUpdate()
      },

      subjectLevelOneChange(value){
          for (var i = 0; i < this.primarySubjectList.length; i++)
          {
              var primary = this.primarySubjectList[i]
                if (value === primary.id){
                    this.secondarySubjectList = primary.children
                    this.courseQuery.subjectId = ''
                }
          }
      },

      getPrimarySubject(){
          subject.getSubjectList()
            .then(response => {
                this.primarySubjectList = response.data.list
            })
      },

      getListTeacher() {
          course.getListTeacher()
            .then(response => {
                this.teacherList = response.data.items
            })
      }, 

        getList(page = 1) {
            this.page = page
            course.getCourseListPage(this.page, this.limit, this.courseQuery)
            .then(response => {
                // 请求成功
                this.list = response.data.rows
                this.total = response.data.total
            })
            .catch(error => {
                console.log(error) // 请求失败
            })
        },

        resetData() {
            this.courseQuery = {}
            this.getList()
        },

        removeCourseById(id) {
            this.$confirm('此操作将永久删除课程记录, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    course.deleteCourseById(id)
                        .then(response => {
                            this.$message({
                            type: 'success',
                            message: '删除成功!'
                            })
                            this.getList()
                        });
                    
                    
                })
        }
    }
}
</script>