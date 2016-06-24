package br.com.atrasado.data.network;

import android.app.Activity;
import android.content.Intent;

public class Actions {

    public static void to(final Activity activity, final Class clazz, boolean finish) {
        Intent intent = new Intent(activity, clazz);
        activity.startActivity(intent);
        if (finish)
            activity.finish();
    }
}