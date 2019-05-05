package com.yimi.pospay.ui.login.model.respones;


import com.yimi.pospay.ui.login.model.Login;

/**
 * @author 000432
 * @date 2017/4/28
 * 登录返回
 */
public class LoginResponse {
  private boolean success;
  private String[] errorMessages;
  private int errorCode;
  private Login data;

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String[] getErrorMessages() {
    return errorMessages;
  }

  public void setErrorMessages(String[] errorMessages) {
    this.errorMessages = errorMessages;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public Login getData() {
    return data;
  }

  public void setData(Login data) {
    this.data = data;
  }
}
