package br.com.atrasado.data.network.api.service;

import java.util.List;

import br.com.atrasado.domain.entities.Person;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PersonService {
    String BASE_URL = "people";

    @POST(BASE_URL + ".json")
    Call<Person> join(@Body Person person);

    @GET(BASE_URL + ".json")
    Call<List<Person>> list();

    @GET(BASE_URL + "/{id}")
    Call<Person> find(@Path("id") long id);

    @GET(BASE_URL + "/{id}/donate.json")
    Call<Person> donate(@Path("id") long id);

}
