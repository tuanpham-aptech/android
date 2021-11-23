package com.example.controlpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView playerPosition, playerDuration;
    SeekBar seekBar;
    ImageView btnPrev,btnNext,btnPause,btnPlay;
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerPosition = findViewById(R.id.player_position);
        playerDuration = findViewById(R.id.player_duration);
        seekBar = findViewById(R.id.seek_bar);
        btnPrev = findViewById(R.id.btn_rew);
        btnNext = findViewById(R.id.btn_next);
        btnPause = findViewById(R.id.btn_pause);
        btnPlay = findViewById(R.id.btn_play);
        // khởi tạo mediaplayer
        mediaPlayer = MediaPlayer.create(this,R.raw.cauhencauthe);
        // khởi tạo runable phát nhạc
        runnable = new Runnable() {
            @Override
            public void run() {
                // thiết lập cho thanh phát
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                // điều khiển độ chễ 0.5s
                handler.postDelayed(this,500);
            }
        };
        //nhận thời lượng của trình phát đa phương tiện
        int duration = mediaPlayer.getDuration();
        // chuyển đổi
        String sDuration = convertFormat(duration);
        // set chuyển đổi trên textview
        playerDuration.setText(sDuration);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // hide play button
                btnPlay.setVisibility(View.GONE);
                // Show pause button
                btnPause.setVisibility(View.VISIBLE);
                // start mediaplayer
                mediaPlayer.start();
//                set max on seebar
                seekBar.setMax(mediaPlayer.getDuration());
                // Start handler
                handler.postDelayed(runnable,0);
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // hide pause button
                btnPause.setVisibility(View.GONE);
                // Show play button
                btnPlay.setVisibility(View.VISIBLE);
                // start mediaplayer
                mediaPlayer.pause();
                // stop handler
                handler.removeCallbacks(runnable);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                int duration = mediaPlayer.getDuration();
                if(mediaPlayer.isPlaying() && duration !=currentPosition){
                    currentPosition =currentPosition + 5000;
                    playerPosition.setText(convertFormat(currentPosition));
                    mediaPlayer.seekTo(currentPosition);
                }
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                if(mediaPlayer.isPlaying() && currentPosition > 5000){
                    currentPosition =currentPosition - 5000;
                    playerPosition.setText(convertFormat(currentPosition));
                    mediaPlayer.seekTo(currentPosition);
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                }
                playerPosition.setText(convertFormat(mediaPlayer.getCurrentPosition()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                btnPause.setVisibility(View.GONE);
                btnPlay.setVisibility(View.VISIBLE);
                mediaPlayer.seekTo(0);
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {
        return String.format("%02d:%02d", TimeUnit.MICROSECONDS.toMinutes(duration),
                TimeUnit.MICROSECONDS.toSeconds(duration),
                TimeUnit.MINUTES.toSeconds(TimeUnit.MICROSECONDS.toMinutes(duration)));
    }
}