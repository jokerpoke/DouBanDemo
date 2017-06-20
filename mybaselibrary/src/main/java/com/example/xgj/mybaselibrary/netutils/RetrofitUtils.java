package com.example.xgj.mybaselibrary.netutils;

/**
 * Created by chen on 2017/6/19.
 */

public class RetrofitUtils {
  /*  private Retrofit mRetrofit;
    protected Service mService;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public void start() {
        //        retrofit.create()
    }


    private void initRetrofit() {
        if (null != mRetrofit)
            return;

        // 设置 Log 拦截器，可以用于以后处理一些异常情况
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //        // 为所有请求自动添加 token
        //        Interceptor mTokenInterceptor = new Interceptor() {
        //            @Override
        //            public okhttp3.Response intercept(Chain chain) throws IOException {
        //                Request originalRequest = chain.request();
        //                // 如果当前没有缓存 token 或者请求已经附带 token 了，就不再添加
        //                if (null == mCacheUtil.getToken() || alreadyHasAuthorizationHeader(originalRequest)) {
        //                    return chain.proceed(originalRequest);
        //                }
        //                String token = OAuth.TOKEN_PREFIX + mCacheUtil.getToken().getAccess_token();
        //                // 为请求附加 token
        //                Request authorised = originalRequest.newBuilder()
        //                        .header(OAuth.KEY_TOKEN, token)
        //                        .build();
        //                return chain.proceed(authorised);
        //            }
        //        };

        // 自动刷新 token
        //        Authenticator mAuthenticator = new Authenticator() {
        //            @Override
        //            public Request authenticate(Route route, Response response) {
        //                Logger.i("自动刷新 token 开始");
        //                TokenService tokenService = mRetrofit.create(TokenService.class);
        //                String accessToken = "";
        //                try {
        //                    if (null != mCacheUtil.getToken()) {
        //                        Call<Token> call = tokenService.refreshToken(OAuth.client_id,
        //                                OAuth.client_secret, OAuth.GRANT_TYPE_REFRESH,
        //                                mCacheUtil.getToken().getRefresh_token());
        //                        retrofit2.Response<Token> tokenResponse = call.execute();
        //                        Token token = tokenResponse.body();
        //                        if (null != token) {
        //                            mCacheUtil.saveToken(token);
        //                            accessToken = token.getAccess_token();
        //                        }
        //                    }
        //                } catch (Exception e) {
        //                    e.printStackTrace();
        //                }
        //                Logger.i("自动刷新 token 结束：" + accessToken);
        //                return response.request().newBuilder()
        //                        .addHeader(OAuth.KEY_TOKEN, OAuth.TOKEN_PREFIX + accessToken)
        //                        .build();
        //            }
        //        };

        // 配置 client
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)                // 设置拦截器
                .retryOnConnectionFailure(true)             // 是否重试
                .connectTimeout(5, TimeUnit.SECONDS)        // 连接超时事件
                .readTimeout(5, TimeUnit.SECONDS)           // 读取超时时间
                //                .addNetworkInterceptor(mTokenInterceptor)   // 自动附加 token
                //                .authenticator(mAuthenticator)              // 认证失败自动刷新token
                .build();

        // 配置 Retrofit
        mRetrofit = new Retrofit.Builder()
//                .baseUrl(ApiInterface.TEST_URL)                         // 设置 base url
                .client(client)                                     // 设置 client
                .addConverterFactory(GsonConverterFactory.create()) // 设置 Json 转换工具
                .build();
    }
*/

}
