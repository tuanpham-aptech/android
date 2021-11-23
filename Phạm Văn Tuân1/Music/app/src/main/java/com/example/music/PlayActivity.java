package com.example.music;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PlayActivity extends AppCompatActivity {
    private Intent intent;
    private ImageView play;
    private int check=1;
    private MediaPlayer mediaPlayer;
    private Toolbar toolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp);
        play=findViewById(R.id.play);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intent=getIntent();
        Baihat bh= (Baihat) intent.getSerializableExtra("BAIHAT");
      getSupportActionBar().setTitle(bh.getTenbaihat());
toolbar.setNavigationOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        finish();
    }
});
         mediaPlayer=MediaPlayer.create(this,bh.getBaihat());
        mediaPlayer.start();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (check){
                    case 0: play.setImageResource(R.drawable.ic_baseline_pause_presentation_24);
                         mediaPlayer=MediaPlayer.create(PlayActivity.this,bh.getBaihat());
                        mediaPlayer.start();
                        check=1;
                        break;
                    case 1:
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        play.setImageResource(R.drawable.ic_baseline_play_arrow_24);
                        check=0;
                        break;
                }
                if(mediaPlayer.isPlaying()){

                    check=1;
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }
}
