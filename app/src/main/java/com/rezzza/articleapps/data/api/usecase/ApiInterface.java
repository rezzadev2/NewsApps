package com.rezzza.articleapps.data.api.usecase;

import com.rezzza.articleapps.data.api.model.NewsResponseModel;
import com.rezzza.articleapps.data.api.model.SourceResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET
    public Call<SourceResponseModel> getSource(@Url String url );

    @GET
    public Call<NewsResponseModel> getNews(@Url String url );

}
