package com.example.playlist;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView vistamusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Musica> playlist = new ArrayList<>();
        crearPlaylist(playlist);

        vistamusica = findViewById(R.id.vistamusica);
        vistamusica.setLayoutManager(new LinearLayoutManager(this));
        vistamusica.setAdapter(new AdaptadorMusica(playlist));
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            vistamusica.setLayoutManager(new GridLayoutManager(this, 2));
        }
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            vistamusica.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    public void crearPlaylist(List<Musica> playlist){
        playlist.add(new Musica("Enemy", "Imagine Dragons", R.drawable.arcane, R.raw.enemy));
        playlist.add(new Musica("Come Play", "Young Miko & demas", R.drawable.arcane, R.raw.comeplay));
        playlist.add(new Musica("Two ashes and blood", "Woodkid", R.drawable.arcane, R.raw.toashes));
        playlist.add(new Musica("Enemy", "Imagine Dragons", R.drawable.arcane, R.raw.enemy));
        playlist.add(new Musica("Come Play", "Young Miko & demas", R.drawable.arcane, R.raw.comeplay));
        playlist.add(new Musica("Two ashes and blood", "Woodkid", R.drawable.arcane, R.raw.toashes));
        playlist.add(new Musica("Enemy", "Imagine Dragons", R.drawable.arcane, R.raw.enemy));
        playlist.add(new Musica("Come Play", "Young Miko & demas", R.drawable.arcane, R.raw.comeplay));
        playlist.add(new Musica("Two ashes and blood", "Woodkid", R.drawable.arcane, R.raw.toashes));
        playlist.add(new Musica("Enemy", "Imagine Dragons", R.drawable.arcane, R.raw.enemy));
        playlist.add(new Musica("Come Play", "Young Miko & demas", R.drawable.arcane, R.raw.comeplay));
        playlist.add(new Musica("Two ashes and blood", "Woodkid", R.drawable.arcane, R.raw.toashes));
    }
}