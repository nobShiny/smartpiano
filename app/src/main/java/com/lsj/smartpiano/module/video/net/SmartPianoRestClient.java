package com.lsj.smartpiano.module.video.net;

import com.lsj.smartpiano.common.constant.SmartPianoAPI;
import com.lsj.smartpiano.module.video.bean.BaseListBean;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by shiny_jia
 * on 2016-05-18 15:25.
 */
public class SmartPianoRestClient {
    private static SmartPianoApiInterface smartPianoApiInterface ;

    public static SmartPianoApiInterface getClient(/*String modulUrl*/){
        if (smartPianoApiInterface == null) {

            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(SmartPianoAPI.BASE_URL)
                    .addConverter(String.class, new ToStringConverter())
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            smartPianoApiInterface = client.create(SmartPianoApiInterface.class);
        }
        return smartPianoApiInterface ;
    }

    public interface SmartPianoApiInterface {

        @GET("/video_course/series")
        Call<BaseListBean> getBaseList(@Query("count") String count,
                                       @Query("appver") String appver,
                                       @Query("platform") String platform,
                                       @Query("channel") String channel,
                                       @Query("hd") String hd,
                                       @Query("connection") String connection,
                                       @Query("pType") String pType,
                                       @Query("lan") String lan
        );
        @GET("/single/adult")
        Call<BaseListBean> getAdvanceList(@Query("appver") String appver,
                                          @Query("platform") String platform,
                                          @Query("channel") String channel,
                                          @Query("hd") String hd,
                                          @Query("connection") String connection,
                                          @Query("pType") String pType,
                                          @Query("lan") String lan
        );
        @GET("/single/adult")
        Call<BaseListBean> getAdvanceListWithLevel(@Query("level") String level,
                                          @Query("appver") String appver,
                                          @Query("platform") String platform,
                                          @Query("channel") String channel,
                                          @Query("hd") String hd,
                                          @Query("connection") String connection,
                                          @Query("pType") String pType,
                                          @Query("lan") String lan
        );

        



    }
}