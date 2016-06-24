package br.com.atrasado.data.network.api;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.atrasado.data.network.api.service.TeamService;
import br.com.atrasado.domain.entities.Team;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

public class TeamApi extends RestApi {

    @Singleton
    private TeamService teamService;

    @Inject
    public TeamApi() { teamService = retrofit().create(TeamService.class); }

    public Observable<List<Team>> list() {

        return Observable.create(subscriber -> {
           Call<List<Team>> teamCall =  teamService.list();
           teamCall.enqueue(new Callback<List<Team>>() {
               @Override
               public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                    if (response.isSuccess()) {
                        subscriber.onNext(response.body());
                        subscriber.onCompleted();
                    } else {
                        subscriber.onError(null);
                    }
               }

               @Override
               public void onFailure(Call<List<Team>> call, Throwable t) {
                   subscriber.onError(t);
               }
           });

        });

    }

    public Observable<Team> find(Long id) {

        return Observable.create(subscriber -> {
            Call<Team> teamCall =  teamService.find(id);
            teamCall.enqueue(new Callback<Team>() {
                @Override
                public void onResponse(Call<Team> call, Response<Team> response) {
                    if (response.isSuccess()) {
                        subscriber.onNext(response.body());
                        subscriber.onCompleted();
                    } else {
                        subscriber.onError(null);
                    }
                }

                @Override
                public void onFailure(Call<Team> call, Throwable t) {
                    subscriber.onError(t);
                }
            });

        });

    }
}
