package unq.alu.educards_android_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import educards.educards_service.EducardsFactory;
import educards.educards_model.Player;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class EditProfileActivity extends AppCompatActivity {

    ImageView image;
    Bitmap bitmap;
    EditText usernameText;
    EditText passwordText;
    EditText ageText;
    private static final int RESULT_LOAD_IMAGE = 1;

    String username;
    String imageString;
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
            age = getIntent().getExtras().getInt("age");
            imageString = getIntent().getExtras().getString("image");

            usernameText = findViewById(R.id.editTextUsernameEdit);
            passwordText = findViewById(R.id.editTextPasswordEdit);
            ageText = findViewById(R.id.playerAgeEdit);
            image = findViewById(R.id.userImageEdit);

            Bitmap res = stringToBitmap(imageString);
            image.setImageBitmap(res);


            usernameText.setHint(username);
            passwordText.setHint(password);
            String ageS = age.toString();
            ageText.setHint(ageS);

            Button btnSaveChanges = findViewById(R.id.editButton);
            btnSaveChanges.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
                    new EditPlayer(bitmap).execute();
                }
            });

            Button btnAddImageEdit = findViewById(R.id.addImageEditButton);
            btnAddImageEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            Intent galleryIntent = new Intent( Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                }
            });
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null ){
            Uri selectedImage = data.getData();
            image.setImageURI(selectedImage);
        }

    }

    private class EditPlayer extends AsyncTask<Void, Void, Void> {
        Bitmap bit;

        public EditPlayer ( Bitmap b){
            bit = b;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bit.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            String encodedBitmap = android.util.Base64.encodeToString(byteArrayOutputStream.toByteArray(), android.util.Base64.DEFAULT);

            Player p = new Player (id, encodedBitmap, usernameText.getText().toString(),
                    Integer.valueOf(ageText.getText().toString()), passwordText.getText().toString());

            new EducardsFactory().getServiceFactory().editPlayer(p, new Callback<Player>() {

                        @Override
                        public void success(Player response, Response response2) {
                            Toast.makeText(getBaseContext(), response.getUsername()+" changes saved", Toast.LENGTH_LONG).show();

                            finish();
                            Intent intent = new Intent(HomeActivity.BROADCAST_HOMEACTIVITY_EDIT);
                            intent.putExtra("nameEdit",usernameText.getText().toString());
                            intent.putExtra("imageEdit", encodedBitmap);
                            intent.putExtra("ageEdit", Integer.valueOf(ageText.getText().toString()));
                            intent.putExtra("idEdit", id);
                            intent.putExtra("passEdit", passwordText.getText());
                            LocalBroadcastManager.getInstance(getParent()).sendBroadcast(intent);

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

        }
    }

    public Bitmap stringToBitmap(String encodedString){
        try{
            byte [] b= android.util.Base64.decode(encodedString, android.util.Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            return bitmap;
        }
        catch (Exception e){
            e.getMessage();
            return null;
        }
    }
}
