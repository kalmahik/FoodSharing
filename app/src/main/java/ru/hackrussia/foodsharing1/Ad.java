package ru.hackrussia.foodsharing1;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Ad extends RealmObject{
    @PrimaryKey
    private String id;
    private String title;
    private String cat_id;
    private String desc;
    private String date;
    private String img;

    public Ad() {

    }

    public Ad(String title, String id, String desc, String cat_id, String date, String img) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.date = date;
        this.cat_id = cat_id;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
