package com.lsj.smartpiano.module.karagame.net;

import com.lsj.smartpiano.module.karagame.bean.KaraGameListBean;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by shiny_jia
 * on 2016-06-02 21:53.
 */
public interface KaraGameListInterface {

    @GET("kara/collection/songs")
    Call<KaraGameListBean> getKaraGameList(@Query("collection") String collection,
                                           @Query("appver") String appver,
                                           @Query("platform") String platform,
                                           @Query("channel") String channel,
                                           @Query("hd") String hd,
                                           @Query("connection") String connection,
                                           @Query("pType") String pType,
                                           @Query("lan") String lan
    );

    @GET("kara/collection/songs")
    Call<KaraGameListBean> getKaraGameWithLevelList(@Query("collection") String collection,
                                   @Query("level") String level,
                                   @Query("appver") String appver,
                                   @Query("platform") String platform,
                                   @Query("channel") String channel,
                                   @Query("hd") String hd,
                                   @Query("connection") String connection,
                                   @Query("pType") String pType,
                                   @Query("lan") String lan
    );



}
