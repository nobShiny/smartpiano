package com.lsj.smartpiano.module.video.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shiny_jia
 * on 2016-05-18 15:14.
 */
public class BaseListBean {
    /**
     * sm : {"hasNext":false,"list":[{"purshaseType":0,"recommendPic":"http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/recommend_pic.png","desc":"The ONE智能钢琴视频教学直播间主要面向钢琴零基础用户。 我们在课程中会逐步教授识谱，手型，指法，乐理等钢琴基础知识。 直播课程主页：http://online.1tai.com 参加直播课程请加QQ群：418084580","teacher":{"name":"佚名","id":0},"lessonCount":15,"lessons":[{"movieUrl":"http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/lesson_11.mp4","show":true,"desc":"五线谱的重要性总结","course":7,"title":"1.五线谱的重要性","purchase":false,"id":"ikpkkAKQZeSfi_sl8VBtKg","type":1},{"movieUrl":"http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/lesson_12.m4v","show":true,"desc":"五线谱的高低构成","course":7,"title":"2.五线谱高低","purchase":false,"id":"XdT_sFF9V3xDqwH5-mfBXw","type":1},{"movieUrl":"http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/lesson_13.m4v","show":true,"desc":"钢琴的高低构成和循环排列逻辑","course":7,"title":"3.键盘的高低","purchase":false,"id":"YT9LfJtIMTRrHRfAQSCyyw","type":1}],"pic":"http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/pic.jpg","knowledges":"None","name":"大家一起来识谱","id":7}]}
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
         * list : [{"purshaseType":0,"recommendPic":"http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/recommend_pic.png","desc":"The ONE智能钢琴视频教学直播间主要面向钢琴零基础用户。 我们在课程中会逐步教授识谱，手型，指法，乐理等钢琴基础知识。 直播课程主页：http://online.1tai.com 参加直播课程请加QQ群：418084580","teacher":{"name":"佚名","id":0},"lessonCount":15,"lessons":[{"movieUrl":"http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/lesson_11.mp4","show":true,"desc":"五线谱的重要性总结","course":7,"title":"1.五线谱的重要性","purchase":false,"id":"ikpkkAKQZeSfi_sl8VBtKg","type":1},{"movieUrl":"http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/lesson_12.m4v","show":true,"desc":"五线谱的高低构成","course":7,"title":"2.五线谱高低","purchase":false,"id":"XdT_sFF9V3xDqwH5-mfBXw","type":1},{"movieUrl":"http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/lesson_13.m4v","show":true,"desc":"钢琴的高低构成和循环排列逻辑","course":7,"title":"3.键盘的高低","purchase":false,"id":"YT9LfJtIMTRrHRfAQSCyyw","type":1}],"pic":"http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/pic.jpg","knowledges":"None","name":"大家一起来识谱","id":7}]
         */
        @SerializedName("1")
        private SmEntity sm;

        public SmEntity getSm() {
            return sm;
        }

        public void setSm(SmEntity sm) {
            this.sm = sm;
        }

        public static class SmEntity {
            private boolean hasNext;
            /**
             * purshaseType : 0
             * recommendPic : http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/recommend_pic.png
             * desc : The ONE智能钢琴视频教学直播间主要面向钢琴零基础用户。 我们在课程中会逐步教授识谱，手型，指法，乐理等钢琴基础知识。 直播课程主页：http://online.1tai.com 参加直播课程请加QQ群：418084580
             * teacher : {"name":"佚名","id":0}
             * lessonCount : 15
             * lessons : [{"movieUrl":"http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/lesson_11.mp4","show":true,"desc":"五线谱的重要性总结","course":7,"title":"1.五线谱的重要性","purchase":false,"id":"ikpkkAKQZeSfi_sl8VBtKg","type":1},{"movieUrl":"http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/lesson_12.m4v","show":true,"desc":"五线谱的高低构成","course":7,"title":"2.五线谱高低","purchase":false,"id":"XdT_sFF9V3xDqwH5-mfBXw","type":1},{"movieUrl":"http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/lesson_13.m4v","show":true,"desc":"钢琴的高低构成和循环排列逻辑","course":7,"title":"3.键盘的高低","purchase":false,"id":"YT9LfJtIMTRrHRfAQSCyyw","type":1}]
             * pic : http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/pic.jpg
             * knowledges : None
             * name : 大家一起来识谱
             * id : 7
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
                private int purshaseType;
                private String recommendPic;
                private String desc;
                /**
                 * name : 佚名
                 * id : 0
                 */

                private TeacherEntity teacher;
                private int lessonCount;
                private String pic;
                private String knowledges;
                private String name;
                private int id;
                /**
                 * movieUrl : http://dl.v1.1tai.com/video_courses/zh/dajiayiqilaishipu/lesson_11.mp4
                 * show : true
                 * desc : 五线谱的重要性总结
                 * course : 7
                 * title : 1.五线谱的重要性
                 * purchase : false
                 * id : ikpkkAKQZeSfi_sl8VBtKg
                 * type : 1
                 */

                private List<LessonsEntity> lessons;

                public int getPurshaseType() {
                    return purshaseType;
                }

                public void setPurshaseType(int purshaseType) {
                    this.purshaseType = purshaseType;
                }

                public String getRecommendPic() {
                    return recommendPic;
                }

                public void setRecommendPic(String recommendPic) {
                    this.recommendPic = recommendPic;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public TeacherEntity getTeacher() {
                    return teacher;
                }

                public void setTeacher(TeacherEntity teacher) {
                    this.teacher = teacher;
                }

                public int getLessonCount() {
                    return lessonCount;
                }

                public void setLessonCount(int lessonCount) {
                    this.lessonCount = lessonCount;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getKnowledges() {
                    return knowledges;
                }

                public void setKnowledges(String knowledges) {
                    this.knowledges = knowledges;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public List<LessonsEntity> getLessons() {
                    return lessons;
                }

                public void setLessons(List<LessonsEntity> lessons) {
                    this.lessons = lessons;
                }

                public static class TeacherEntity {
                    private String name;
                    private int id;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }
                }

                public static class LessonsEntity {
                    private String movieUrl;
                    private boolean show;
                    private String desc;
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
}
