package com.example.playlist;

public class Musica {
    String titulo;
    String autor;
    int imagen;
    int audio;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public Musica(String titulo, String autor, int imagen, int audio) {
        this.titulo = titulo;
        this.autor = autor;
        this.imagen = imagen;
        this.audio = audio;
    }
}
