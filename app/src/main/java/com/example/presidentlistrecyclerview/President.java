package com.example.presidentlistrecyclerview;

public class President {

    private String name;
    private int dateOfElection;
    private String imageURL;

    private int id;

    public President(int id, String name, int dateOfElection, String imageURL) {
        this.id = id;
        this.name = name;
        this.dateOfElection = dateOfElection;
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "President{" +
                "name='" + name + '\'' +
                ", dateOfElection=" + dateOfElection +
                ", imageURL='" + imageURL + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDateOfElection() {
        return dateOfElection;
    }

    public void setDateOfElection(int dateOfElection) {
        this.dateOfElection = dateOfElection;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
