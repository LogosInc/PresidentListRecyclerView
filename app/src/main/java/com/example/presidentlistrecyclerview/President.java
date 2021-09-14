package com.example.presidentlistrecyclerview;

import java.util.Comparator;

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

    public static Comparator<President> PresidentAZComparator = new Comparator<President>() {
        @Override
        public int compare(President p1, President p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };

    public static Comparator<President> PresidentZAComparator = new Comparator<President>() {
        @Override
        public int compare(President p1, President p2) {
            return p2.getName().compareTo(p1.getName());
        }
    };

    public static Comparator<President> PresidentDateAscComparator = new Comparator<President>() {
        @Override
        public int compare(President p1, President p2) {
            return p1.getDateOfElection() - p2.getDateOfElection();
        }
    };

    public static Comparator<President> PresidentDateDesComparator = new Comparator<President>() {
        @Override
        public int compare(President p1, President p2) {
            return p2.getDateOfElection() - p1.getDateOfElection();
        }
    };

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
