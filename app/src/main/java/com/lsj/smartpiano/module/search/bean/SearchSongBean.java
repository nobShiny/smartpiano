package com.lsj.smartpiano.module.search.bean;

import java.util.List;

/**
 * Created by shiny_jia
 * on 2016-05-24 21:02.
 */
public class SearchSongBean {
    /**
     * songs : {"nextCursor":2,"hasNext":true,"list":[{"category":197,"subCateName":"大众流行钢琴曲集","level":3,"categoryName":"影视流行","url":"http://dl.v1.1tai.com/scores/toms/13434.toms?sig=1443367016000","title":"南山南","subCategory":197,"artist":{"name":"马頔","id":2294},"lowestNote":36,"highestNote":91,"purchase":false,"id":13434}]}
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
         * nextCursor : 2
         * hasNext : true
         * list : [{"category":197,"subCateName":"大众流行钢琴曲集","level":3,"categoryName":"影视流行","url":"http://dl.v1.1tai.com/scores/toms/13434.toms?sig=1443367016000","title":"南山南","subCategory":197,"artist":{"name":"马頔","id":2294},"lowestNote":36,"highestNote":91,"purchase":false,"id":13434}]
         */

        private SongsEntity songs;

        public SongsEntity getSongs() {
            return songs;
        }

        public void setSongs(SongsEntity songs) {
            this.songs = songs;
        }

        public static class SongsEntity {
            private int nextCursor;
            private boolean hasNext;
            /**
             * category : 197
             * subCateName : 大众流行钢琴曲集
             * level : 3
             * categoryName : 影视流行
             * url : http://dl.v1.1tai.com/scores/toms/13434.toms?sig=1443367016000
             * title : 南山南
             * subCategory : 197
             * artist : {"name":"马頔","id":2294}
             * lowestNote : 36
             * highestNote : 91
             * purchase : false
             * id : 13434
             */

            private List<ListEntity> list;

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
                 * name : 马頔
                 * id : 2294
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
