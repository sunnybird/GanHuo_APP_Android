package cn.alpha.intell.ganhuo.ui.activities;

import android.app.Activity;

/**
 * @author : jinlongfeng
 * @version : V1.0.0
 * @description: 基础 Activity
 * @time : 2017/2/18-23:34
 */

public class BaseActivity extends Activity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
