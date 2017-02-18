package cn.alpha.intell.ganhuo.ui.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.alpha.intell.ganhuo.R;
import cn.alpha.intell.ganhuo.present.IUserLoginPresent;
import cn.alpha.intell.ganhuo.present.UserLoginPresent;

/**
 * @author : jinlongfeng
 * @version : V1.0.0
 * @description: 用户登录 视图
 * @time : 2017/2/18-23:34
 */

public class UserLoginActivity extends BaseActivity implements IUserLoginView, View.OnClickListener {

    private ProgressDialog mProgressDialog;
    /**
     * login_username
     */
    private EditText mEtUsername;
    /**
     * login_passwd
     */
    private EditText mEtPasswd;
    /**
     * login_submit
     */
    private Button mBtnLogin;

    private IUserLoginPresent mIUserLoginPresent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);
        initView();
        initData();
    }

    private void initData() {
        mIUserLoginPresent = new UserLoginPresent(this);

    }

    @Override
    public void showProgress() {
        mProgressDialog = ProgressDialog.show(this,
                getResources().getString(R.string.login_dialog_title),
                getResources().getString(R.string.login_dialog_conent),
                true,
                false
        );
    }

    @Override
    public void hidProgress() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showUserNameError() {
        mEtUsername.setError(getResources().getString(R.string.login_username_error));
    }

    @Override
    public void showPasswdError() {
        mEtPasswd.setError(getResources().getString(R.string.login_passwd_error));
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    private void initView() {
        mEtUsername = (EditText) findViewById(R.id.et_username);
        mEtPasswd = (EditText) findViewById(R.id.et_passwd);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String username = mEtUsername.getText().toString().trim();
                String passwd = mEtPasswd.getText().toString().trim();
                mIUserLoginPresent.login(username, passwd);
                break;
            default:
                break;
        }
    }
}
