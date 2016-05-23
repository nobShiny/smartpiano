package com.lsj.smartpiano.module.course.bean;

import java.util.List;

/**
 * Created by shiny_jia
 * on 2016-05-20 16:24.
 */
public class CourseBean {

    /**
     * songs : {"hasNext":false,"list":[{"category":613,"subCateName":"TheONE 在线学小汤","level":1,"categoryName":"热门推荐","url":"http://dl.v1.1tai.com/scores/toms/14911.toms?sig=1450251461000","title":"约翰·汤普森简易钢琴教程 1（直播课1）","subCategory":613,"artist":{"name":"定制","id":2367},"lowestNote":59,"highestNote":64,"purchase":false,"id":14911}]}
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
         * list : [{"category":613,"subCateName":"TheONE 在线学小汤","level":1,"categoryName":"热门推荐","url":"http://dl.v1.1tai.com/scores/toms/14911.toms?sig=1450251461000","title":"约翰·汤普森简易钢琴教程 1（直播课1）","subCategory":613,"artist":{"name":"定制","id":2367},"lowestNote":59,"highestNote":64,"purchase":false,"id":14911}]
         */

        private SongsEntity songs;

        public SongsEntity getSongs() {
            return songs;
        }

        public void setSongs(SongsEntity songs) {
            this.songs = songs;
        }

        public static class SongsEntity {
            private boolean hasNext;
            /**
             * category : 613
             * subCateName : TheONE 在线学小汤
             * level : 1
             * categoryName : 热门推荐
             * url : http://dl.v1.1tai.com/scores/toms/14911.toms?sig=1450251461000
             * title : 约翰·汤普森简易钢琴教程 1（直播课1）
             * subCategory : 613
             * artist : {"name":"定制","id":2367}
             * lowestNote : 59
             * highestNote : 64
             * purchase : false
             * id : 14911
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
                private int category;
                private String subCateName;
                private int level;
                private String categoryName;
                private String url;
                private String title;
                private int subCategory;
                /**
                 * name : 定制
                 * id : 2367
                 */

                private ArtistEntity artist;
                private int lowestNote;
                private int highestNote;
                private boolean purchase;
                private int id;

                public int getCategory() {
                    return category;
                }

                public void setCategory(int category) {
                    this.category = category;
                }

                public String getSubCateName() {
                    return subCateName;
                }

                public void setSubCateName(String subCateName) {
                    this.subCateName = subCateName;
                }

                public int getLevel() {
                    return level;
                }

                public void setLevel(int level) {
                    this.level = level;
                }

                public String getCategoryName() {
                    return categoryName;
                }

                public void setCategoryName(String categoryName) {
                    this.categoryName = categoryName;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getSubCategory() {
                    return subCategory;
                }

                public void setSubCategory(int subCategory) {
                    this.subCategory = subCategory;
                }

                public ArtistEntity getArtist() {
                    return artist;
                }

                public void setArtist(ArtistEntity artist) {
                    this.artist = artist;
                }

                public int getLowestNote() {
                    return lowestNote;
                }

                public void setLowestNote(int lowestNote) {
                    this.lowestNote = lowestNote;
                }

                public int getHighestNote() {
                    return highestNote;
                }

                public void setHighestNote(int highestNote) {
                    this.highestNote = highestNote;
                }

                public boolean isPurchase() {
                    return purchase;
                }

                public void setPurchase(boolean purchase) {
                    this.purchase = purchase;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public static class ArtistEntity {
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
