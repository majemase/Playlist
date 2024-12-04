package com.example.playlist;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

public class AdaptadorMusica extends RecyclerView.Adapter<AdaptadorMusica.ViewHolder>{

    List<Musica> dataset;
    MediaPlayer reproductor;
    Context context;
    Runnable handlertask = null;

    public AdaptadorMusica(List<Musica> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public AdaptadorMusica.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.cancion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorMusica.ViewHolder holder, int position) {
        holder.imagencancion.setImageResource(dataset.get(position).getImagen());

        holder.titulo.setText(dataset.get(position).getTitulo());
        holder.autor.setText(dataset.get(position).getAutor());

        holder.btnplay.setOnClickListener(v -> play(holder, dataset.get(position)));
        holder.btnpause.setOnClickListener(v -> pausa(holder));
        holder.btnstop.setOnClickListener(v -> parar(holder));

        holder.barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(reproductor != null && b){
                    reproductor.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView btnplay, btnpause, btnstop, imagencancion;
        TextView titulo, autor;
        SeekBar barra;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagencancion = itemView.findViewById(R.id.imagencancion);
            titulo = itemView.findViewById(R.id.titulo);
            autor = itemView.findViewById(R.id.autor);
            barra = itemView.findViewById(R.id.barra);
            btnplay = itemView.findViewById(R.id.btnplay);
            btnpause = itemView.findViewById(R.id.btnpause);
            btnstop = itemView.findViewById(R.id.btnstop);

            if(reproductor != null){
                handlertask = null;
                barra.setProgress(reproductor.getCurrentPosition());
                barra.setMax(reproductor.getDuration());
                empezarTiempo(barra);
            }
        }
    }

    private void play(@NonNull   ViewHolder v, Musica musica){
        if(reproductor != null){
            reproductor.stop();
        }
        reproductor = MediaPlayer.create(context, musica.getAudio());
        reproductor.start();
        v.barra.setMax(reproductor.getDuration());
        v.barra.setProgress(0);
        empezarTiempo(v.barra);
    }

    private void pausa(@NonNull ViewHolder v){
        if(reproductor.isPlaying()){
            reproductor.pause();
            handlertask = null;
        }else{
            reproductor.start();
            v.barra.setMax(reproductor.getDuration());
            v.barra.setProgress(reproductor.getCurrentPosition());
            empezarTiempo(v.barra);
        }
    }

    private void parar(@NonNull ViewHolder v){
        try{
            reproductor.stop();
            reproductor.prepare();
            reproductor.seekTo(0);
            v.barra.setProgress(0);
            handlertask = null;
        } catch (IOException e)  {
        }
    }

    private void empezarTiempo(SeekBar barra){
        if(handlertask == null){
            handlertask = () -> {
                barra.setProgress(reproductor.getCurrentPosition());
                new Handler().postDelayed(handlertask, 1000);
            };
            handlertask.run();
        }
    }
}
