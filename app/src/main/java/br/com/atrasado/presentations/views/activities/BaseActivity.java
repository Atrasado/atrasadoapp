package br.com.atrasado.presentations.views.activities;

import android.app.Activity;
import android.os.Bundle;

import br.com.atrasado.presentations.application.AndroidApplication;
import br.com.atrasado.presentations.application.ApplicationComponent;

public class BaseActivity extends Activity {

    protected ApplicationComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupDataAccess();
    }


    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    private void setupDataAccess() {
        mComponent = getApplicationComponent();
    }
}