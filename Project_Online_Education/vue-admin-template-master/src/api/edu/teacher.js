import request from '@/utils/request'

export default {
    getTeacherListPage(page, limit, teacherQuery) {
        return request({
            url: `/eduservice/edu-teacher/pageTeacherCondition/${page}/${limit}`,
            method: 'post', 
            
            data: teacherQuery,
        })
    },

    deleteTeacherById(id) {
        return request({
            url: `/eduservice/edu-teacher/remove/${id}`,
            method: 'delete',
        })
    },

    addTeacher(teacher) {
        return request({
            url: `/eduservice/edu-teacher/add`,
            method: 'post',
            data: teacher
        })
    },

    getTeacherInfo(id) {
        return request({
            url: `/eduservice/edu-teacher/getTeacher/${id}`,
            method: 'get'
        })
    },

    updateTeacher(teacher) {
        return request({
            url: `/eduservice/edu-teacher/updateTeacher`,
            method: 'post',
            data: teacher
        })
    }
}