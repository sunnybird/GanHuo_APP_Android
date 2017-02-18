package cn.alpha.intell.ganhuo.ui.activities;

/**
 * @author : jinlongfeng
 * @version : V1.0.0
 * @description: 用户登录 视图接口
 * @time : 2017/2/18-23:26
 */

public interface IUserLoginView {
   void showProgress();
   void hidProgress();
   void showUserNameError();
   void showPasswdError();
   void loginSuccess();

}
