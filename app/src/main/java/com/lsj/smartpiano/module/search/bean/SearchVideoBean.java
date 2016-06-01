package com.lsj.smartpiano.module.search.bean;

import java.util.List;

/**
 * Created by shiny_jia
 * on 2016-05-24 20:44.
 */
public class SearchVideoBean {

    /**
     * lessons : {"nextCursor":0,"hasNext":true,"list":[]}
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
         * nextCursor : 0
         * hasNext : true
         * list : []
         */

        private LessonsEntity lessons;

        public LessonsEntity getLessons() {
            return lessons;
        }

        public void setLessons(LessonsEntity lessons) {
            this.lessons = lessons;
        }

        public static class LessonsEntity {
            private int nextCursor;
            private boolean hasNext;
            private List<?> list;

            public int getNextCursor() {
                return nextCursor;
            }

            public void setNextCursor(int nextCursor) {
                this.nextCursor = nextCursor;
            }

            public boolean isHasNext() {
                return hasNext;
            }

            public void setHasNext(boolean hasNext) {
                this.hasNext = hasNext;
            }

            public List<?> getList() {
                return list;
            }

            public void setList(List<?> list) {
                this.list = list;
            }
        }
    }

}
