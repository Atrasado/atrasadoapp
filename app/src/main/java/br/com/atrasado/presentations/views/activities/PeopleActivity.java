package br.com.atrasado.presentations.views.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import br.com.atrasado.R;
import br.com.atrasado.domain.entities.Person;
import br.com.atrasado.presentations.adapters.PeopleAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

public class PeopleActivity extends Activity {

    @Bind(R.id.gridview)
    RecyclerView mGridPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        ButterKnife.bind(this);

        mGridPeople.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        mGridPeople.setLayoutManager(layoutManager);

        ArrayList<Person> people = prepareData();
        PeopleAdapter adapter = new PeopleAdapter(getApplicationContext(), people);
        mGridPeople.setAdapter(adapter);
    }

    private ArrayList<Person> prepareData() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(dummy("eldender@gmail.com"));
        persons.add(dummy("breno26@gmail.com"));
        persons.add(dummy("xcxcx@gmail.com"));
        persons.add(dummy("asdasd@gmail.com"));
        persons.add(dummy("brenxzcxzco26@gmail.com"));
        persons.add(dummy("cvcvc@gmail.com"));
        persons.add(dummy("eldender@gmail.com"));
        persons.add(dummy("breno26@gmail.com"));
        persons.add(dummy("xcxcx@gmail.com"));
        persons.add(dummy("asdasd@gmail.com"));
        persons.add(dummy("brenxzcxzco26@gmail.com"));
        persons.add(dummy("cvcvc@gmail.com"));

        return persons;
    }


    private Person dummy(final String email) {
        Person person = new Person();
        person.setEmail(email);
        person.setFullName(email);
        return person;
    }
}
