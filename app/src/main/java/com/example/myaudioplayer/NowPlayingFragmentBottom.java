package com.example.myaudioplayer;

import android.media.MediaMetadataRetriever;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.myaudioplayer.MainActivity.ARTIST_NAME;
import static com.example.myaudioplayer.MainActivity.ARTIST_TO_FRAG;
import static com.example.myaudioplayer.MainActivity.PATH_TO_FRAG;
import static com.example.myaudioplayer.MainActivity.SHOW_MINI_PLAYER;
import static com.example.myaudioplayer.MainActivity.SONG_NAME_TO_FRAG;


public class NowPlayingFragmentBottom extends Fragment {

    ImageView nextBtn, albumArt;
    TextView artist,songName;
    FloatingActionButton playPauseBtn;
    View view;
    public NowPlayingFragmentBottom() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_now_playing_bottom, container, false);

        artist = view.findViewById(R.id.song_artist_miniPlayer);
        songName = view.findViewById(R.id.song_name_miniPlayer);
        albumArt = view.findViewById(R.id.bottom_album_art);
        nextBtn = view.findViewById(R.id.skip_next_bottom);
        playPauseBtn = view.findViewById(R.id.play_pause_miniPlayer);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        playPauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(SHOW_MINI_PLAYER){
            if(PATH_TO_FRAG !=null){
                byte[] art = getAlbumArt(PATH_TO_FRAG);
                if(art !=null){
                    Glide.with(getContext()).load(art).into(albumArt);
                }else{
                    Glide.with(getContext()).load(R.mipmap.ic_launcher).into(albumArt);
                }

                songName.setText(SONG_NAME_TO_FRAG);
                artist.setText(ARTIST_TO_FRAG);
            }
        }
    }

    private byte[] getAlbumArt(String uri){
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(uri);
        byte[] art = retriever.getEmbeddedPicture();
        //retriever.release();
        return art;
    }
}