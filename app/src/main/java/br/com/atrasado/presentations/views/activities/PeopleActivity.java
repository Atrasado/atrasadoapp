package br.com.atrasado.presentations.views.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.com.atrasado.R;
import br.com.atrasado.data.repository.Meeting;
import br.com.atrasado.domain.entities.Person;
import br.com.atrasado.presentations.adapters.PeopleAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

public class PeopleActivity extends BaseActivity {

    @Bind(R.id.gridview)
    RecyclerView mGridPeople;

    private Meeting mMeeting;
    private Subscriber<List<Person>> peopleSubscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        ButterKnife.bind(this);

        mGridPeople.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        mGridPeople.setLayoutManager(layoutManager);


        peopleSubscriber = new Subscriber<List<Person>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Person> people) {
                updateList(people);
            }
        };

//        mMeeting = getApplicationComponent().provideMeeting();
//        mMeeting.(AtrasadosPreferences.getInstance().myTeam()).subscribe(peopleSubscriber);
    }

    private void updateList(List<Person> people) {
        PeopleAdapter adapter = new PeopleAdapter(getApplicationContext(), people);
        mGridPeople.setAdapter(adapter);
    }

}
