package br.com.atrasado.presentations.views.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

import br.com.atrasado.R;
import br.com.atrasado.data.repository.Meeting;
import br.com.atrasado.domain.entities.Person;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

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

    private Subscriber<Person> mPersonSubscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        mPersonSubscriber = new Subscriber<Person>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                errorDialog();
            }

            @Override
            public void onNext(Person person) {

            }
        };
    }

    @OnClick(R.id.bt_signup)
    public void signup() {
        Person person = buildPerson();
        mMeeting = getApplicationComponent().provideMeeting();
        mMeeting.join(buildPerson()).subscribe(mPersonSubscriber);

    }



    private Person buildPerson() {
        Person person = new Person();
        person.setFullname(edtSignUpName.getText().toString());
        person.setDocument(edtCpf.getText().toString());
        person.setEmail(edtEmail.getText().toString());

        String expirationRaw = edtExpiration.getText().toString();
        String[] expiration = expirationRaw.split("/");

        person.setExpirationMonth(expiration[0]);
        person.setExpirationYear(expiration[1]);
        person.setCreditCardNumber(edtCreditCard.getText().toString());

        return person;
    }
}
