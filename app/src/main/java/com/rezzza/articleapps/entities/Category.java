package com.rezzza.articleapps.entities;

import com.rezzza.articleapps.R;

public enum Category {

    GENERAL("General", R.drawable.ic_general),
    BUSINESS("Business", R.drawable.ic_bussines),
    SCIENCE("Science", R.drawable.ic_science),
    HEALTH("Health", R.drawable.ic_health),
    SPORTS("Sports", R.drawable.ic_sport),
    TECHNOLOGY("Technology", R.drawable.ic_technology),
    ENTERTAINMENT("Entertainment", R.drawable.ic_entertainment);

    private final String name;
    private final int icon;

    Category(String name, int icon){
        this.name = name;
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public Category[] getAll(){
        return Category.values();
    }
}
