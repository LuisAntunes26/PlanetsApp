package pt.ipbeja.twdm.pdm2.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class PlanetListAdapter extends RecyclerView.Adapter<PlanetListAdapter.ViewHolder> {

    private List<Planet> planetList = new ArrayList<>();

    public PlanetListAdapter() {
    }

    @NonNull
    @Override
    public PlanetListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_planet_list, parent, false);
        return new ViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetListAdapter.ViewHolder holder, int position) {
        Planet planet = planetList.get(position);
        holder.setName(planet.getName());
        holder.setImage(planet.getImgURL());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlanetDetailsActivity.startActivity(view.getContext(), planet.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.planetList.size();
    }

    public void updateData(List<Planet> planetList){
        this.planetList = planetList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView planetName;
        private ImageView planetImage;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            this.planetName = itemView.findViewById(R.id.textViewCardPlanetName);
            this.planetImage = itemView.findViewById(R.id.imageViewCardPlanetImage);
        }

        public void setName(String name){
            this.planetName.setText(name);
        }

        public void setImage(String url){
            Glide.with(view).load(url).into(planetImage);
        }
    }

    public interface PlanetListEventListener{

    }
}
