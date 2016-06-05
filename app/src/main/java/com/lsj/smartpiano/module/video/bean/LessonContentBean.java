package com.lsj.smartpiano.module.video.bean;

import java.util.List;

/**
 * Created by shiny_jia
 * on 2016-06-04 22:23.
 */
public class LessonContentBean {


    /**
     * lessons : {"hasNext":false,"list":[{"movieUrl":"http://dl.v1.1tai.com/video_courses/zh/zhibokechengjingxuan-chongerfei/lesson_1.m4v","show":true,"desc":"本课教学安排","songId":13692,"course":65,"title":"1.本课教学安排","purchase":false,"id":"7biHqxOCw9dr7PVcI8mYgA","type":1}]}
     */

    private DataEntity data;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        /**
         * hasNext : false
         * list : [{"movieUrl":"http://dl.v1.1tai.com/video_courses/zh/zhibokechengjingxuan-chongerfei/lesson_1.m4v","show":true,"desc":"本课教学安排","songId":13692,"course":65,"title":"1.本课教学安排","purchase":false,"id":"7biHqxOCw9dr7PVcI8mYgA","type":1}]
         */

        private LessonsEntity lessons;

        public LessonsEntity getLessons() {
            return lessons;
        }

        public void setLessons(LessonsEntity lessons) {
            this.lessons = lessons;
        }

        public static class LessonsEntity {
            private boolean hasNext;
            /**
             * movieUrl : http://dl.v1.1tai.com/video_courses/zh/zhibokechengjingxuan-chongerfei/lesson_1.m4v
             * show : true
             * desc : 本课教学安排
             * songId : 13692
             * course : 65
             * title : 1.本课教学安排
             * purchase : false
             * id : 7biHqxOCw9dr7PVcI8mYgA
             * type : 1
             */

            private List<ListEntity> list;

            public boolean isHasNext() {
                return hasNext;
            }

            public void setHasNext(boolean hasNext) {
                this.hasNext = hasNext;
            }

            public List<ListEntity> getList() {
                return list;
            }

            public void setList(List<ListEntity> list) {
                this.list = list;
            }

            public static class ListEntity {
                private String movieUrl;
                private boolean show;
                private String desc;
                private int songId;
                private int course;
                private String title;
                private boolean purchase;
                private String id;
                private int type;

                public String getMovieUrl() {
                    return movieUrl;
                }

                public void setMovieUrl(String movieUrl) {
                    this.movieUrl = movieUrl;
                }

                public boolean isShow() {
                    return show;
                }

                public void setShow(boolean show) {
                    this.show = show;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public int getSongId() {
                    return songId;
                }

                public void setSongId(int songId) {
                    this.songId = songId;
                }

                public int getCourse() {
                    return course;
                }

                public void setCourse(int course) {
                    this.course = course;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public boolean isPurchase() {
                    return purchase;
                }

                public void setPurchase(boolean purchase) {
                    this.purchase = purchase;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }
        }
    }
}
