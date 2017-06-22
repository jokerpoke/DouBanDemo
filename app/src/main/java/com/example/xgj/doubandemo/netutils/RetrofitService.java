package com.example.xgj.doubandemo.netutils;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by chen on 2017/6/19.
 */

public interface RetrofitService {
    //存放地址

    //    public static  final String TEST_URL="https://api.github.com/users/Guolei1130";

    //    @GET("/article/list/pic")
    //    Observable<PicEntity> getPics(@Query("page") int page);


    //    // 最新
    //    public final static String URL_LATEST ="/article/list/latest";
    //
    //    // 图片
    //    public final static String URL_PIC= "/article/list/pic";
    //
    //    // 视频
    //    public final static String URL_VIDEO = "/article/list/video";
    //
    //    // 文本
    //    public final static String URL_TEXT = "/article/list/text";
    //
    //    /************************查询参数都为 page ***********************************/
    //
    //    //头像获取(+ id掉后4位 + "/" + id + "/thumb/" + icon图片名.jpg)
    //    //userIcon======http://pic.qiushibaike.com/system/avtnew/1499/14997026/thumb/20140404194843.jpg
    //    public final static String URL_USER_ICON="http://pic.qiushibaike.com/system/avtnew/%d/%d/thumb/%s";
    //
    //    //内容图片获取(+图片名所有数字去掉后4位+"/"+图片名从数字开始数全部+"/"+"/"+small或者medium+"/"+图片名)
    //    //====图片Url=http://pic.qiushibaike.com/system/pictures/7128/71288069/small/app71288069.jpg
    //    public final static String URL_IMAGE= "http://pic.qiushibaike.com/system/pictures/%s/%s/%s/%s";
    //    @GET("/article/list/text")
    //    Observable<TextEntity> getTexts(@Query("page") int page);
    //
    //    @GET("/article/list/pic")
    //    Observable<PicEntity> getPics(@Query("page") int page);
    //
    //    @GET("/article/list/video")
    //    Observable<VideoEntity> getVideos(@Query("page") int page);
    @GET("/article/list/text")
    Observable<Object> getTexts(@Query("page") int page);

    @FormUrlEncoded
    @POST
    Observable<Object> getHH(@Query("bizType") String listChannel);


    //    //?requestData=eyJ2ZXJzaW9uX25hbWUiOiIxLjEuMiIsImN0bCI6InN0b3JlIiwiaXNfcmMiOiIwIiwic3VwcGxp%0AZXJfdHlwZSI6IjEiLCJmcm9tIjoiYW5kcm9pZCIsImNpdHlfaWQiOjIzLCJkYXRhX2lkIjoyMywi%0AcHdkIjoiOTZlNzkyMTg5NjVlYjcyYzkyYTU0OWRkNWEzMzAxMTIiLCJ0b2tlbiI6IjM0QkEyRDFB%0ALTlFQ0ItMEJBQi0xQ0VFLTFEMjhFNjQ3M0U4MCIsImVtYWlsIjoiMTIxMzgiLCJzZXNzX2lkIjoi%0AYzIzbnV1Zm9vYjVmMzgwamRlbzJ0Ymw3ZTUiLCJ1c2VyX21vYmlsZSI6IjE1ODY4ODY3NzQyIiwi%0AdXNlcl9pZCI6MTAwLCJhY3QiOiJpbmRleCJ9%0A&i_type=0&r_type=1&ctl=store&act=index
    //    @POST("/yyk/mapi/index.php")
    //    Observable<Object> getTexts(@Query("version_name") String version_name,
    //                                @Query("ctl") String ctl,
    //                                @Query("is_rc") String is_rc,
    //                                @Query("supplier_type") String supplier_type,
    //                                @Query("from")String from,
    //                                @Query("city_id")String city_id,
    //                                @Query("data_id") String data_id,
    //                                @Query("pwd")String pwd,
    //                                @Query("token") String token,
    //                                @Query("email")String email,
    //                                @Query("sess_id")String sess_id,
    //                                @Query("user_mobile")String user_mobile,
    //                                @Query("user_id")String user_id,
    //                                @Query("act") String act
    //                                );
//    @FormUrlEncoded
    @POST(":8085/NewPhonePospInterface/QQPayServlet")
    Observable<Object> getDatas(@Query("saruLruid") String saruLruid,
                                @Query("type") String type,
                                @Query("transAmt") String transAmt
    );
//        @GET
//        Observable<Object> getDatas(
//        );
}
