package jinyuanyuan.bw.com.androidprojects.model;

import java.util.Map;

import jinyuanyuan.bw.com.androidprojects.callback.MyCallBack;

public interface Model {
    //post请求方式
    void postRequest(String url, Map<String, String> map, Class clazz, MyCallBack callBack);

    //请求圈子
    void postRequesst(String url, int userid, String sessionId, Map<String, Integer> map, Class clazz, MyCallBack callBack);

    //get请求方式
    void getRequest(String url, Map<String, String> map, Class claas, MyCallBack callBack);

    //delete
    void deleteRequest(String url, int userid, String sessionId, Map<String, Integer> map, Class classes, MyCallBack callBack);

}
