package com.javapointers.model;

import javax.persistence.*;

@Entity
@Table(name = "cd")
public class CD{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer CD_ID;
    @Column
    private  String Album;
    @Column
    private String Genre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Artist_ID")
    private  Artist artist;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Organization_ID")
    private  Organization organization;

    public CD(String album, String genre, Artist artist, Organization organization) {
        Album = album;
        Genre = genre;
        this.artist = artist;
        this.organization = organization;
    }
    public CD(){
    }
    public String getGenre() {
        return Genre;
    }
    public void setGenre(String genre) {
        Genre = genre;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    public Artist getArtist() {
        return artist;
    }
    public Organization getOrganization() {
        return organization;
    }
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    public Integer getCD_ID() {
        return CD_ID;
    }
    public void setCD_ID(Integer CD_ID) {
        this.CD_ID = CD_ID;
    }
    public String getAlbum() {
        return Album;
    }
    public void setAlbum(String album) {
        Album = album;
    }
    public String getGanre() {
        return Genre;
    }
    public void setGanre(String ganre) {
        Genre = ganre;
    }
    @Override
    public String toString() {
        return "Cd{" +
                "---->CD_ID=" + CD_ID +
                ", ------>Album='" + Album + '\'' +
                ", ------>Ganre='" + Genre + '\'' +
                ", ------>Artist_ID=" + artist.getArtist_ID() +
                ", ------>Organization_id=" + organization.getOrganization_id() +
                '}';
    }

}
