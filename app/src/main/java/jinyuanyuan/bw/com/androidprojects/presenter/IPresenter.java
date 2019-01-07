package jinyuanyuan.bw.com.androidprojects.presenter;

import java.util.Map;

public interface IPresenter {
    //post方式
    void postRequest(String url, Map<String,String> map,Class clazz);

    //请求圈子
    void postRequesst(String url, int userid,String sessionId,Map<String, Integer> map, Class clazz);

    //get
    void getRequest(String url, Map<String,String> map,Class claas);

    //delete取消点赞
    void delRequest(String url,int userid,String sessionId,Map<String,Integer> map,Class classes);
}
