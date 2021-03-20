import request from '@/utils/request'
const api_name = '/eduservice/teacherfront'
export default {
  getPageList(page, limit) {   
    return request({
      url: `${api_name}/${page}/${limit}`,
      method: 'get'
    })
  },

  getById(teacherId) {
    return request({
        url: `${api_name}/${teacherId}`,
        method: 'get'
    })
}
}