package com.android.goeasy;

public class MainModel {
    String bookName,authorName,url;

    MainModel()
    {

    }

    public MainModel(String bookName, String authorName, String url) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.url = url;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
