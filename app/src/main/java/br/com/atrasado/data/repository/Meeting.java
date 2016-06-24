package br.com.atrasado.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.atrasado.data.network.api.PersonApi;
import br.com.atrasado.data.network.api.TeamApi;
import br.com.atrasado.domain.entities.Person;
import br.com.atrasado.domain.entities.Team;
import rx.Observable;

public class Meeting {

    @Singleton
    private PersonApi personApi;

    @Singleton
    private TeamApi teamApi;

    @Inject
    public Meeting() {
        personApi = new PersonApi();
        teamApi = new TeamApi();
    }

    public Observable<Person> donate(Long id) { return personApi.donate(id); }

    public Observable<Person> join(final Person person) {
        return personApi.login(person);
    }

    public Observable<List<Person>> list() {
        return personApi.list();
    }

    public Observable<Person> find(final long id) {
        return personApi.find(id);
    }

    public Observable<List<Team>> allTeams() { return teamApi.list(); }

    public Observable<Team> findTeam(Long id) { return teamApi.find(id); }
}