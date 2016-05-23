package com.lsj.smartpiano.module.course.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shiny_jia
 * on 2016-05-20 16:20.
 */
public class CourseCategoryBean {

    /**
     * xx : {"hasNext":false,"list":[{"desc":"","createTime":1447751458000,"lastUpdateTime":1447751458000,"rank":0,"name":"热门推荐","id":598}]}
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
         * list : [{"desc":"","createTime":1447751458000,"lastUpdateTime":1447751458000,"rank":0,"name":"热门推荐","id":598}]
         */

        @SerializedName("1")
        private XxEntity xx;

        public XxEntity getXx() {
            return xx;
        }

        public void setXx(XxEntity xx) {
            this.xx = xx;
        }

        public static class XxEntity {
            private boolean hasNext;
            /**
             * desc :
             * createTime : 1447751458000
             * lastUpdateTime : 1447751458000
             * rank : 0
             * name : 热门推荐
             * id : 598
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
                private String desc;
                private long createTime;
                private long lastUpdateTime;
                private int rank;
                private String name;
                private int id;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public long getLastUpdateTime() {
                    return lastUpdateTime;
                }

                public void setLastUpdateTime(long lastUpdateTime) {
                    this.lastUpdateTime = lastUpdateTime;
                }

                public int getRank() {
                    return rank;
                }

                public void setRank(int rank) {
                    this.rank = rank;
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
            }
        }
    }
}
