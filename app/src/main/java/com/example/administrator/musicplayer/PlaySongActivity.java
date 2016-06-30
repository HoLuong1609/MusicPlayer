package com.example.administrator.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;

import models.Song;
import services.MusicService;
import utils.Config;

public class PlaySongActivity extends AppCompatActivity{

    private SeekBar seekBar;
    private TextView tvCurrentTime, tvTotalTime, tvSongName;
    private ImageButton btnPlay;

    private Song selectedSong;
    private int songPosition;
    private int songDuration;
    private List<Song> mSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        tvCurrentTime = (TextView) findViewById(R.id.tvCurrentTime);
        tvTotalTime = (TextView) findViewById(R.id.tvTotalTime);
        tvSongName = (TextView) findViewById(R.id.tvSongName);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);

        songPosition = getIntent().getIntExtra(Config.KEY_SONG_POSITION, 0);
        mSongs = Config.getListSongs(this);
        selectedSong = mSongs.get(songPosition);
        setDefaultInfo();

        // playing music
        Intent playSongIntent = new Intent(PlaySongActivity.this, MusicService.class);
        playSongIntent.putExtra(Config.KEY_SONG_POSITION, songPosition);
        startService(playSongIntent);
    }

    public void play(View v) {
    }

    public void previous(View v) {
    }

    public void next(View v) {
    }

    public void backward(View v) {
    }

    public void forward(View v) {
    }

    private void setDefaultInfo() {
        String songTitle = selectedSong.getTitle();
        songDuration = selectedSong.getDuration();

        tvSongName.setText(songTitle);
        tvCurrentTime.setText(Config.getTextFormat(0));
        tvTotalTime.setText(Config.getTextFormat(songDuration));
        seekBar.setMax(songDuration);
        seekBar.setProgress(0);
    }

}