package com.landi.unioncodepay;

interface UnionCodePay {
    String enterMainPage();                         // 进入主页
    String scan(String jsonData);                   // 扫码交易
    String qrcode(String jsonData);                 // 二维码交易
    String refund(String jsonData);                 // 退款
    String query(String jsonData);                  // 查询交易

}