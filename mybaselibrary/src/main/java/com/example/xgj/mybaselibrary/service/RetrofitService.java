package com.example.xgj.mybaselibrary.service;

public class RetrofitService {

  /*  private Retrofit retrofit;
    //    private  ApiInterface apiService;

    public static Object object;

    private RetrofitService() {
        init();
    }

    private  RetrofitService(Object object) {
        this.object = object;
        init();
    }

    public static class SingleInstanceHolder {
        private static RetrofitService retrofitService = new RetrofitService(object);

    }

    public static RetrofitService getInstance() {
//        object = objects;
        return SingleInstanceHolder.retrofitService;
    }


    private void init() {
        initOkHttp();
        initRetrofit();
        object = retrofit.create((Class)object);
    }


    private void initOkHttp() {
        // 设置 Log 拦截器，可以用于以后处理一些异常情况
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // 配置 client
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)                // 设置拦截器
                .retryOnConnectionFailure(true)             // 是否重试
                .connectTimeout(5, TimeUnit.SECONDS)        // 连接超时事件
                .readTimeout(5, TimeUnit.SECONDS)           // 读取超时时间
                //                .addNetworkInterceptor(mTokenInterceptor)   // 自动附加 token
                //                .authenticator(mAuthenticator)              // 认证失败自动刷新token
                .build();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.TEST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
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
    //    }*/

}
