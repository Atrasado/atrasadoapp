package br.com.atrasado.data.network.api;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.atrasado.data.internal.AtrasadosPreferences;
import br.com.atrasado.data.network.api.service.PeopleService;
import br.com.atrasado.domain.entities.People;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;

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

}
