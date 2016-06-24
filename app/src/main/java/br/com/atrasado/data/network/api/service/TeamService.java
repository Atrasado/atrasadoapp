package br.com.atrasado.data.network.api.service;

import java.util.List;

import br.com.atrasado.domain.entities.Person;
import br.com.atrasado.domain.entities.Team;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TeamService {

    String BASE_URL = "teams";

    @GET(BASE_URL + ".json")
    Call<List<Team>> list();
    @GET(BASE_URL + "/{id}.json")
    Call<Team> find(@Path("id") long id);
}
