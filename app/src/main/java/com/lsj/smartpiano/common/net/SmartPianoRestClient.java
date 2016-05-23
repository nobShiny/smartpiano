package com.lsj.smartpiano.common.net;

import com.lsj.smartpiano.common.constant.SmartPianoAPI;
import com.lsj.smartpiano.module.video.net.SmartPianoApiInterface;
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
public class SmartPianoRestClient<T> {
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

}