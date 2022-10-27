package pt.ipbeja.twdm.pdm2.planetsapp;

import com.google.gson.annotations.SerializedName;

public class Planet {

    private int id;
    private String name;
    @SerializedName("image")
    private String imgURL;
    private String description;

    public Planet(int id, String name, String imgURL) {
        this.id = id;
        this.name = name;
        this.imgURL = imgURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
