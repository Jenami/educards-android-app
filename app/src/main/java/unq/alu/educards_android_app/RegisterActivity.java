package unq.alu.educards_android_app;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import educards.educards_model.EducardsFactory;
import educards.educards_model.Player;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText username = findViewById(R.id.editTextUsername);
        EditText password = findViewById(R.id.editTextPassword);
        EditText age = findViewById(R.id.playerAge);
        ImageView image = findViewById(R.id.userImage);
        Button btnAddImage = findViewById(R.id.addImageButton);
        Button btnRegister = findViewById(R.id.registerButton);

        if (getIntent().hasExtra("unq.alu.educards_android_app.EXTRA")) {

            btnRegister.setOnClickListener(new View.OnClickListener() {
                Player playerToAdd = new Player( username.getText().toString(), password.getText().toString(),
                        10, "imagen.jpg");

                //REVER
                @Override
                public void onClick(View v) {
                    new EducardsFactory().getServiceFactory().addPlayer(playerToAdd, new Callback<Response>() {
                        @Override
                        public void success(Response response, Response response2) {
                            Toast.makeText(getBaseContext(), "YEAH", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(getBaseContext(), "invalid something", Toast.LENGTH_LONG).show();
                        }
                    });


                }
            });
        }
    }
}
