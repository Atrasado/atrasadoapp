package br.com.atrasado.presentations.views.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import br.com.atrasado.atrasado.R;
import br.com.atrasado.domain.entities.Person;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SignUpActivity extends Activity {


    @Bind(R.id.signupName) EditText edtSignUpName;
    @Bind(R.id.signupBirthdate) EditText edtBirthdate;
    @Bind(R.id.signupCpf) EditText edtCpf;
    @Bind(R.id.signupCreditCard) EditText edtCreditCard;
    @Bind(R.id.signupExpiration) EditText edtExpiration;
    @Bind(R.id.signupEmail) EditText edtEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        Person person = buildPerson();
    }

    private Person buildPerson() {
        Person person = new Person();
        person.setFullName(edtSignUpName.getText().toString());
        person.setDocument(edtCpf.getText().toString());
        person.setEmail(edtEmail.getText().toString());

        return  person;
    }
}
