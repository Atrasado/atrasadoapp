package br.com.atrasado.data.internal;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.Map;

import br.com.atrasado.domain.entities.Person;

public class AtrasadosPreferences {

    private Context instance;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    private static final String APP = "atrasados";
    private static final String PERSON = "person";
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

    public boolean isLogged() {
        return prefs.contains(PERSON);
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

    public boolean saveMe(final Person person) {
        saveOldPreferences();
        editor.putString(PERSON, new Gson().toJson(person));
        return editor.commit();
    }

    public Person me() {
        return new Gson().fromJson(prefs.getString(PERSON, null), Person.class);
    }

    public boolean shouldSkipWelcome() {
        return prefs.contains(WELCOME);
    }

    public void clear() {
        editor.clear();
        editor.commit();
    }
}