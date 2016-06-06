package com.lsj.smartpiano.module.karagame.bean;

import java.util.List;

/**
 * Created by shiny_jia
 * on 2016-05-05 17:59.
 */
public class KaraGameListBean {


    /**
     * karas : {"hasNext":false,"list":[{"picUrl":"http://dl.v1.1tai.com/ez_accomps/cn/i_am_a_singer/kangdingqingge/pic.png?sig=1445508061000","picThumbUrl":"http://dl.v1.1tai.com/ez_accomps/cn/i_am_a_singer/kangdingqingge/pic_thumb.jpg?sig=1445508061000","artist":"【弹唱专区】谭维维","bgm":"http://dl.v1.1tai.com/ez_accomps/cn/i_am_a_singer/kangdingqingge/bgm.mp3?sig=1445508061000","keyGuide":"http://dl.v1.1tai.com/ez_accomps/cn/i_am_a_singer/kangdingqingge/hard.mid?sig=1445508061000","name":"【专家级】康定情歌","id":221}]}
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
         * list : [{"picUrl":"http://dl.v1.1tai.com/ez_accomps/cn/i_am_a_singer/kangdingqingge/pic.png?sig=1445508061000","picThumbUrl":"http://dl.v1.1tai.com/ez_accomps/cn/i_am_a_singer/kangdingqingge/pic_thumb.jpg?sig=1445508061000","artist":"【弹唱专区】谭维维","bgm":"http://dl.v1.1tai.com/ez_accomps/cn/i_am_a_singer/kangdingqingge/bgm.mp3?sig=1445508061000","keyGuide":"http://dl.v1.1tai.com/ez_accomps/cn/i_am_a_singer/kangdingqingge/hard.mid?sig=1445508061000","name":"【专家级】康定情歌","id":221}]
         */

        private KarasEntity karas;

        public KarasEntity getKaras() {
            return karas;
        }

        public void setKaras(KarasEntity karas) {
            this.karas = karas;
        }

        public static class KarasEntity {
            private boolean hasNext;
            /**
             * picUrl : http://dl.v1.1tai.com/ez_accomps/cn/i_am_a_singer/kangdingqingge/pic.png?sig=1445508061000
             * picThumbUrl : http://dl.v1.1tai.com/ez_accomps/cn/i_am_a_singer/kangdingqingge/pic_thumb.jpg?sig=1445508061000
             * artist : 【弹唱专区】谭维维
             * bgm : http://dl.v1.1tai.com/ez_accomps/cn/i_am_a_singer/kangdingqingge/bgm.mp3?sig=1445508061000
             * keyGuide : http://dl.v1.1tai.com/ez_accomps/cn/i_am_a_singer/kangdingqingge/hard.mid?sig=1445508061000
             * name : 【专家级】康定情歌
             * id : 221
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
