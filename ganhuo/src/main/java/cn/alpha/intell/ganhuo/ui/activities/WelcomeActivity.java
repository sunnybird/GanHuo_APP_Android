package cn.alpha.intell.ganhuo.ui.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import cn.alpha.intell.ganhuo.R;
import cn.alpha.intell.ganhuo.common.CommonCallBack;
import cn.alpha.intell.ganhuo.config.Api;
import cn.alpha.intell.ganhuo.utils.ImageLoader.IImageLoader;

public class WelcomeActivity extends BaseActivity {
    private ImageView mIvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
        initData();
    }

    private void initData() {
        IImageLoader.getInstance(this.getApplication())
                .LoadImage(Uri.parse(Api.IMAGE_WELCOME), new CommonCallBack<Drawable>() {
                    @Override
                    public void onProgress(int progress) {
                        mIvWelcome.setImageResource(R.drawable.default_welcome);
                        jumpToMain();

                    }

                    @Override
                    public void onFailed(int failedCode) {
                        mIvWelcome.setImageResource(R.drawable.default_welcome);
                        jumpToMain();
                    }

                    @Override
                    public void onSuccess(Drawable drawable) {
                        mIvWelcome.setImageDrawable(drawable);
                        jumpToMain();
                    }
                });

    }

    private void initView() {
        mIvWelcome = (ImageView) findViewById(R.id.iv_welcome);
    }

    private void jumpToMain(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this,UserLoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

     }
}
