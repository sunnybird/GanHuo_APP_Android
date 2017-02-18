package cn.alpha.intell.ganhuo.utils.ImageLoader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;

import cn.alpha.intell.ganhuo.common.CommonCallBack;

/**
 * @author : jinlongfeng
 * @version : V1.0.0
 * @description: Glide 实现图片加载
 * @time : 2017/2/19-00:23
 */

public class GlideImageLoader extends IImageLoader {

    private Context mContext;


    public GlideImageLoader(Context context){
        mContext = context;

    }
    @Override
    public void LoadImage(Uri uri,final CommonCallBack<Drawable> commonCallBack) {
      Glide.with(mContext)
      .load(uri)
      .asBitmap()
      .centerCrop()
      .thumbnail(0.5f)
      .into(new SimpleTarget<Bitmap>() {
          @Override
          public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
              commonCallBack.onSuccess(new BitmapDrawable(mContext.getResources(),resource));
          }
      });
    }

    @Override
    public void clear() {
        super.clear();
    }
}
