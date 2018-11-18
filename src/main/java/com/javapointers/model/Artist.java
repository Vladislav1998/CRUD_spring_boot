package com.javapointers.model;

import javax.persistence.*;
import java.util.Set;
@Entity(name = "Artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer Artist_ID;
    @Column
    private  String  Name;
    @Column
    private  int Number_of_albums;
    public Artist(String name, int number_of_albums) {
        Name = name;
        Number_of_albums = number_of_albums;
    }
    public Artist() {
    }
    public void setArtist_ID(Integer artist_ID) {
        Artist_ID = artist_ID;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setNumber_of_albums(int number_of_albums) {
        Number_of_albums = number_of_albums;
    }
    public Integer getArtist_ID() {
        return Artist_ID;
    }
    public String getName() {
        return Name;
    }
    public int getNumber_of_albums() {
        return Number_of_albums;
    }
    @Override
    public String toString() {
        return  "Artist{" +
                "Artist_ID=" + Artist_ID +
                ", Name='" + Name + '\'' +"      "+
                ", Number_of_albums=" + Number_of_albums +
                '}';
    }
}
