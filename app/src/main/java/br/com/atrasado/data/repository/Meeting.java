package br.com.atrasado.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.atrasado.data.network.api.PeopleApi;
import br.com.atrasado.domain.entities.People;
import rx.Observable;

public class Meeting {

    @Singleton
    private PeopleApi peopleApi;

    @Inject
    public Meeting() {
        peopleApi = new PeopleApi();
    }

    public Observable<People> join(final People people) {
        return peopleApi.login(people);
    }

    public Observable<List<People>> list() {
        return peopleApi.list();
    }

    public Observable<People> find(final long id) {
        return peopleApi.find(id);
    }

}