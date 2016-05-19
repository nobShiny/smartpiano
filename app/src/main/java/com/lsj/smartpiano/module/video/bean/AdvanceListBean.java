package com.lsj.smartpiano.module.video.bean;

import java.util.List;

/**
 * Created by shiny_jia
 * on 2016-05-18 17:11.
 */
public class AdvanceListBean {

    /**
     * code : 1
     * hostname : piano-aws-1tai-com
     * oversea : false
     * cost : 20
     * timestamp : 1463563565841
     */

    private MetaEntity meta;
    /**
     * courses : {"hasNext":false,"list":[{"purshaseType":0,"recommendPic":"http://dl.v1.1tai.com/video_courses/zh/mimi/recommend_pic.png","desc":"《秘密》周杰伦在2007年自导自演的电影处女作《不能说的秘密》中的插曲。周董亲自包办了整个电影的配乐部分，并创作了这首有些复古又流行的钢琴作品。这首《秘密》分为慢板和加长快板两个版本，分别出现在电影里男主角在钢琴前来回穿越的剧情中。这首为慢板。 知识点：左右手分别练+指法的重要性","teacher":{"name":"佚名","id":0},"lessonCount":3,"pic":"http://dl.v1.1tai.com/video_courses/zh/mimi/pic.jpg","knowledges":null,"name":"秘密","id":59}]}
     */

    private DataEntity data;

    public MetaEntity getMeta() {
        return meta;
    }

    public void setMeta(MetaEntity meta) {
        this.meta = meta;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class MetaEntity {
        private int code;
        private String hostname;
        private boolean oversea;
        private int cost;
        private long timestamp;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getHostname() {
            return hostname;
        }

        public void setHostname(String hostname) {
            this.hostname = hostname;
        }

        public boolean isOversea() {
            return oversea;
        }

        public void setOversea(boolean oversea) {
            this.oversea = oversea;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }
    }

    public static class DataEntity {
        /**
         * hasNext : false
         * list : [{"purshaseType":0,"recommendPic":"http://dl.v1.1tai.com/video_courses/zh/mimi/recommend_pic.png","desc":"《秘密》周杰伦在2007年自导自演的电影处女作《不能说的秘密》中的插曲。周董亲自包办了整个电影的配乐部分，并创作了这首有些复古又流行的钢琴作品。这首《秘密》分为慢板和加长快板两个版本，分别出现在电影里男主角在钢琴前来回穿越的剧情中。这首为慢板。 知识点：左右手分别练+指法的重要性","teacher":{"name":"佚名","id":0},"lessonCount":3,"pic":"http://dl.v1.1tai.com/video_courses/zh/mimi/pic.jpg","knowledges":null,"name":"秘密","id":59}]
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
             * recommendPic : http://dl.v1.1tai.com/video_courses/zh/mimi/recommend_pic.png
             * desc : 《秘密》周杰伦在2007年自导自演的电影处女作《不能说的秘密》中的插曲。周董亲自包办了整个电影的配乐部分，并创作了这首有些复古又流行的钢琴作品。这首《秘密》分为慢板和加长快板两个版本，分别出现在电影里男主角在钢琴前来回穿越的剧情中。这首为慢板。 知识点：左右手分别练+指法的重要性
             * teacher : {"name":"佚名","id":0}
             * lessonCount : 3
             * pic : http://dl.v1.1tai.com/video_courses/zh/mimi/pic.jpg
             * knowledges : null
             * name : 秘密
             * id : 59
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
                private Object knowledges;
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

                public Object getKnowledges() {
                    return knowledges;
                }

                public void setKnowledges(Object knowledges) {
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
