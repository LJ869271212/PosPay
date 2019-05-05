package com.yimi.pospay.callbacks;

/**
 * @author 000432
 */

public abstract class UICallBack {

  public abstract void onError(String msg);

  public abstract void onSuccess(Object obj);

  public void onSuccess(Object obj, Object obj1) {
  }

  public void syncParseNetworkResponse(Object obj) {
  }

  public void onError(String msg, Object obj) {
  }
}
