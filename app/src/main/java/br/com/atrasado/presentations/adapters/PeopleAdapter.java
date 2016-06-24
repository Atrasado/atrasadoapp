package br.com.atrasado.presentations.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.atrasado.R;
import br.com.atrasado.domain.entities.Person;
import butterknife.Bind;
import butterknife.ButterKnife;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {
    private List<Person> people;
    private Context context;

    public PeopleAdapter(Context context, ArrayList<Person> people) {
        this.people = people;
        this.context = context;
    }

    @Override
    public PeopleAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_person, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PeopleAdapter.ViewHolder viewHolder, int i) {
        viewHolder.txtFullName.setText(people.get(i).getFullName());
        Picasso.with(context).load(people.get(i).getEmail()).into(viewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.name)
        TextView txtFullName;
        @Bind(R.id.image)
        ImageView imgPhoto;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}