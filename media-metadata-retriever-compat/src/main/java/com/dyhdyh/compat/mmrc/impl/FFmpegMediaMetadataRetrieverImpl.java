package com.dyhdyh.compat.mmrc.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

import com.dyhdyh.compat.mmrc.IMediaMetadataRetriever;

import java.io.FileDescriptor;
import java.util.Map;

import wseemann.media.FFmpegMediaMetadataRetriever;

/**
 * 基于ffmpeg实现
 * author  dengyuhan
 * created 2017/5/26 14:51
 */
public class FFmpegMediaMetadataRetrieverImpl implements IMediaMetadataRetriever {
    private FFmpegMediaMetadataRetriever mRetriever;

    public FFmpegMediaMetadataRetrieverImpl() {
        this.mRetriever = new FFmpegMediaMetadataRetriever();
    }

    @Override
    public void setDataSource(String path) {
        this.mRetriever.setDataSource(path);
    }

    @Override
    public void setDataSource(Context context, Uri uri) {
        this.mRetriever.setDataSource(context, uri);
    }

    @Override
    public void setDataSource(String uri, Map<String, String> headers) {
        this.mRetriever.setDataSource(uri, headers);
    }

    @Override
    public void setDataSource(FileDescriptor fd, long offset, long length) {
        this.mRetriever.setDataSource(fd, offset, length);
    }

    @Override
    public void setDataSource(FileDescriptor fd) {
        this.mRetriever.setDataSource(fd);
    }

    @Override
    public Bitmap getFrameAtTime() {
        return this.mRetriever.getFrameAtTime();
    }

    @Override
    public Bitmap getFrameAtTime(long timeUs, int option) {
        return this.mRetriever.getFrameAtTime(timeUs, option);
    }

    @Override
    public Bitmap getScaledFrameAtTime(long timeUs, int width, int height) {
        return this.mRetriever.getScaledFrameAtTime(timeUs, width, height);
    }

    @Override
    public Bitmap getScaledFrameAtTime(long timeUs, int option, int width, int height) {
        return this.mRetriever.getScaledFrameAtTime(timeUs, option, width, height);
    }

    @Override
    public byte[] getEmbeddedPicture() {
        return this.mRetriever.getEmbeddedPicture();
    }

    @Override
    public String extractMetadata(String keyCode) {
        return this.mRetriever.extractMetadata(keyCode);
    }

    @Override
    public void release() {
        this.mRetriever.release();
    }

}