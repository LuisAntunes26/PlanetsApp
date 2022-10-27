package pt.ipbeja.twdm.pdm2.planetsapp;



import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSource {

    private static String BASE_URL = "https://my-json-server.typicode.com/carlossancho-pt/";

    public static Call<List<Planet>> getPlanetsCall(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);
        return jsonPlaceHolderAPI.getAllPlanets();
    }

    public static Call<Planet> getPlanetDetails(int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);
        return jsonPlaceHolderAPI.getPlanetDetails(id);
    }
}
