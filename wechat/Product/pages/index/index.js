// pages/index/index.js
import {
  ProductModel
} from '../../models/product.js'
let productModel = new ProductModel();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    carouselList: [{
        src: "/images/product/banner3.jpg",
        background: "rgb(203, 87, 60)",
      },
      {
        src: "/images/product/banner2.jpg",
        background: "rgb(205, 215, 218)",
      },
      {
        src: "/images/product/banner4.jpg",
        background: "rgb(183, 73, 69)",
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
      productModel.getAllProduct().then(res=>{
        console.log("res is ===" + res);
      })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})