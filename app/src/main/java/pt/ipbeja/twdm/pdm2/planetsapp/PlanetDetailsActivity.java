package pt.ipbeja.twdm.pdm2.planetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetDetailsActivity extends AppCompatActivity {

    TextView planetName;
    TextView planetDescription;
    ImageView planetImage;

    private static String KEY_ID = "id";
    private int id;

    public static void startActivity(Context context, int id){
        Intent intent = new Intent(context, PlanetDetailsActivity.class);
        intent.putExtra(KEY_ID, id);
        context.startActivity(intent);
    }

    private void cacheViews(){
        this.planetName = findViewById(R.id.textViewDetailsPlanetName);
        this.planetDescription = findViewById(R.id.textViewDetailsPlanetDescription);
        this.planetImage = findViewById(R.id.imageViewDetailsPlanetImage);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_details);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            this.id = extras.getInt(KEY_ID);
        } else {
            this.id = (int) savedInstanceState.getSerializable(KEY_ID);
        }

        cacheViews();

        Call<Planet> call = DataSource.getPlanetDetails(this.id);

        call.enqueue(new Callback<Planet>() {
            @Override
            public void onResponse(Call<Planet> call, Response<Planet> response) {
                if(response.isSuccessful()){
                    Planet planet = response.body();
                    planetName.setText(planet.getName());
                    planetDescription.setText(planet.getDescription());
                    Glide.with(planetImage.getRootView()).load(planet.getImgURL()).into(planetImage);
                }else {
                    System.out.println("test");
                }
            }

            @Override
            public void onFailure(Call<Planet> call, Throwable t) {
                t.getStackTrace();
            }
        });
    }
}