package com.promineo.ryanleyva1;

public class Album {

    private int albumId;
    private String name;
    private String artist;

    public Album(int albumId, String name, String artist) {
        this.albumId = albumId;
        this.name = name;
        this.artist = artist;
    }

    public int getAlbumId() {
        return albumId;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
