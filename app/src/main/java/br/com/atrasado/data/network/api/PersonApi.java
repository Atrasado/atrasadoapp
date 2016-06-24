package br.com.atrasado.data.network.api;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.atrasado.data.internal.AtrasadosPreferences;
import br.com.atrasado.data.network.api.service.PersonService;
import br.com.atrasado.domain.entities.Person;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;

public class PersonApi extends RestApi {

    @Singleton
    private PersonService personService;

    @Inject
    public PersonApi() {
        personService = retrofit().create(PersonService.class);
    }


    public Observable<Person> login(final Person person) {
        return Observable.create(subscriber -> {

            Call<Person> authorizationCall = personService.join(person);

            authorizationCall.enqueue(new Callback<Person>() {
                @Override
                public void onResponse(Call<Person> call, Response<Person> response) {
                    if (response.isSuccess()) {
                        subscriber.onNext(response.body());
                        AtrasadosPreferences.getInstance().saveMe(response.body());
                        subscriber.onCompleted();
                    } else
                        subscriber.onError(null);
                }

                @Override
                public void onFailure(Call<Person> call, Throwable t) {
                    subscriber.onError(t);
                }
            });
        });
    }

    public Observable<List<Person>> list() {
        return Observable.create(subscriber -> {

            Call<List<Person>> authorizationCall = personService.list();

            authorizationCall.enqueue(new Callback<List<Person>>() {
                @Override
                public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                    if (response.isSuccess()) {
                        subscriber.onNext(response.body());
                        subscriber.onCompleted();
                    } else
                        subscriber.onError(null);
                }

                @Override
                public void onFailure(Call<List<Person>> call, Throwable t) {
                    subscriber.onError(t);
                }
            });
        });
    }

    public Observable<Person> find(final long id) {
        return Observable.create(subscriber -> {

            Call<Person> authorizationCall = personService.find(id);

            authorizationCall.enqueue(new Callback<Person>() {
                @Override
                public void onResponse(Call<Person> call, Response<Person> response) {
                    if (response.isSuccess()) {
                        subscriber.onNext(response.body());
                        subscriber.onCompleted();
                    } else
                        subscriber.onError(null);
                }

                @Override
                public void onFailure(Call<Person> call, Throwable t) {
                    subscriber.onError(t);
                }
            });
        });
    }

    public Observable<Person> donate(final long id) {
        return Observable.create(subscriber -> {

            Call<Person> authorizationCall = personService.donate(id);

            authorizationCall.enqueue(new Callback<Person>() {
                @Override
                public void onResponse(Call<Person> call, Response<Person> response) {
                    if (response.isSuccess()) {
                        subscriber.onNext(response.body());
                        subscriber.onCompleted();
                    } else
                        subscriber.onError(null);
                }

                @Override
                public void onFailure(Call<Person> call, Throwable t) {
                    subscriber.onError(t);
                }
            });
        });
    }
}
