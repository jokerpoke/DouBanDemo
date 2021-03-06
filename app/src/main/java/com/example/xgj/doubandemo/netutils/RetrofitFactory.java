package com.example.xgj.doubandemo.netutils;

import android.os.Environment;

import com.example.xgj.mybaselibrary.base.MyBaseApplication;
import com.example.xgj.mybaselibrary.utils.LogsUtils;
import com.example.xgj.mybaselibrary.utils.RxUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


public class RetrofitFactory {

    //基础地址
    //    public final static String HOST = "http://m2.qiushibaike.com";
    //    public final static String HOST = "http://lanzhifu.qingyutec.com:8085/";
    public final static String HOST = "http://www.izaodao.com/Api/";


    private volatile static RetrofitFactory retrofitFactory;

    private Retrofit retrofit;
    private RetrofitService apiService;
    private OkHttpClient client;
    private static final int DEFAULT_TIME = 10;


    private RetrofitFactory() {
        init();
    }

    public static RetrofitFactory getInstance() {
        if (retrofitFactory == null) {
            synchronized (RetrofitFactory.class) {
                if (retrofitFactory == null) {
                    retrofitFactory = new RetrofitFactory();
                }
            }
        }
        return retrofitFactory;
    }


    //    public static class SingleInstanceHolder {
    //        private static RetrofitFactory retrofitService = new RetrofitFactory();
    //
    //    }

    //    public static RetrofitFactory getInstance() {
    //        return SingleInstanceHolder.retrofitService;
    //    }


    private void init() {
        initHttp();
    }

//
//    /**
//     * 设置返回数据的  Interceptor  判断网络   没网读取缓存
//     */
//    public Interceptor getInterceptor() {
//        return new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                if (!NetworkUtil.isNetworkAvailable(BaseActivity.mcontext)) {
//                    request = request.newBuilder()
//                            .cacheControl(CacheControl.FORCE_CACHE)
//                            .build();
//                }
//                return chain.proceed(request);
//            }
//        };
//    }


    private void initHttp() {


        //设置缓存
        File httpCacheDirectory = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        int cacheSize = 100 * 1024 * 1024; // 100 MiB 缓存大小
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        //        //包括控制缓存的最大生命值，控制缓存的过期时间
        //        CacheControl.Builder cacheBuilder = new CacheControl.Builder();
        //        cacheBuilder.maxAge(0, TimeUnit.SECONDS);//这个是控制缓存的最大生命时间
        //        cacheBuilder.maxStale(365, TimeUnit.DAYS);//这个是控制缓存的过时时间
        //        CacheControl cacheControl = cacheBuilder.build();


        //


        // 设置 Log 拦截器，可以用于以后处理一些异常情况
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogsUtils.d("chen", "OkHttp====message " + message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        // 配置 client
        // 设置拦截器
        // 是否重试
        // 连接超时事件 设置为10s
        // 读取超时时间  设置为10s
        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                //                .addInterceptor(getInterceptor())                // 设置拦截器
                .retryOnConnectionFailure(true)             // 是否重试
                .connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS)        // 连接超时事件 设置为10s
                .readTimeout(DEFAULT_TIME, TimeUnit.SECONDS)           // 读取超时时间  设置为10s
                .writeTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
//                .cache(cache)
                .addNetworkInterceptor(new NetworkInterceptor())
                .addInterceptor(interceptor)  // 设置拦截器
                .addNetworkInterceptor(new CacheInterceptor())//缓存拦截器
                .cache(new CacheProvide(MyBaseApplication.getBaseApplication()).provideCache())//缓存空间提供器
                //                .addNetworkInterceptor(mTokenInterceptor)   // 自动附加 token
                //                .authenticator(mAuthenticator)              // 认证失败自动刷新token
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();


    }


    //设为public让外部获取到
    public RetrofitService initRetrofit() {
        return retrofit.create(RetrofitService.class);
    }


    //
    //    public Observable<List<TextEntity.ItemsBean>> getTextData(int page)
    //    {
    //        return apiService.getTexts(page)
    //                .flatMap(new Function<TextEntity, Observable<List<TextEntity.ItemsBean>>>() {
    //                    @Override
    //                    public Observable<List<TextEntity.ItemsBean>> apply(TextEntity textEntity) throws Exception {
    //                        return Observable.just(textEntity.getItems());
    //                    }
    //                })
    //                .compose(RxUtils.<List<TextEntity.ItemsBean>>rxSchedulerHelper());
    //    }
    //
    //    public Observable<List<PicEntity.ItemsBean>> getPicData(int page)
    //    {
    //        return apiService.getPics(page)
    //                .flatMap(new Function<PicEntity, Observable<List<PicEntity.ItemsBean>>>() {
    //                    @Override
    //                    public Observable<List<PicEntity.ItemsBean>> apply(@NonNull PicEntity picEntity) throws Exception {
    //                        return Observable.just(picEntity.getItems());
    //                    }
    //                })
    //                .compose(RxUtils.<List<PicEntity.ItemsBean>>rxSchedulerHelper());
    //    }
    //
    //    public Observable<List<VideoEntity.ItemsBean>> getVideoData(int page)
    //    {
    //        return apiService.getVideos(page)
    //                .flatMap(new Function<VideoEntity, Observable<List<VideoEntity.ItemsBean>>>() {
    //                    @Override
    //                    public Observable<List<VideoEntity.ItemsBean>> apply(@NonNull VideoEntity videoEntity) throws Exception {
    //                        return Observable.just(videoEntity.getItems());
    //                    }
    //                })
    //                .compose(RxUtils.<List<VideoEntity.ItemsBean>>rxSchedulerHelper());
    //    }

    public Observable<Object> getTextData(int page) {
        return apiService.getTexts(page)
                .flatMap(new Function<Object, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(@NonNull Object o) throws Exception {
                        return Observable.just(o);
                    }
                })
                .compose(RxUtils.<Object>rxSchedulerHelper());
    }


}
