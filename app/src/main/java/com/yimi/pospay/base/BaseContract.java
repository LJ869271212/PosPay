package com.yimi.pospay.base;

import android.content.Context;

/**
 * @author 000432
 */

public interface BaseContract {
  /**
   * MVP 基础View
   */
  interface BaseView {
    /**
     * 获取当前Activity的上下文
     *
     * @return 上下文 context
     */
    Context getContext();

    /**
     * 获取当前Activity的类名作为TAG，可作为请求标签，日志标签
     *
     * @return 当前Activity的类名 tag
     */
    String getTAG();
  }

  /**
   * MVP 基础业务接口
   */
  interface BaseBiz {
    Context getContext();
  }

  /**
   * MVP 基础控制层
   */
  interface BasePresenter {

  }
}
