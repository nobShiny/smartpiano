package com.lsj.smartpiano.module.search.net;

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
public class SearchVideoListRest {
    private static SearchListInterface interfaceApi;

    public static SearchListInterface getClient(/*String modulUrl*/){
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
            interfaceApi = client.create(SearchListInterface.class);
        }
        return interfaceApi ;
    }

}