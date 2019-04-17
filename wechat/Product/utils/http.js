import {
  config
} from '../config.js'

const tips = {
  10001: "抱歉,出现了一个意外错误",
  10002: "暂无数据"
}

class HTTP {
  request(params) {
    wx.request({
      url: config.api_base_url + params.url,
      method: params.method,
      data: params.data,
      header: {
        'content-type': 'application/json'
      },
      success: (res) => {
        let code = res.statusCode.toString();
        if (code.startsWith('2')) {
          params.success && params.success(res.data);
        } else {
          let error_code = res.data.error_code;
          this._show_error(error_code);
        }
      },
      fail: (err) => {
        this._show_error(1);
      }
    })
  }

  _show_error(error_code) {
    if (!(error_code in tips)) {
      error_code = 1
    }
    wx.showToast({
      title: tips[error_code],
      icon: 'none',
      duration: 2000
    })
  }
}

export {
  HTTP
}