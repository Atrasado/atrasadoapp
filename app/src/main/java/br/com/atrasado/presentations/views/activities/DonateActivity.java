package br.com.atrasado.presentations.views.activities;

import android.os.Bundle;
import android.widget.Button;

import br.com.atrasado.R;
import br.com.atrasado.data.internal.AtrasadosPreferences;
import br.com.atrasado.data.network.Action;
import br.com.atrasado.data.repository.Meeting;
import br.com.atrasado.domain.entities.Person;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscriber;

public class DonateActivity extends BaseActivity {

    @Bind(R.id.donate)
    Button btnDonate;
    @Bind(R.id.nope)
    Button btnNope;

    private Meeting mMeeting;
    private Subscriber<Person> mDonateSubscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        ButterKnife.bind(this);
        mMeeting = getApplicationComponent().provideMeeting();


        mDonateSubscriber = new Subscriber<Person>() {
            @Override
            public void onCompleted() {
                success();
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

    @OnClick(R.id.nope)
    public void nope() {
        finish();
    }

    @OnClick(R.id.donate)
    public void donate() {
        mMeeting.donate(AtrasadosPreferences.getInstance().me().getId()).subscribe(mDonateSubscriber);
    }


    private void success() {
        Action.to(this, SuccessActivity.class, true);
    }

}
