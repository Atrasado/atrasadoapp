package br.com.atrasado.presentations.views.activities;

import android.os.Bundle;
import android.widget.EditText;

import br.com.atrasado.R;
import br.com.atrasado.data.repository.Meeting;
import br.com.atrasado.domain.entities.Person;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SignUpActivity extends BaseActivity {


    @Bind(R.id.signupName)
    EditText edtSignUpName;
    @Bind(R.id.signupBirthdate)
    EditText edtBirthdate;
    @Bind(R.id.signupCpf)
    EditText edtCpf;
    @Bind(R.id.signupCreditCard)
    EditText edtCreditCard;
    @Bind(R.id.signupExpiration)
    EditText edtExpiration;
    @Bind(R.id.signupEmail)
    EditText edtEmail;

    private Meeting mMeeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        Person person = buildPerson();

        mMeeting = getApplicationComponent().provideMeeting();
    }

    private Person buildPerson() {
        Person person = new Person();
        person.setFullName(edtSignUpName.getText().toString());
        person.setDocument(edtCpf.getText().toString());
        person.setEmail(edtEmail.getText().toString());

        return person;
    }
}
