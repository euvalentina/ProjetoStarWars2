package br.com.fiap.starwars;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by logonrm on 24/05/2017.
 */

public interface RequestCall {

    @GET("people/1")
    Call<StarWars> getALLJSON();
}
