package br.com.atrasado.data.internal;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.Map;

import br.com.atrasado.domain.entities.People;

public class AtrasadosPreferences {

    private Context instance;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    private static final String APP = "atrasados";
    private static final String PEOPLE = "people";
    private static final String WELCOME = "welcome";

    private static AtrasadosPreferences atrasadosPreferences;

    public AtrasadosPreferences(final Context context) {
        instance = context;

        prefs = instance.getSharedPreferences(APP, instance.MODE_PRIVATE);
        editor = instance.getSharedPreferences(APP, instance.MODE_PRIVATE).edit();
    }


    public static AtrasadosPreferences setInstance(final Context context) {
        if (atrasadosPreferences == null)
            atrasadosPreferences = new AtrasadosPreferences(context);
        return atrasadosPreferences;
    }

    public static AtrasadosPreferences getInstance() {
        return atrasadosPreferences;
    }

    public void saveOldPreferences() {
        Map<String, ?> allEntries = prefs.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            editor.putString(entry.getKey(), prefs.getString(entry.getKey(), null));
        }
    }

    public boolean setWelcomeAs(final boolean seen) {
        saveOldPreferences();
        editor.putBoolean(WELCOME, seen);
        return editor.commit();
    }

    public boolean saveMe(final People people) {
        saveOldPreferences();
        editor.putString(PEOPLE, new Gson().toJson(people));
        return editor.commit();
    }

    public People me(){
        return new Gson().fromJson(prefs.getString(PEOPLE, null),People.class);
    }

    public boolean shouldSkipWelcome() {
        return prefs.contains(WELCOME);
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }
}