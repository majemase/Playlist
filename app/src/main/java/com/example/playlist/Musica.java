package com.example.playlist;

public class Musica {
    int id;
    String titulo;
    String autor;
    int imagen;
    int audio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Musica(int id, String titulo, String autor, int imagen, int audio) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.imagen = imagen;
        this.audio = audio;
    }
}
