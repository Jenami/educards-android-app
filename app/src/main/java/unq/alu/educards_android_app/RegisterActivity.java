package unq.alu.educards_android_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

import educards.educards_model.EducardsFactory;
import educards.educards_model.PlayerApi;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RegisterActivity extends AppCompatActivity {

    ImageView image;
    Bitmap bitmap;
    EditText username;
    EditText password;
    EditText age;
    private static final int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        age = findViewById(R.id.playerAge);
        image = findViewById(R.id.userImage);

        Button btnRegister = findViewById(R.id.registerButton);

            btnRegister.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
                   new RegisterPlayer(bitmap).execute();
               }
            });

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent galleryIntent = new Intent( Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);


                }
            });



        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null ){
            Uri selectedImage = data.getData();
            image.setImageURI(selectedImage);
        }


    }

    private class RegisterPlayer extends AsyncTask<Void, Void, Void>{
        Bitmap bit;

        public RegisterPlayer (Bitmap b){
            bit = b;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bit.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            String encodedBitmap = android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), android.util.Base64.DEFAULT);

            PlayerApi playerToAdd = new PlayerApi( username.getText().toString(), Integer.valueOf(age.getText().toString()),
                    encodedBitmap, password.getText().toString());

            new EducardsFactory().getServiceFactory().addPlayer(playerToAdd, new Callback<Response>() {
                @Override
                public void success(Response response, Response response2) {
                    Toast.makeText(getBaseContext(), username.getText().toString()+" registered", Toast.LENGTH_LONG).show();
                }

                @Override
                public void failure(RetrofitError error) {
                    Toast.makeText(getBaseContext(), "invalid : "+ error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getBaseContext(), "All done", Toast.LENGTH_LONG).show();
        }
    }


}

