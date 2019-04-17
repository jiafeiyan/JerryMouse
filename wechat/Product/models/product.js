import {
  HTTP
} from '../utils/http-p.js'

class ProductModel extends HTTP {
  // 查询所有商品信息
  getAllProduct() {
    return this.request({
      url: "product/"
    })
  }
  // 根据ID查询商品信息
  getProductById(pid) {
    return this.request({
      url: `product/${pid}`
    })
  }
}

export {
  ProductModel
}