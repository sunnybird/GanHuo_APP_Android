package cn.alpha.intell.ganhuo.common;

/**
 * @author : jinlongfeng
 * @version : V1.0.0
 * @description: 通用回调接口
 * @time : 2017/2/18-23:04
 */

public interface CommonCallBack<T> {
   void onProgress(int progress);
   void onFailed(int failedCode);
   void onSuccess(T t);
}
