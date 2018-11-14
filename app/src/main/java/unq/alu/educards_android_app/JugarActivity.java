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

import java.util.ArrayList;

import educards.educards_model.card.Card;
import educards.educards_model.game.Game;
import educards.educards_model.player.Player;


public class JugarActivity extends AppCompatActivity {

    ImageView image1, image2, image3, image4, image5;
    ImageView target1, target2, target3, target4, target5;
    Card card1, card2, card3, card4, card5;
    Player player;
    Game game;

    Button playCardsButton;
    Button seeRankingButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jugar);

        if (getIntent().hasExtra("unq.alu.educards_android_app.EXTRA")) {
            TextView name = findViewById(R.id.textViewNamePlayer);
            String text = getIntent().getExtras().getString("unq.alu.educards_android_app.EXTRA");
            name.setText(text);

            //El orden correcto es 5,4,3,2,1 (al reves del que aparecen)

            card1 = new Card(1, "Beethoven", "9naSinfonia", 1949);
            card2 = new Card(2, "Abraham", "Bum", 1948);
            card3 = new Card(3, "Torre", "Paris", 1947);
            card4 = new Card(4, "Mona", "DaVinci", 1946);
            card5 = new Card(5, "Hitler", "Hail", 1945);

            ArrayList<Card> cartas = new ArrayList<Card>();
            cartas.add(card1);
            cartas.add(card2);
            cartas.add(card3);
            cartas.add(card4);
            cartas.add(card5);

            player = new Player(0, text);

            game = new Game(player, cartas); //aca ya crea un board

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
            target2 = findViewById(R.id.slot2);
            target3 = findViewById(R.id.slot3);
            target4 = findViewById(R.id.slot4);
            target5 = findViewById(R.id.slot5);

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


            playCardsButton = findViewById(R.id.buttonJugar);
            playCardsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openPlayCardsDialog();
                }
            });


            seeRankingButton = findViewById(R.id.buttonRanking);
            seeRankingButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openRankingDialog();
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

            switch (action) {
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:

                    View vi = (View) event.getLocalState();
                    ConstraintLayout owner1 = (ConstraintLayout) vi.getParent();
                    owner1.removeView(vi);//remove the dragged view
                    ConstraintLayout container = (ConstraintLayout) v.getParent();//caste the view into LinearLayout as our drag acceptable layout is LinearLayout
                    container.addView(vi);//Add the dragged view


                    if (v.getId() == target1.getId()) {

                        game.getBoard().playCard(1, (Card) vi.getTag());
                        vi.animate()
                                .x(target1.getX())
                                .y(target1.getY())
                                .setDuration(700)
                                .start();
                        v.setVisibility(View.INVISIBLE);

                    }
                    if (v.getId() == target2.getId()) {

                        game.getBoard().playCard(2, (Card) vi.getTag());
                        vi.animate()
                                .x(target2.getX())
                                .y(target2.getY())
                                .setDuration(700)
                                .start();
                        v.setVisibility(View.INVISIBLE);

                    }
                    if (v.getId() == target3.getId()) {
                        game.getBoard().playCard(3, (Card) vi.getTag());
                        vi.animate()
                                .x(target3.getX())
                                .y(target3.getY())
                                .setDuration(700)
                                .start();
                        v.setVisibility(View.INVISIBLE);

                    }
                    if (v.getId() == target4.getId()) {

                        game.getBoard().playCard( 4, (Card) vi.getTag());
                        vi.animate()
                                .x(target4.getX())
                                .y(target4.getY())
                                .setDuration(700)
                                .start();
                        v.setVisibility(View.INVISIBLE);

                    }
                    if (v.getId() == target5.getId()) {

                        game.getBoard().playCard( 5, (Card) vi.getTag());
                        vi.animate()
                                .x(target5.getX())
                                .y(target5.getY())
                                .setDuration(700)
                                .start();
                        v.setVisibility(View.INVISIBLE);
                    }

                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                    break;
            }
            return true;
        }


    };


    //new Dialog para el boton Jugar cartas
    public void openPlayCardsDialog() {
        game.finishGame();

        Bundle bundle = new Bundle();

        bundle.putString("activity", player.getUsername() + " : Tu puntuacion es " + game.getFinalScore().toString());

        JugarDialog jugarDialog = new JugarDialog();

        jugarDialog.setArguments(bundle);

        jugarDialog.show(getSupportFragmentManager(), "dialog");

    }

    //new Dialog para el boton ranking
    public void openRankingDialog() {

        Bundle bundle = new Bundle();

        bundle.putString("activity", player.getUsername() + " : Tu mejor puntuacion es " + game.getPlayer().getHiScore().toString());

        RankingDialog rankingDialog = new RankingDialog();

        rankingDialog.setArguments(bundle);

        rankingDialog.show(getSupportFragmentManager(), "dialog");

    }
}