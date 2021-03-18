import request from '@/utils/request'

export default {
    addVideo(video) {
        return request({
            url: '/eduservice/edu-video/addVideo',
            method: 'post', 
            data:video
        })
    },

    deleteVideo(id)
    {
        return request({
            url: '/eduservice/edu-video/deleteVideo/' + id,
            method: 'delete', 
        })
    },

    deleteAliVideo(id) {
        return request({
            url: '/eduvod/video/removeAliVideo/' + id,
            method: 'delete', 
        })
    },

}