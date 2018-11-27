package unq.alu.educards_android_app;

import android.content.ClipData;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.List;
import educards.educards_model.Board;
import educards.educards_model.Card;
import educards.educards_model.Educards;
import educards.educards_model.EducardsFactory;
import educards.educards_model.Player;
import educards.educards_model.PointsPlayer;
import educards.educards_model.RankingAPI;
import educards.educards_model.RankingModel;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class JugarActivity extends AppCompatActivity {

    ImageView image1, image2, image3, image4, image5;
    ImageView target1, target2, target3, target4, target5;
    Card card1, card2, card3, card4, card5;
    Player player;
    Board board;
    Educards educards;

    Button playCardsButton;
    Button seeRankingButton;

    ArrayList<String> scoreParsed;

    List<RankingModel> ranking;
    ArrayList<String> rankingParsed;

    Integer id;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jugar);

        card1 = new Card ("beethoven", 1, "Beethoven", "history1",1770, "bee") ;
        card2 = new Card ("abraham", 2, "Abraham", "history2",1865, "lincoln") ;
        card3 = new Card ("torre", 3, "Torre Eifel", "history3",1889, "bee") ;
        card4 = new Card ("mona", 4, "Mona Lisa", "history4",1503, "monalisa") ;
        card5 = new Card ("hitler", 5, "Hitler", "history5",1934, "bee") ;

        image1 = findViewById(R.id.imageViewCard1);
        image1.setTag(card1);
        image2 = findViewById(R.id.imageViewCard2);
        image2.setTag(card2);
        image3 = findViewById(R.id.imageViewCard3);
        image3.setTag(card3);
        image4 = findViewById(R.id.imageViewCard4);
        image4.setTag(card4);
        image5 = findViewById(R.id.imageViewCard5);
        image5.setTag(card5);

        target1 = findViewById(R.id.slot1);
        target1.setTag(1);
        target2 = findViewById(R.id.slot2);
        target2.setTag(2);
        target3 = findViewById(R.id.slot3);
        target3.setTag(3);
        target4 = findViewById(R.id.slot4);
        target4.setTag(4);
        target5 = findViewById(R.id.slot5);
        target5.setTag(5);


        if (getIntent().hasExtra("name")) {
            image1.setOnLongClickListener(longClickListener);
            image2.setOnLongClickListener(longClickListener);
            image3.setOnLongClickListener(longClickListener);
            image4.setOnLongClickListener(longClickListener);
            image5.setOnLongClickListener(longClickListener);

            target1.setOnDragListener(dragListener);
            target2.setOnDragListener(dragListener);
            target3.setOnDragListener(dragListener);
            target4.setOnDragListener(dragListener);
            target5.setOnDragListener(dragListener);

            TextView name = findViewById(R.id.textViewNamePlayer);
            String text = getIntent().getExtras().getString("name");
            this.id = getIntent().getExtras().getInt("id");
            this.username = text;
            name.setText(text);

            ArrayList<Card> cards = new ArrayList<>();
            cards.add(card1); cards.add(card2); cards.add(card3); cards.add(card4); cards.add(card5);

            Card cardX = new Card("", 100, "", "", 0, "");
            board = new Board(cards);
            educards = new Educards();
            educards.setBoard(board);
            for (int i= 1; i<6; i++){
                educards.board.playCard(i, cardX);
            }

            playCardsButton = findViewById(R.id.buttonJugar);
            playCardsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Integer score = educards.finishGame(id);
                        new EducardsFactory().getServiceFactory().addRanking(new RankingAPI(id, score), new Callback<List<Integer>>() {
                            @Override
                            public void success(List<Integer> response, Response response2) {
                                educards.setPointsPlayer (new PointsPlayer(response));
                                //Toast.makeText(getBaseContext(), "agrego el ranking", Toast.LENGTH_LONG).show();

                                List<Integer> rankings = educards.pointsPlayer.getPoints();
                                Toast.makeText(getBaseContext(),rankings.get(0).toString(), Toast.LENGTH_LONG).show();

                                scoreParsed = new ArrayList<>();
                                for (Integer r : rankings) {
                                    scoreParsed.add(" "+ r.toString());
                                }

                                openPlayCardsDialog(username, scoreParsed);
                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(getBaseContext(), "Fallo el addRanking "+ id.toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }

            });

            seeRankingButton = findViewById(R.id.buttonRanking);
            seeRankingButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    new EducardsFactory().getServiceFactory().getRankings(new Callback<List<RankingModel>>() {
                        @Override
                        public void success(List<RankingModel> response, Response response2) {
                            ranking = (List<RankingModel>) response;

                            rankingParsed = new ArrayList<String>();

                            for (RankingModel r : ranking) {
                                rankingParsed.add( " " + r.getName() + " --- " + r.getRank().toString() + " " );
                            }

                            openRankingDialog(rankingParsed);
                        }

                        @Override
                        public void failure(RetrofitError error) {

                        }
                    });

                }
            });
        }
    }


    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);

            return true;
        }
    };

    //proximo a refactorizar
    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int action = event.getAction();
            View vi = (View) event.getLocalState();

            switch (action) {
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:

                ConstraintLayout owner1 = (ConstraintLayout) vi.getParent();
                owner1.removeView(vi);//remove the dragged view
                ConstraintLayout container = (ConstraintLayout) v.getParent();
                container.addView(vi);//Add the dragged view

                    if (v.getId() == target1.getId()) {
                        educards.board.playCard(1, ((Card) vi.getTag()));
                        animateView(vi, v, target1);
                    }
                    if (v.getId() == target2.getId()) {
                        educards.board.playCard(2, (Card) vi.getTag());
                        animateView(vi, v, target2);
                    }
                    if (v.getId() == target3.getId()) {
                        educards.board.playCard(3, (Card) vi.getTag());
                        animateView(vi, v, target3);
                    }
                    if (v.getId() == target4.getId()) {
                        educards.board.playCard( 4, (Card) vi.getTag());
                        animateView(vi, v, target4);
                    }
                    if (v.getId() == target5.getId()) {
                        educards.board.playCard( 5, (Card) vi.getTag());
                        animateView(vi, v, target5);
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                    break;
            }
            return true;
        }

        void animateView(View animatedView, View view, View target){
            animatedView.animate()
                    .x(target.getX())
                    .y(target.getY())
                    .setDuration(700)
                    .start();
            view.setVisibility(View.INVISIBLE);
        }
    };

    //new Dialog para el boton Jugar cartas
    public void openPlayCardsDialog(String text, ArrayList<String> scores) {

        Bundle bundle = new Bundle();

        Integer number = 0;
        for (String score : scores){
            bundle.putString(number.toString(), score);
            number++;
        }
        bundle.putString("total", number.toString());
        bundle.putString("name", text);

        JugarDialog jugarDialog = new JugarDialog();
        jugarDialog.setArguments(bundle);
        jugarDialog.show(getSupportFragmentManager(), "dialog");

    }

    //new Dialog para el boton RankingAPI
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

}