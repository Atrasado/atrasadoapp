package br.com.atrasado.presentations.views.activities;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.com.atrasado.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class PeopleActivity extends BaseActivity {

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

//        ArrayList<Person> people = prepareData();
//        PeopleAdapter adapter = new PeopleAdapter(getApplicationContext(), people);
//        mGridPeople.setAdapter(adapter);
    }

}
