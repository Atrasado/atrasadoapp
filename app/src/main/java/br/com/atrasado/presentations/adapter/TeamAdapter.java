package br.com.atrasado.presentations.adapter;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.atrasado.R;
import br.com.atrasado.data.network.Actions;
import br.com.atrasado.domain.entities.Team;
import br.com.atrasado.presentations.views.activities.SplashScreenActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

public class TeamAdapter extends RecyclerListAdapter<Team, TeamAdapter.TeamHolder> {

    private Activity mActivity;

    public TeamAdapter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public TeamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.content_team, parent, false);
        return new TeamAdapter.TeamHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TeamHolder holder, int position) {
        Team team = getItem(position);

        holder.txtTeamName.setText(team.getName());
        holder.itemView.setOnClickListener(v -> {
            Actions.to(mActivity, SplashScreenActivity.class, true);
        });
    }


    public class TeamHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.name)
        TextView txtTeamName;

        public TeamHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
