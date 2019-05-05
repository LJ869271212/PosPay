package com.yimi.pospay.ui.login.model.request;

/**
 * @author 000432
 * @date 2017/4/6
 * 登录请求
 */
public class LoginRequest {
  /** 公司code */
  private String compCode;
  /** 工号 */
  private String workNum;
  /** 密码 */
  private String password;
  /** 验证码 */
  private String captcha;
  /** pc:1/app:2/ */
  private String appType;

  public LoginRequest(String compCode, String workNum, String password, String captcha, String appType) {
    this.compCode = compCode;
    this.workNum = workNum;
    this.password = password;
    this.captcha = captcha;
    this.appType = appType;
  }

  public LoginRequest() {
  }

  public String getCompCode() {
    return compCode;
  }

  public void setCompCode(String compCode) {
    this.compCode = compCode;
  }

  public String getWorkNum() {
    return workNum;
  }

  public void setWorkNum(String workNum) {
    this.workNum = workNum;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getCaptcha() {
    return captcha;
  }

  public void setCaptcha(String captcha) {
    this.captcha = captcha;
  }

  public String getAppType() {
    return appType;
  }

  public void setAppType(String appType) {
    this.appType = appType;
  }
}
