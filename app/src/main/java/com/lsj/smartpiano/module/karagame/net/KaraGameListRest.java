package com.lsj.smartpiano.module.karagame.net;

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
 * on 2016-06-02 21:52.
 */
public class KaraGameListRest {
    private static KaraGameListInterface interfaceApi;

    public static KaraGameListInterface getClient(/*String modulUrl*/){
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
            interfaceApi = client.create(KaraGameListInterface.class);
        }
        return interfaceApi ;
    }
}
