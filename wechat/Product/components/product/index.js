// components/product/index.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    product:Object
  },

  /**
   * 组件的初始数据
   */
  data: {

  },

  /**
   * 组件的方法列表
   */
  methods: {
    onTap(event) {
      wx.navigateTo({
        url: '/pages/product_detail/index'
      })
    }
  }
})