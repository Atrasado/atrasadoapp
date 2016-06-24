package br.com.atrasado.data.network.api;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.atrasado.data.internal.AtrasadosPreferences;
import br.com.atrasado.data.network.api.service.PeopleService;
import br.com.atrasado.domain.entities.People;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;

import static android.R.attr.id;

public class PeopleApi extends RestApi {

    @Singleton
    private PeopleService peopleService;

    @Inject
    public PeopleApi() {
        peopleService = retrofit().create(PeopleService.class);
    }


    public Observable<People> login(final People people) {
        return Observable.create(subscriber -> {

            Call<People> authorizationCall = peopleService.join(people);

            authorizationCall.enqueue(new Callback<People>() {
                @Override
                public void onResponse(Call<People> call, Response<People> response) {
                    if (response.isSuccess()) {
                        subscriber.onNext(response.body());
                        AtrasadosPreferences.getInstance().saveMe(response.body());
                        subscriber.onCompleted();
                    } else
                        subscriber.onError(null);
                }

                @Override
                public void onFailure(Call<People> call, Throwable t) {
                    subscriber.onError(t);
                }
            });
        });
    }

    public Observable<List<People>> list() {
        return Observable.create(subscriber -> {

            Call<List<People>> authorizationCall = peopleService.list();

            authorizationCall.enqueue(new Callback<List<People>>() {
                @Override
                public void onResponse(Call<List<People>> call, Response<List<People>> response) {
                    if (response.isSuccess()) {
                        subscriber.onNext(response.body());
                        subscriber.onCompleted();
                    } else
                        subscriber.onError(null);
                }

                @Override
                public void onFailure(Call<List<People>> call, Throwable t) {
                    subscriber.onError(t);
                }
            });
        });
    }

    public Observable<People> find(final long id) {
        return Observable.create(subscriber -> {

            Call<People> authorizationCall = peopleService.find(id);

            authorizationCall.enqueue(new Callback<People>() {
                @Override
                public void onResponse(Call<People> call, Response<People> response) {
                    if (response.isSuccess()) {
                        subscriber.onNext(response.body());
                        subscriber.onCompleted();
                    } else
                        subscriber.onError(null);
                }

                @Override
                public void onFailure(Call<People> call, Throwable t) {
                    subscriber.onError(t);
                }
            });
        });
    }
}
