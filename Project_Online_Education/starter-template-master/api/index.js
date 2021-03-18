import request from '@/utils/request'
export default {
  getList() {
    return request({
      url: `/eduservice/index/getIndex`,
      method: 'get'
    })
  }
}