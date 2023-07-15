package com.android.goeasy;

public class Book {
    private String title;
    private String author;
    private int image;
    private String link;


    public Book( String title,String author,int image,String link) {
        this.title = title;
        this.author=author;
        this.image = image;
        this.link=link;
    }

    public String getTitle() {return title;}

    public String getAuthor() {
        return author;
    }

    public int getImage() {return image;}
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
}
