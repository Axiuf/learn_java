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
    }
}