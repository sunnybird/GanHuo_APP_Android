package cn.alpha.intell.ganhuo.present;

import cn.alpha.intell.ganhuo.common.CommonCallBack;
import cn.alpha.intell.ganhuo.config.ErrorCode;
import cn.alpha.intell.ganhuo.module.IUserModule;
import cn.alpha.intell.ganhuo.module.UserModule;
import cn.alpha.intell.ganhuo.ui.activities.IUserLoginView;

/**
 * @author : jinlongfeng
 * @version : V1.0.0
 * @description: 用户登录 控制实现
 * @time : 2017/2/18-23:24
 */

public class UserLoginPresent extends BasePresent implements IUserLoginPresent {

    private IUserLoginView mIUserLoginView;

    public UserLoginPresent(IUserLoginView IUserLoginView) {
        mIUserLoginView = IUserLoginView;
    }

    @Override
    public void login(String username, String passwd) {
        mIUserLoginView.showProgress();
        IUserModule userModule = new UserModule(username, passwd);
        userModule.login(new CommonCallBack<IUserModule>() {
            @Override
            public void onProgress(int progress) {
               mIUserLoginView.hidProgress();
            }

            @Override
            public void onFailed(int failedCode) {
                mIUserLoginView.hidProgress();
                if(failedCode == ErrorCode.LOGIN_FAILE_NO_USER){
                    mIUserLoginView.showUserNameError();
                }else if(failedCode == ErrorCode.LOGIN_FAILE_PASSWD_ERROR){
                    mIUserLoginView.showPasswdError();
                }
            }

            @Override
            public void onSuccess(IUserModule iUserModule) {
                mIUserLoginView.hidProgress();
                mIUserLoginView.loginSuccess();
            }
        });
    }
}
