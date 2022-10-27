package pt.ipbeja.twdm.pdm2.planetsapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderAPI {

    @GET("planets/planets")
    Call<List<Planet>> getAllPlanets();

    @GET("planets/planetDetails/{planetID}")
    Call<Planet> getPlanetDetails(@Path("planetID") int planetID);
}
