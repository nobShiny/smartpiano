package com.lsj.smartpiano.module.search.net;

import com.lsj.smartpiano.module.video.bean.BaseListBean;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface SearchListInterface {

        @GET("/search/videocourses")
        Call<BaseListBean> getSearchVideoList(@Query("keyword") String keyword,
                                              @Query("page") String page,
                                              @Query("limit") String limit,
                                              @Query("appver") String appver,
                                              @Query("platform") String platform,
                                              @Query("channel") String channel,
                                              @Query("hd") String hd,
                                              @Query("connection") String connection,
                                              @Query("pType") String pType,
                                              @Query("lan") String lan
        );
        @GET("/search/karas")
        Call<BaseListBean> getSearchKarasList(@Query("keyword") String keyword,
                                              @Query("page") String page,
                                              @Query("limit") String limit,
                                              @Query("appver") String appver,
                                              @Query("platform") String platform,
                                              @Query("channel") String channel,
                                              @Query("hd") String hd,
                                              @Query("connection") String connection,
                                              @Query("pType") String pType,
                                              @Query("lan") String lan
        );
        @GET("/search/songs")
        Call<BaseListBean> getSearchSongsList(@Query("keyword") String keyword,
                                              @Query("page") String page,
                                              @Query("limit") String limit,
                                              @Query("appver") String appver,
                                              @Query("platform") String platform,
                                              @Query("channel") String channel,
                                              @Query("hd") String hd,
                                              @Query("connection") String connection,
                                              @Query("pType") String pType,
                                              @Query("lan") String lan
        );

    }