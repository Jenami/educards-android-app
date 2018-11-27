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

import educards.educards_model.EducardsFactory;
import educards.educards_model.PlayerApi;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText username = findViewById(R.id.editTextUsername);
        final EditText password = findViewById(R.id.editTextPassword);
        EditText age = findViewById(R.id.playerAge);
        ImageView image = findViewById(R.id.userImage);
        Button btnAddImage = findViewById(R.id.addImageButton);
        Button btnRegister = findViewById(R.id.registerButton);

            btnRegister.setOnClickListener(new View.OnClickListener() {

                //REVER IMAGEN
                @Override
                public void onClick(View v) {
                    PlayerApi playerToAdd = new PlayerApi( username.getText().toString(), Integer.valueOf(age.getText().toString()),
                            "image.jpg", password.getText().toString());

                    new EducardsFactory().getServiceFactory().addPlayer(playerToAdd, new Callback<Response>() {
                        @Override
                        public void success(Response response, Response response2) {
                            Toast.makeText(getBaseContext(), username.getText().toString()+" registered", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(getBaseContext(), "invalid something: "+ error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });
        }
    }

