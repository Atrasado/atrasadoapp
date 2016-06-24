package br.com.atrasado.presentations.views.activities;

import android.app.Activity;
import android.os.Bundle;

import br.com.atrasado.atrasado.R;
import butterknife.Bind;

public class SignUpActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
}
