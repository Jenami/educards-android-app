package unq.alu.educards_android_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import educards.educards_service.EducardsFactory;
import educards.educards_model.RankingModel;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HomeActivity extends AppCompatActivity {

    static final String BROADCAST_HOMEACTIVITY_EDIT = "HOMEACTIVITY_EDIT";

    private Integer id;
    private Integer age;
    protected String username;
    private String password;
    protected String image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_HOMEACTIVITY_EDIT);
        broadcastManager.registerReceiver(broadcastReceiver, intentFilter);


        TextView nameTextView = findViewById(R.id.textViewNamePlayer);
        ImageView userImage = findViewById(R.id.imageViewUserImage);
        Button playButtonHome = findViewById(R.id.playButtonHome);
        Button editButtonHome = findViewById(R.id.editButtonHome);
        Button seeRankingButton = findViewById(R.id.buttonRanking);

        if (getIntent().hasExtra("name") && getIntent().hasExtra("password")) {
            this.username = getIntent().getExtras().getString("name");
            this.image = getIntent().getExtras().getString("image");
            this.password = getIntent().getExtras().getString("password");
            this.id = getIntent().getExtras().getInt("id");
            this.age = getIntent().getExtras().getInt("age");

            Bitmap res = stringToBitmap(image);
            userImage.setImageBitmap(res);

            nameTextView.setText(username);

            playButtonHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent startIntent = new Intent(HomeActivity.this, JugarActivity.class);
                    startIntent.putExtra("id", id);
                    startIntent.putExtra("name", username);
                    startIntent.putExtra("image", image);
                    startActivity(startIntent);
                }
            });


            editButtonHome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent editIntent = new Intent(HomeActivity.this, EditProfileActivity.class);
                    editIntent.putExtra("id", id);
                    editIntent.putExtra("name", username);
                    editIntent.putExtra("image", image);
                    editIntent.putExtra("age", age);
                    editIntent.putExtra("password", password);

                    startActivity(editIntent);


                }
            });


            seeRankingButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new EducardsFactory().getServiceFactory().getRankings(new Callback<List<RankingModel>>() {
                        @Override
                        public void success(List<RankingModel> response, Response response2) {
                            List<RankingModel> ranking = response;
                            ArrayList<String> rankingParsed = new ArrayList<String>();
                            for (RankingModel r : ranking) {
                                rankingParsed.add( " " + r.getName() + " --- " + r.getRank().toString() + " " );
                            }
                            openRankingDialog(rankingParsed);
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Toast.makeText(getBaseContext(), "Try again later : "+ error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });
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

    public void openRankingDialog(ArrayList<String> rankings) {

        Bundle bundle = new Bundle();

        Integer number = 0;
        for (String ranking : rankings){
            bundle.putString(number.toString(), ranking);
            number++;
        }
        bundle.putString("total", number.toString());

        RankingDialog rankingDialog = new RankingDialog();
        rankingDialog.setArguments(bundle);
        rankingDialog.show(getSupportFragmentManager(), "dialog");

    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(BROADCAST_HOMEACTIVITY_EDIT)){
                Intent home = getIntent();
                finish();
                home.putExtra("name", intent.getExtras().getString("nameEdit"));
                home.putExtra("image", intent.getExtras().getString("imageEdit"));
                home.putExtra("age", intent.getExtras().getInt("ageEdit"));
                home.putExtra("id", intent.getExtras().getInt("idEdit"));
                home.putExtra("password", intent.getExtras().getString("passEdit"));

                startActivity(home);
            }
        }
    };
}
