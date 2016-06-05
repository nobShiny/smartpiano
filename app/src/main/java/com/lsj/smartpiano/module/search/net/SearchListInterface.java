package com.lsj.smartpiano.module.search.net;

import com.lsj.smartpiano.module.search.bean.SearchKaraBean;
import com.lsj.smartpiano.module.search.bean.SearchSongBean;
import com.lsj.smartpiano.module.search.bean.SearchVideoBean;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface SearchListInterface {

        @GET("/search/videocourses")
        Call<SearchVideoBean> getSearchVideoList(@Query("keyword") String keyword,
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
        Call<SearchKaraBean> getSearchKarasList(@Query("keyword") String keyword,
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
        Call<SearchSongBean> getSearchSongsList(@Query("keyword") String keyword,
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