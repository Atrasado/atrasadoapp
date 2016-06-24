package br.com.atrasado.data.repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import br.com.atrasado.data.network.api.PeopleApi;

public class Meeting {

    @Singleton
    private PeopleApi peopleApi;

    @Inject
    public Meeting() {
        peopleApi = new PeopleApi();
    }
}