package cn.alpha.intell.ganhuo.utils.ImageLoader;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import cn.alpha.intell.ganhuo.common.CommonCallBack;

/**
 * @author : jinlongfeng
 * @version : V1.0.0
 * @description: 图片加载抽象接口
 * @time : 2017/2/19-00:20
 */

public abstract class IImageLoader {
   private static  IImageLoader sIImageLoader;
   public static IImageLoader getInstance(Context context){
     if(sIImageLoader == null){
        synchronized (IImageLoader.class){
           if(sIImageLoader == null){
              sIImageLoader = new GlideImageLoader(context);
           }
        }
     }
     return sIImageLoader;
   }

    public abstract void  LoadImage(Uri uri,CommonCallBack<Drawable> commonCallBack);
    public void clear(){
    };

}
