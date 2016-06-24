package br.com.atrasado.data.network.api.service;

import java.util.List;

import br.com.atrasado.domain.entities.People;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PeopleService {
    String BASE_URL = "people/";

    @POST(BASE_URL)
    Call<People> join(@Body People people);
    @GET(BASE_URL)
    Call<List<People>> list();
    @GET(BASE_URL + "{people}")
    Call<List<People>> get(@Path("people") long people);
}
