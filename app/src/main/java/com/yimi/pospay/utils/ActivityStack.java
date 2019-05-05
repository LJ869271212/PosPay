package com.yimi.pospay.utils;

import android.app.Activity;


import com.yimi.pospay.base.BaseActivity;

import java.util.Stack;

/**
 *
 * @author 000432
 * @date 2017/2/28
 * Description
 */
public final class ActivityStack {
  private Stack<BaseActivity> mActivities = new Stack<>();

  private static class LazyHolder {
    private static ActivityStack INSTANCE = new ActivityStack();
  }

  /**
   * Gets instance.
   *
   * @return the instance
   */
  public static ActivityStack getInstance() {
    return LazyHolder.INSTANCE;
  }

  /**
   * Add activity.
   *
   * @param activity the activity
   */
  public void addActivity(BaseActivity activity) {
    mActivities.add(activity);
  }

  /**
   * Current activity base activity.
   *
   * @return the base activity
   */
  public BaseActivity currentActivity() {
    BaseActivity activity = null;
    if (!mActivities.empty()) {
      activity = mActivities.lastElement();
    }
    return activity;
  }

  /**
   * Delete activity.
   *
   * @param activity the activity
   */
  public void deleteActivity(BaseActivity activity) {
    if (activity != null) {
      mActivities.remove(activity);
      // 取消请求
      // QueueHandler.getInstance().cancelAll(activity.getClass().getSimpleName());
      activity.finish();
      activity = null;
    }
  }

  /**
   * Exit.
   */
  public void exit() {
    for (Activity activity : mActivities) {
      activity.finish();
      activity = null;
    }
    mActivities.clear();
    //退出程序 (会导致出现异常时，重启应用程序两次)
    //android.os.Process.killProcess(android.os.Process.myPid());
//    System.exit(0);
  }
}
