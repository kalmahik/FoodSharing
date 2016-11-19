package ru.hackrussia.foodsharing1;

public class Category  {
    private String title;
    private String image;

    public Category()  {

    }

    public Category(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
