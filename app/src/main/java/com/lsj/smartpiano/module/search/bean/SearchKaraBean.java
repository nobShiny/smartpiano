package com.lsj.smartpiano.module.search.bean;

import java.util.List;

/**
 * Created by shiny_jia
 * on 2016-05-24 21:04.
 */
public class SearchKaraBean {

    /**
     * karas : {"nextCursor":2,"hasNext":true,"list":[{"picUrl":"http://dl.v1.1tai.com/ez_accomps/cn/jay_chou/nanshannan/pic.png?sig=1445506838000","picThumbUrl":"http://dl.v1.1tai.com/ez_accomps/cn/jay_chou/nanshannan/pic_thumb.jpg?sig=1445506838000","artist":"马頔","bgm":"http://dl.v1.1tai.com/ez_accomps/cn/jay_chou/nanshannan/bgm.mp3?sig=1445506838000","keyGuide":"http://dl.v1.1tai.com/ez_accomps/cn/jay_chou/nanshannan/easy.mid?sig=1445506838000","name":"【中级】南山南（弹唱）","id":478},{"picUrl":"http://dl.v1.1tai.com/ez_accomps/cn/recent_bantan/nanshannan1/pic.png?sig=1446624464000","picThumbUrl":"http://dl.v1.1tai.com/ez_accomps/cn/recent_bantan/nanshannan1/pic_thumb.jpg?sig=1446624464000","artist":"马頔","bgm":"http://dl.v1.1tai.com/ez_accomps/cn/recent_bantan/nanshannan1/bgm.mp3?sig=1446624464000","lyrics":"http://dl.v1.1tai.com/ez_accomps/cn/recent_bantan/nanshannan1/lyrics.lrc?sig=1446624464000","keyGuide":"http://dl.v1.1tai.com/ez_accomps/cn/recent_bantan/nanshannan1/easy.mid?sig=1446624464000","name":"南山南","id":488}]}
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
         * list : [{"picUrl":"http://dl.v1.1tai.com/ez_accomps/cn/jay_chou/nanshannan/pic.png?sig=1445506838000","picThumbUrl":"http://dl.v1.1tai.com/ez_accomps/cn/jay_chou/nanshannan/pic_thumb.jpg?sig=1445506838000","artist":"马頔","bgm":"http://dl.v1.1tai.com/ez_accomps/cn/jay_chou/nanshannan/bgm.mp3?sig=1445506838000","keyGuide":"http://dl.v1.1tai.com/ez_accomps/cn/jay_chou/nanshannan/easy.mid?sig=1445506838000","name":"【中级】南山南（弹唱）","id":478},{"picUrl":"http://dl.v1.1tai.com/ez_accomps/cn/recent_bantan/nanshannan1/pic.png?sig=1446624464000","picThumbUrl":"http://dl.v1.1tai.com/ez_accomps/cn/recent_bantan/nanshannan1/pic_thumb.jpg?sig=1446624464000","artist":"马頔","bgm":"http://dl.v1.1tai.com/ez_accomps/cn/recent_bantan/nanshannan1/bgm.mp3?sig=1446624464000","lyrics":"http://dl.v1.1tai.com/ez_accomps/cn/recent_bantan/nanshannan1/lyrics.lrc?sig=1446624464000","keyGuide":"http://dl.v1.1tai.com/ez_accomps/cn/recent_bantan/nanshannan1/easy.mid?sig=1446624464000","name":"南山南","id":488}]
         */

        private KarasEntity karas;

        public KarasEntity getKaras() {
            return karas;
        }

        public void setKaras(KarasEntity karas) {
            this.karas = karas;
        }

        public static class KarasEntity {
            private int nextCursor;
            private boolean hasNext;
            /**
             * picUrl : http://dl.v1.1tai.com/ez_accomps/cn/jay_chou/nanshannan/pic.png?sig=1445506838000
             * picThumbUrl : http://dl.v1.1tai.com/ez_accomps/cn/jay_chou/nanshannan/pic_thumb.jpg?sig=1445506838000
             * artist : 马頔
             * bgm : http://dl.v1.1tai.com/ez_accomps/cn/jay_chou/nanshannan/bgm.mp3?sig=1445506838000
             * keyGuide : http://dl.v1.1tai.com/ez_accomps/cn/jay_chou/nanshannan/easy.mid?sig=1445506838000
             * name : 【中级】南山南（弹唱）
             * id : 478
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
                private String picUrl;
                private String picThumbUrl;
                private String artist;
                private String bgm;
                private String keyGuide;
                private String name;
                private int id;

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public String getPicThumbUrl() {
                    return picThumbUrl;
                }

                public void setPicThumbUrl(String picThumbUrl) {
                    this.picThumbUrl = picThumbUrl;
                }

                public String getArtist() {
                    return artist;
                }

                public void setArtist(String artist) {
                    this.artist = artist;
                }

                public String getBgm() {
                    return bgm;
                }

                public void setBgm(String bgm) {
                    this.bgm = bgm;
                }

                public String getKeyGuide() {
                    return keyGuide;
                }

                public void setKeyGuide(String keyGuide) {
                    this.keyGuide = keyGuide;
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
