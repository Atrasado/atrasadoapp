package br.com.atrasado.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.atrasado.data.network.api.PersonApi;
import br.com.atrasado.domain.entities.Person;
import rx.Observable;

public class Meeting {

    @Singleton
    private PersonApi personApi;

    @Inject
    public Meeting() {
        personApi = new PersonApi();
    }

    public Observable<Person> join(final Person person) {
        return personApi.login(person);
    }

    public Observable<List<Person>> list() {
        return personApi.list();
    }

    public Observable<Person> find(final long id) {
        return personApi.find(id);
    }

}