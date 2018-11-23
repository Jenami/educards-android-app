package educards.educards_model;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import educards.educards_service.EducardsService;
import retrofit.RestAdapter;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;

public class EducardsFactory {


    public EducardsFactory(){}

    public EducardsService getServiceFactory() {

        String SERVER_IP = "192.168.0.7"; //revisar
        String API_URL = "http://" + SERVER_IP + ":8080";

        //Gson gson = new GsonBuilder().setLenient().create();

        //Retrofit retrofit = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.
          //      create(gson)).build();
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();


        EducardsService educardsService = restAdapter.create(EducardsService.class);

        return educardsService;
    }
}
