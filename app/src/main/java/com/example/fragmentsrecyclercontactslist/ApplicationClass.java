package com.example.fragmentsrecyclercontactslist;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Person> people = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        people.add(new Person("Christian Gioia", "0438 186 636"));
        people.add(new Person("Shinji Ikari", "54323132 313"));
        people.add(new Person("Random #3", "231393128302"));
        people.add(new Person("Yahztee", "99999999999"));

    }
}
