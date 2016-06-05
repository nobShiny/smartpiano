package com.lsj.smartpiano.module.video.net;

import com.lsj.smartpiano.module.video.bean.AdvanceListBean;
import com.lsj.smartpiano.module.video.bean.BaseListBean;
import com.lsj.smartpiano.module.video.bean.LessonContentBean;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface VideoListInterface {

        @GET("video_course/series")
        Call<BaseListBean> getBaseList(@Query("count") String count,
                                       @Query("appver") String appver,
                                       @Query("platform") String platform,
                                       @Query("channel") String channel,
                                       @Query("hd") String hd,
                                       @Query("connection") String connection,
                                       @Query("pType") String pType,
                                       @Query("lan") String lan
        );
        @GET("video_course/single/adult")
        Call<AdvanceListBean> getAdvanceList(@Query("appver") String appver,
                                             @Query("platform") String platform,
                                             @Query("channel") String channel,
                                             @Query("hd") String hd,
                                             @Query("connection") String connection,
                                             @Query("pType") String pType,
                                             @Query("lan") String lan
        );
        @GET("video_course/single/adult")
        Call<AdvanceListBean> getAdvanceListWithLevel(@Query("level") String level,
                                          @Query("appver") String appver,
                                          @Query("platform") String platform,
                                          @Query("channel") String channel,
                                          @Query("hd") String hd,
                                          @Query("connection") String connection,
                                          @Query("pType") String pType,
                                          @Query("lan") String lan
        );

        @GET("video_course/lesson")
        Call<LessonContentBean> getAdvanceContentWithId(@Query("course") String course,
                                                        @Query("appver") String appver,
                                                        @Query("platform") String platform,
                                                        @Query("channel") String channel,
                                                        @Query("hd") String hd,
                                                        @Query("connection") String connection,
                                                        @Query("pType") String pType,
                                                        @Query("lan") String lan
        );


    }