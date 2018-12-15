package com.example.shashu.jsonpractice;

public class Trailer_Characters {
    private String trailer_name;
    private int trailer_thumbnail;

    public Trailer_Characters() {

    }

    public Trailer_Characters(String character_name, int trailer_thumbnail) {
        this.trailer_name = character_name;
        this.trailer_thumbnail = trailer_thumbnail;
    }

    public String getTrailer_name() {
        return trailer_name;
    }

    public void setTrailer_name(String trailer_name) {
        this.trailer_name = trailer_name;
    }

    public int getTrailer_thumbnail() {
        return trailer_thumbnail;
    }

    public void setTrailer_thumbnail(int trailer_thumbnail) {
        this.trailer_thumbnail = trailer_thumbnail;
    }
}
