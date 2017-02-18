package cn.alpha.intell.ganhuo.module;

import android.os.Handler;
import android.os.SystemClock;

import cn.alpha.intell.ganhuo.common.CommonCallBack;
import cn.alpha.intell.ganhuo.config.ErrorCode;

/**
 * @author : jinlongfeng
 * @version : V1.0.0
 * @description: 用户模型
 * @time : 2017/2/18-23:11
 */

public class UserModule extends BaseModule implements IUserModule {

    private String username;
    private String passwd;

    public UserModule(String username, String passwd) {
        this.username = username;
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void login(final CommonCallBack<IUserModule> callBack) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(!username.equals("test")) {
                    callBack.onFailed(ErrorCode.LOGIN_FAILE_NO_USER);
                }else if(!passwd.startsWith("test")){
                    callBack.onFailed(ErrorCode.LOGIN_FAILE_PASSWD_ERROR);
                }else if(username.equals(passwd)){
                    callBack.onSuccess(UserModule.this);
                }
            }
        },3000);

    }

    @Override
    public void logout(CommonCallBack<IUserModule> callBack) {

    }
}
