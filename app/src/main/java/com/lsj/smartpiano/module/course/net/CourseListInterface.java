package com.lsj.smartpiano.module.course.net;

import com.lsj.smartpiano.module.course.bean.CourseCategoryBean;
import com.lsj.smartpiano.module.course.bean.CourseListBean;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by shiny_jia
 * on 2016-06-02 22:05.
 */
public interface CourseListInterface {

    @GET("category")
    Call<CourseCategoryBean> getCourseCategoryList(
                                       @Query("appver") String appver,
                                       @Query("platform") String platform,
                                       @Query("channel") String channel,
                                       @Query("hd") String hd,
                                       @Query("connection") String connection,
                                       @Query("pType") String pType,
                                       @Query("lan") String lan
    );

    @GET("category/sub")
    Call<CourseListBean> getCourseList(@Query("category") String category,
                                       @Query("appver") String appver,
                                       @Query("platform") String platform,
                                       @Query("channel") String channel,
                                       @Query("hd") String hd,
                                       @Query("connection") String connection,
                                       @Query("pType") String pType,
                                       @Query("lan") String lan
    );

    @GET("category/sub")
    Call<CourseListBean> getCourseWithLevelList(@Query("category") String category,
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
