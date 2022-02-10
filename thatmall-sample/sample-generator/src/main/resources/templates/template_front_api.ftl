import request from '@/utils/request'

export function save(data) {
  return request({
    url: 'api/${tableInfo.moduleName}/${tableInfo.className?uncap_first}/save',
    method: 'post',
    data
  })
}

export function del(ids) {
  return request({
    url: 'api/${tableInfo.moduleName}/${tableInfo.className?uncap_first}/delete',
    method: 'post',
    data: ids
  })
}

export function update(data) {
  return request({
    url: 'api/${tableInfo.moduleName}/${tableInfo.className?uncap_first}/update',
    method: 'post',
    data
  })
}

export function get(id) {
  return request({
    url: 'api/${tableInfo.moduleName}/${tableInfo.className?uncap_first}/get',
    method: 'post',
    data: id
  })
}


export function get(id) {
  return request({
    url: 'api/${tableInfo.moduleName}/${tableInfo.className?uncap_first}/get',
    method: 'post',
    data: id
  })
}
export default { save, update, del, get }
