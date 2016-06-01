package com.lsj.smartpiano.module.video.net;

import com.lsj.smartpiano.common.constant.SmartPianoAPI;
import com.lsj.smartpiano.common.net.ToStringConverter;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by shiny_jia
 * on 2016-05-18 15:25.
 */
public class VideoListRest {
    private static VideoListInterface interfaceApi;

    public static VideoListInterface getClient(/*String modulUrl*/){
        if (interfaceApi == null) {

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
            interfaceApi = client.create(VideoListInterface.class);
        }
        return interfaceApi ;
    }

}