package com.lsj.smartpiano.module.course.bean;

import java.util.List;

/**
 * Created by shiny_jia
 * on 2016-05-20 16:22.
 */
public class CourseListBean {

    /**
     * subs : {"hasNext":false,"list":[{"count":47,"desc":"本教程的编写意图是为学生提供一种最容易、最不费力的学习钢琴的方法。 第一册涵盖的音域有意识地作了限制。只介绍中央 C 以上的五个音和以下的五个音，时值也从全音符到四分音符为止，不再扩展，这样就有可能包括许多以复习形式出现的曲例，不必另寻补充教材。本教程的每一册课本都保持各自的完整性，都有各自的书写练习、视谱练习和复习曲目，在以后的各册中还将增加技巧练习。 书中大部分曲例，配有供教师和家长用的伴奏谱。它们都经过精心的创作，使那些简易的小曲听起来尽可能像结构庞大的乐曲的片断。这样做有很多好处，不仅有可能用不同的调弹奏，避免总是徘徊在 C 大调上，令人生厌；而且可以用自己严格的速度和鲜明的节奏对学生施加影响，特别是他们在弹奏中带有充满活力的节拍重音，能使学生一开始就\u201c感觉\u201d到节奏的存在。","url":"http://dl.v1.1tai.com/covers/14.png?sig=1436512694000","createTime":1402377467000,"lastUpdateTime":1436512694000,"purchase":false,"rank":1030,"name":"约翰·汤普森简易钢琴教程 1（小汤 1）","parent":404,"id":14}]}
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
         * list : [{"count":47,"desc":"本教程的编写意图是为学生提供一种最容易、最不费力的学习钢琴的方法。 第一册涵盖的音域有意识地作了限制。只介绍中央 C 以上的五个音和以下的五个音，时值也从全音符到四分音符为止，不再扩展，这样就有可能包括许多以复习形式出现的曲例，不必另寻补充教材。本教程的每一册课本都保持各自的完整性，都有各自的书写练习、视谱练习和复习曲目，在以后的各册中还将增加技巧练习。 书中大部分曲例，配有供教师和家长用的伴奏谱。它们都经过精心的创作，使那些简易的小曲听起来尽可能像结构庞大的乐曲的片断。这样做有很多好处，不仅有可能用不同的调弹奏，避免总是徘徊在 C 大调上，令人生厌；而且可以用自己严格的速度和鲜明的节奏对学生施加影响，特别是他们在弹奏中带有充满活力的节拍重音，能使学生一开始就\u201c感觉\u201d到节奏的存在。","url":"http://dl.v1.1tai.com/covers/14.png?sig=1436512694000","createTime":1402377467000,"lastUpdateTime":1436512694000,"purchase":false,"rank":1030,"name":"约翰·汤普森简易钢琴教程 1（小汤 1）","parent":404,"id":14}]
         */

        private SubsEntity subs;

        public SubsEntity getSubs() {
            return subs;
        }

        public void setSubs(SubsEntity subs) {
            this.subs = subs;
        }

        public static class SubsEntity {
            private boolean hasNext;
            /**
             * count : 47
             * desc : 本教程的编写意图是为学生提供一种最容易、最不费力的学习钢琴的方法。 第一册涵盖的音域有意识地作了限制。只介绍中央 C 以上的五个音和以下的五个音，时值也从全音符到四分音符为止，不再扩展，这样就有可能包括许多以复习形式出现的曲例，不必另寻补充教材。本教程的每一册课本都保持各自的完整性，都有各自的书写练习、视谱练习和复习曲目，在以后的各册中还将增加技巧练习。 书中大部分曲例，配有供教师和家长用的伴奏谱。它们都经过精心的创作，使那些简易的小曲听起来尽可能像结构庞大的乐曲的片断。这样做有很多好处，不仅有可能用不同的调弹奏，避免总是徘徊在 C 大调上，令人生厌；而且可以用自己严格的速度和鲜明的节奏对学生施加影响，特别是他们在弹奏中带有充满活力的节拍重音，能使学生一开始就“感觉”到节奏的存在。
             * url : http://dl.v1.1tai.com/covers/14.png?sig=1436512694000
             * createTime : 1402377467000
             * lastUpdateTime : 1436512694000
             * purchase : false
             * rank : 1030
             * name : 约翰·汤普森简易钢琴教程 1（小汤 1）
             * parent : 404
             * id : 14
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
                private int count;
                private String desc;
                private String url;
                private long createTime;
                private long lastUpdateTime;
                private boolean purchase;
                private int rank;
                private String name;
                private int parent;
                private int id;

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
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

                public boolean isPurchase() {
                    return purchase;
                }

                public void setPurchase(boolean purchase) {
                    this.purchase = purchase;
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

                public int getParent() {
                    return parent;
                }

                public void setParent(int parent) {
                    this.parent = parent;
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
