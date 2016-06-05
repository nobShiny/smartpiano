package com.lsj.smartpiano.module.video.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shiny_jia
 * on 2016-05-18 17:11.
 */
public class AdvanceListBean implements Serializable{

    /**
     * courses : {"hasNext":false,"list":[{"purshaseType":0,"recommendPic":"http://dl.v1.1tai.com/video_courses/zh/zhibokechengjingxuan-chongerfei/recommend_pic.png","desc":"The ONE智能钢琴视频教学直播间主要面向钢琴零基础用户。 我们在课程中会逐步教授识谱，手型，指法，乐理等钢琴基础知识。 直播课程主页：http://online.1tai.com 参加直播课程请加QQ群：418084580","teacher":{"name":"佚名","id":0},"lessonCount":19,"pic":"http://dl.v1.1tai.com/video_courses/zh/zhibokechengjingxuan-chongerfei/pic.jpg","knowledges":"","name":"直播课－虫儿飞（初级琴童）","id":65}]}
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
         * list : [{"purshaseType":0,"recommendPic":"http://dl.v1.1tai.com/video_courses/zh/zhibokechengjingxuan-chongerfei/recommend_pic.png","desc":"The ONE智能钢琴视频教学直播间主要面向钢琴零基础用户。 我们在课程中会逐步教授识谱，手型，指法，乐理等钢琴基础知识。 直播课程主页：http://online.1tai.com 参加直播课程请加QQ群：418084580","teacher":{"name":"佚名","id":0},"lessonCount":19,"pic":"http://dl.v1.1tai.com/video_courses/zh/zhibokechengjingxuan-chongerfei/pic.jpg","knowledges":"","name":"直播课－虫儿飞（初级琴童）","id":65}]
         */

        private CoursesEntity courses;

        public CoursesEntity getCourses() {
            return courses;
        }

        public void setCourses(CoursesEntity courses) {
            this.courses = courses;
        }

        public static class CoursesEntity {
            private boolean hasNext;
            /**
             * purshaseType : 0
             * recommendPic : http://dl.v1.1tai.com/video_courses/zh/zhibokechengjingxuan-chongerfei/recommend_pic.png
             * desc : The ONE智能钢琴视频教学直播间主要面向钢琴零基础用户。 我们在课程中会逐步教授识谱，手型，指法，乐理等钢琴基础知识。 直播课程主页：http://online.1tai.com 参加直播课程请加QQ群：418084580
             * teacher : {"name":"佚名","id":0}
             * lessonCount : 19
             * pic : http://dl.v1.1tai.com/video_courses/zh/zhibokechengjingxuan-chongerfei/pic.jpg
             * knowledges :
             * name : 直播课－虫儿飞（初级琴童）
             * id : 65
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
            }
        }
    }
}
