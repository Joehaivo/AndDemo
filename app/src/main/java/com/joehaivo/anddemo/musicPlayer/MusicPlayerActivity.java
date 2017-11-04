package com.joehaivo.anddemo.musicPlayer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.joehaivo.anddemo.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class MusicPlayerActivity extends AppCompatActivity {

    static MediaPlayer mediaPlayer;
    int currentPosition;
    private static final int READ_REQUEST_CODE = 42;
    Uri uri = null;
    int maxDuration;
    TextView musicNowplay;
    Animation playButtonClickAnimation;
    Animation addButtonClickAnimation;
    List localMusicList;
    ListView musicListView;
    ArrayAdapter stringArrayAdapter;
    SimpleAdapter simpleAdapter;
    List<Map<String, Object>> musicListMap;
    Uri nowPlayUri;
    int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        musicListView = (ListView) findViewById(R.id.musicListView);
        musicListMap = new ArrayList<>();
        nowPlayUri = Uri.EMPTY;
        mediaPlayer = new MediaPlayer();
        musicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //TODO 转到Service播放
                Map<String, Object> tempMap = musicListMap.get(i);
                Uri myUri = Uri.parse(tempMap.get("DATA").toString());
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlay(myUri,progress);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        setSimpleAdapter();
    }


    private void mediaPlay(Uri uri,int progress) throws IOException {
        if (uri.equals(nowPlayUri)){
            if (mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }else {
                mediaPlayer.seekTo(progress);
                mediaPlayer.start();
            }
        }else {
            if (mediaPlayer.isPlaying()){
                mediaPlayer.reset();
                mediaPlayer.setDataSource(MusicPlayerActivity.this,uri);
                mediaPlayer.prepare();
                mediaPlayer.seekTo(progress);
                mediaPlayer.start();
                nowPlayUri = uri;
            }else{
                mediaPlayer.reset();
                mediaPlayer.setDataSource(MusicPlayerActivity.this,uri);
                mediaPlayer.prepare();
                mediaPlayer.seekTo(progress);
                mediaPlayer.start();
                nowPlayUri = uri;
            }
        }
    }
    //初始化ListView，显示音乐列表
    private void setSimpleAdapter(){
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        while (cursor.moveToNext()) {
            // 歌曲ID：MediaStore.Audio.Media._ID
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
            // 歌曲的名称 ：MediaStore.Audio.Media.TITLE
            String title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
            // 歌曲的专辑名：MediaStore.Audio.Media.ALBUM
            String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
            // 歌曲的歌手名： MediaStore.Audio.Media.ARTIST
            String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
            // 歌曲文件的路径 ：MediaStore.Audio.Media.DATA
            String url = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
            // 歌曲的总播放时长 ：MediaStore.Audio.Media.DURATION
            int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
            // 歌曲文件的大小 ：MediaStore.Audio.Media.SIZE
            long size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));

            Map<String, Object> map = new HashMap<>();
            map.put("_ID", id);
            map.put("ALBUM", album);
            map.put("ARTIST", artist);
            map.put("DATA", url);
            map.put("DURATION", duration);
            map.put("SIZE", size);
            map.put("ART_TITLE", artist + " - " + title);
            musicListMap.add(map);
        }
        simpleAdapter = new SimpleAdapter(this, musicListMap, R.layout.simple_list_item_music,
                new String[]{"ART_TITLE"}, new int[]{R.id.musicListItem});
        musicListView.setAdapter(simpleAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.reset();
        mediaPlayer.release();
    }
}
