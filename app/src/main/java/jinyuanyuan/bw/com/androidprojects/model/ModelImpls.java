package jinyuanyuan.bw.com.androidprojects.model;

import com.google.gson.Gson;
import java.util.Map;
import jinyuanyuan.bw.com.androidprojects.callback.MyCallBack;
import jinyuanyuan.bw.com.androidprojects.utils.RetrofitUtils;

public class ModelImpls implements Model {

    @Override
    public void postRequest(String url, Map<String, String> map, final Class clazz, final MyCallBack callBack) {
        RetrofitUtils.getInstance().post(url, map, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String jsonStr) {
                Gson gson = new Gson();
                Object json = gson.fromJson(jsonStr, clazz);
                callBack.Success(json);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    @Override
    public void postRequesst(String url, int userid,String sessionId ,Map<String, Integer> map, final Class clazz, final MyCallBack callBack) {
        RetrofitUtils.getInstance().posts(url,userid,sessionId, map, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String jsonStr) {
                Gson gson = new Gson();
                Object json = gson.fromJson(jsonStr, clazz);
                callBack.Success(json);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    @Override
    public void getRequest(String url, Map<String, String> map, final Class claas, final MyCallBack callBack) {
         RetrofitUtils.getInstance().get(url, map, new RetrofitUtils.HttpListener() {
             @Override
             public void onSuccess(String jsonStr) {
                 Gson gson = new Gson();
                 Object json = gson.fromJson(jsonStr, claas);
                 callBack.Success(json);
             }

             @Override
             public void onError(String error) {

             }
         });
    }

    @Override
    public void deleteRequest(String url, int userid, String sessionId, Map<String, Integer> map, final Class classes, final MyCallBack callBack) {
        RetrofitUtils.getInstance().del(url, userid, sessionId, map, new RetrofitUtils.HttpListener() {
            @Override
            public void onSuccess(String jsonStr) {
                Gson gson = new Gson();
                Object json = gson.fromJson(jsonStr, classes);
                callBack.Success(json);
            }

            @Override
            public void onError(String error) {

            }
        });
    }

}
