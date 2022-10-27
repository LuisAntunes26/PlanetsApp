package pt.ipbeja.twdm.pdm2.planetsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PerformanceHintManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    PlanetListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewPlanets);
        adapter = new PlanetListAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        Call<List<Planet>> call = DataSource.getPlanetsCall();

        call.enqueue(new Callback<List<Planet>>() {
            @Override
            public void onResponse(Call<List<Planet>> call, Response<List<Planet>> response) {
                if(response.isSuccessful()){
                    List<Planet> planetList = response.body();
                    adapter.updateData(planetList);
                }
            }

            @Override
            public void onFailure(Call<List<Planet>> call, Throwable t) {
                t.getStackTrace();
            }
        });
    }
}