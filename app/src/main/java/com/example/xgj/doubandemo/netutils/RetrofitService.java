package com.example.xgj.doubandemo.netutils;

import com.example.xgj.doubandemo.bean.Jinmimi;
import com.example.xgj.doubandemo.bean.Ship;
import com.example.xgj.mybaselibrary.base.BaseEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
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
    Observable<BaseEntity<Object>> getTexts(@Query("page") int page);

    @FormUrlEncoded
    @POST
    Observable<Object> getHH(@Query("bizType") String listChannel);


    @FormUrlEncoded
    @POST("NewPhonePospInterface/QQPayServlet")
    Observable<BaseEntity<Jinmimi>> getDatas(@Field("saruLruid") String saruLruid,
                                 @Field("type") String type,
                                 @Field("transAmt") String transAmt
    );

    @FormUrlEncoded
    @POST("AppFiftyToneGraph/videoLink")
    Observable<BaseEntity<List<Ship>>> getAllVedio(@Field("once_no") boolean once_no);

}
