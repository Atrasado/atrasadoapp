package br.com.atrasado.presentations.views.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import br.com.atrasado.R;
import br.com.atrasado.data.repository.Meeting;
import br.com.atrasado.domain.entities.Team;
import br.com.atrasado.presentations.adapter.TeamAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

public class JoinTeam extends BaseActivity {

    @Bind(R.id.teams)
    RecyclerView rclTeams;
    private RecyclerView.LayoutManager mLayoutManager;

    private Meeting mMeeting;
    private Subscriber<List<Team>> mTeamSubscriber;
    private TeamAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_team);

        ButterKnife.bind(this);

        rclTeams.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        rclTeams.setLayoutManager(mLayoutManager);

        teamAdapter = new TeamAdapter(this);
        mMeeting = getApplicationComponent().provideMeeting();

        rclTeams.setAdapter(teamAdapter);

        mTeamSubscriber = new Subscriber<List<Team>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("Error", e.toString());
                errorDialog();
            }

            @Override
            public void onNext(List<Team> teams) {
                Log.i("onNext", teams.toString());
                teamAdapter.addAll(teams);
                rclTeams.getAdapter().notifyDataSetChanged();
            }
        };

        mMeeting.allTeams().subscribe(mTeamSubscriber);
    }
}
