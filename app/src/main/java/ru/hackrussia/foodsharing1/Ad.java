package ru.hackrussia.foodsharing1;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Ad extends RealmObject{
    @PrimaryKey
    private String id;
    private String title;
    private String description;
    private long created;

    public Ad() {

    }

    public Ad(String id, String title, String description, long created) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created = created;
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


    public String getLastMessage() {
        return description;
    }

    public void setLastMessage(String lastMessage) {
        this.description = lastMessage;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }


}
