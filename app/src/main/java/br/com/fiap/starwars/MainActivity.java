package br.com.fiap.starwars;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
private EditText edtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Load();
        edtResult = (EditText) findViewById(R.id.editText);


    }
    public void Load(){

        /**
         * Load faz acesso ao Servidor REST(.baseUrl("http://swapi.co/api/"))
         * emquanto ele tenta acessar ele fica em branco ate receber os response(resposta)
         * do servico,
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestCall api = retrofit.create(RequestCall.class);
        api.getALLJSON().enqueue(new Callback<StarWars>() {
            @Override
            public void onResponse(Call<StarWars> call, Response<StarWars> response) {

                /**
                 * aqui ele recebe a resposta se tudo estiver ok no site/servido rest
                 */
                StarWars json = response.body();
                Log.i("Teste: ", json.toString());
                edtResult.setText(json.getName().toString());
            }

            @Override
            public void onFailure(Call<StarWars> call, Throwable t) {
                /**
                 * aqui acaso de algum erro sera logado no log sistem
                 */
                Log.i("Teste: ", t.getMessage());
            }
        });

    }

    public void Load(View view) {

    }
}
