package com.joehaivo.anddemo.musicPlayer;

/**
 * Created by haivo on 2017-09-22.
 */

public class MusicInfo {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    private int id;
    // 歌曲的名称 ：MediaStore.Audio.Media.TITLE
    private String title;

    // 歌曲的专辑名：MediaStore.Audio.Media.ALBUM
    private String album;
    // 歌曲的歌手名： MediaStore.Audio.Media.ARTIST
    private String artist;

    // 歌曲文件的路径 ：MediaStore.Audio.Media.DATA
    private String url;
    // 歌曲的总播放时长 ：MediaStore.Audio.Media.DURATION
    private int duration;
    // 歌曲文件的大小 ：MediaStore.Audio.Media.SIZE
    private long size;
}
