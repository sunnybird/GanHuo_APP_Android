package cn.alpha.intell.ganhuo.module;

import cn.alpha.intell.ganhuo.common.CommonCallBack;

/**
 * @author : jinlongfeng
 * @version : V1.0.0
 * @description: 用户模型抽象接口
 * @time : 2017/2/18-23:01
 */

public interface IUserModule {
   void  login(CommonCallBack<IUserModule> callBack);
   void  logout(CommonCallBack<IUserModule> callBack);
}
