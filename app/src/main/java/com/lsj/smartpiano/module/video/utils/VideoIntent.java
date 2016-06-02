package com.lsj.smartpiano.module.video.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.lsj.smartpiano.module.video.ui.VideoViewPlayerActivity;

/**
 * Created by shiny_jia
 * on 2016-06-02 11:37.
 */
public class VideoIntent extends Intent {


    public VideoIntent() {
    }

    public VideoIntent(Context packageContext, Class<?> cls) {
        super(packageContext, cls);
    }

    public void uriStartVideo(String uri) {
        this.putExtra("PlayerSign", 2);
        Uri uri1 = Uri.parse(uri);
        VideoUri videoUri = new VideoUri(uri1);
        VideoViewPlayerActivity.uri = videoUri;
    }

    public void pathStartVideo(String path) {
        this.putExtra("PlayerSign", 1);
        this.putExtra("path", path);
    }

    public class VideoUri {
        private Uri uri;
        public VideoUri(Uri u){
            uri=u;
        }
        public Uri getUri() {
            return uri;
        }
    }
}