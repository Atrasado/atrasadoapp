package br.com.atrasado.presentations.views.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.atrasado.presentations.application.AndroidApplication;
import br.com.atrasado.presentations.application.ApplicationComponent;

public class BaseActivity extends AppCompatActivity {

    protected ApplicationComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
        setupDataAccess();
    }


    private ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    private void setupDataAccess() {
        mComponent = getApplicationComponent();
    }
}