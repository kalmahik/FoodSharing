package ru.hackrussia.foodsharing1;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmConfiguration;
import io.realm.Sort;

public class AdDatabase {
    private Realm realm;

    public AdDatabase() {
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("ad_db")
                .build();
        realm = Realm.getInstance(configuration);
    }

    public void copyOrUpdate(Ad ad) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(ad);
        realm.commitTransaction();
    }

    public void copyOrUpdate(List<Ad> ads) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(ads);
        realm.commitTransaction();
    }

    public void clean() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }

    public List<Ad> getAll() {
        return realm.where(Ad.class).findAll();
    }

    public void close() {
        if (!realm.isClosed()) {
            realm.close();
        }
    }

    public void addChangeListener(RealmChangeListener<Realm> changeListener) {
        realm.addChangeListener(changeListener);
    }
}
