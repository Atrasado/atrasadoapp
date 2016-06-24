package br.com.atrasado.presentations.views.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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


    protected void errorDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Ops ....")
                .setMessage("Poxa deu ruim .....")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}