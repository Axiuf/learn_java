import request from '@/utils/request'

export default {
    getAllChapter(courseId) {
        return request({
            url: '/eduservice/edu-chapter/getChapterVideo/' + courseId,
            method: 'get', 
        })
    },

    addChapter(chapter) {
        return request({
            url: '/eduservice/edu-chapter/addChapter',
            method: 'post', 
            data:chapter
        })
    },

    getChapterById(id) {
        return request({
            url: '/eduservice/edu-chapter/getChapterById/' + id,
            method: 'get', 
        })
    },

    updateChapter(chapter) {
        return request({
            url: '/eduservice/edu-chapter/updateChapter',
            method: 'post', 
            data:chapter
        })
    },

    deleteChapter(id) {
        return request({
            url: '/eduservice/edu-chapter/deleteChapter/' + id,
            method: 'delete', 
        })
    },
}