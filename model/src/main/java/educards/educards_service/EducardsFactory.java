package educards.educards_service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import educards.educards_service.EducardsService;
import retrofit.RestAdapter;

public class EducardsFactory {

    public EducardsFactory(){}

    public EducardsService getServiceFactory() {

        String API_URL = "https://educards-unq.herokuapp.com/";

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();

        EducardsService educardsService = restAdapter.create(EducardsService.class);

        return educardsService;
    }
}
