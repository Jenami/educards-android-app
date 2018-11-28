package unq.alu.educards_android_app;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import educards.educards_model.EducardsFactory;
import educards.educards_model.Player;
import educards.educards_model.PlayerApi;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class EditProfileActivity extends AppCompatActivity {

    //ImageView image;
    //Bitmap bitmap;
    EditText usernameText;
    EditText passwordText;
    EditText ageText;
    //private static final int RESULT_LOAD_IMAGE = 1;

    String username;
    String image;
    String password;
    Integer id;
    Integer age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        if (getIntent().hasExtra("name") && getIntent().hasExtra("id") && getIntent().hasExtra("password")) {
            username = getIntent().getExtras().getString("name");
            password = getIntent().getExtras().getString("password");
            id = getIntent().getExtras().getInt("id");
            Toast.makeText(getBaseContext(), "edit id " + id.toString(), Toast.LENGTH_LONG).show();
            age = getIntent().getExtras().getInt("age");

            usernameText = findViewById(R.id.editTextUsernameEdit);
            passwordText = findViewById(R.id.editTextPasswordEdit);
            ageText = findViewById(R.id.playerAgeEdit);

            usernameText.setHint(username);
            passwordText.setHint(password);
            String ageS = age.toString();
            ageText.setHint(ageS);

            //image = findViewById(R.id.userImage);

            Button btnSaveChanges = findViewById(R.id.editButton);

            btnSaveChanges.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getBaseContext(), usernameText.getText(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getBaseContext(), passwordText.getText(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getBaseContext(), ageText.getText(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getBaseContext(), id.toString(), Toast.LENGTH_SHORT).show();
                    //bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
                    //new EditPlayer(bitmap).execute();
                    new EditPlayer().execute();
                }
            });

            //image.setOnClickListener(new View.OnClickListener() {
            //    @Override
            //    public void onClick(View v) {
            //Intent galleryIntent = new Intent( Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            //startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
            //    }
            //});
        }

    }

    private class EditPlayer extends AsyncTask<Void, Void, Void> {
        Bitmap bit;

        public EditPlayer ( ){}

        @Override
        protected Void doInBackground(Void... voids) {
            //ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            //bit.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            //String encodedBitmap = android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), android.util.Base64.DEFAULT);

            new EducardsFactory().getServiceFactory().editPlayer(id, usernameText.getText().toString(),
                    Integer.valueOf(ageText.getText().toString()), passwordText.getText().toString(), new Callback<Player>() {

                        @Override
                        public void success(Player response, Response response2) {
                            Toast.makeText(getBaseContext(), response.getUsername()+" changes saved", Toast.LENGTH_LONG).show();
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
            Toast.makeText(getBaseContext(), "Edit finished", Toast.LENGTH_LONG).show();
            finish();
        }
    }

}
