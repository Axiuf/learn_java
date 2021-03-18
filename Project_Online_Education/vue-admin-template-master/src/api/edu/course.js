import request from '@/utils/request'

export default {
    saveCourseInfo(courseInfoVo) {
        return request({
            url: '/eduservice/edu-course/addCourseInfo',
            method: 'post', 
            data:courseInfoVo
        })
    },

    getListTeacher() {
        return request({
            url: '/eduservice/edu-teacher/findAll',
            method: 'get'
        })
    },

    getCourseInfo(courseId) {
        return request({
            url: `/eduservice/edu-course/getCourseInfo/${courseId}`,
            method: 'get'
        })
    },

    updateCourseInfo(courseInfo) {
        return request({
            url: '/eduservice/edu-course/updateCourseInfo',
            method: 'post',
            data: courseInfo
        })
    },

    getPublishCourseInfo(id) {
        return request({
            url: '/eduservice/edu-course/getPublishCourseInfo/' + id,
            method: 'get'
        })
    },

    publishCourse(id) {
        return request({
            url: '/eduservice/edu-course/publishCourse/' + id,
            method: 'post'
        })
    },

    getCourseList() {
        return request({
            url: '/eduservice/edu-course/getCourseList',
            method: 'get'
        })
    },

    getCourseListPage(page, limit, courseQuery) {
        return request({
            url: `/eduservice/edu-course/pageCourseCondition/${page}/${limit}`,
            method: 'post', 
            
            data: courseQuery,
        })
    },

    deleteCourseById(id) {
        return request({
            url: '/eduservice/edu-course/deleteCourseById/' + id,
            method: 'delete'
        })
    }
}