package br.com.atrasado.data.network.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import br.com.atrasado.data.network.api.parser.DateTimeTypeAdapter;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApi {
    public static final String API_DATETIME = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    final String BASE_URL = "http://atrasado.herokuapp.com/";

    private final OkHttpClient mClient = new OkHttpClient.Builder().
            readTimeout(30, TimeUnit.SECONDS).
            connectTimeout(30, TimeUnit.SECONDS).
            build();


    public Retrofit retrofit() {
        final Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(java.util.Date.class, new DateTimeTypeAdapter())
                .setDateFormat(API_DATETIME).create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(mClient)
                .build();
    }

}
