package jinyuanyuan.bw.com.androidprojects.utils;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

public interface MyApiService {
    //封装get和post
    @GET
    Observable<ResponseBody> get(@Url String url, @QueryMap Map<String,String> map);

    @POST
    Observable<ResponseBody> post(@Url String url,@QueryMap Map<String,String> map);

    //圈子点赞
    @FormUrlEncoded
    @POST
    Observable<ResponseBody> posts(@Url String url,@Header("userId") int userid,@Header("sessionId") String sessionId, @FieldMap Map<String, Integer> map);

    //圈子取消点赞
    @DELETE
    Observable<ResponseBody> delete(@Url String url,@Header("userId") int userid,@Header("sessionId") String sessionId,@QueryMap Map<String,Integer> map);


}
