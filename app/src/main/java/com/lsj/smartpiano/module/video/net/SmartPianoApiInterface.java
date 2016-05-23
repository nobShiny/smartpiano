package com.lsj.smartpiano.module.video.net;

import com.lsj.smartpiano.module.video.bean.BaseListBean;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

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