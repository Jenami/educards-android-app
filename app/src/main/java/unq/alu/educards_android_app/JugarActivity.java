package unq.alu.educards_android_app;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class JugarActivity extends AppCompatActivity {

    ImageView image1, image2, image3, image4, image5;
    ImageView target1, target2, target3, target4, target5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        if (getIntent().hasExtra("unq.alu.educards_android_app.EXTRA")) {
            TextView name = findViewById(R.id.textViewNamePlayer);
            String text = getIntent().getExtras().getString("unq.alu.educards_android_app.EXTRA");
            name.setText(text);


            image1 = findViewById(R.id.imageViewCard1);
            image2 = findViewById(R.id.imageViewCard2);
            image3 = findViewById(R.id.imageViewCard3);
            image4 = findViewById(R.id.imageViewCard4);
            image5 = findViewById(R.id.imageViewCard5);

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

        }
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);

            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            int event = dragEvent.getAction();
            final View v = (View) dragEvent.getLocalState();

            switch (event){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:

                    v.animate()
                            .x(target1.getX())
                            .y(target1.getY())
                            .setDuration(700)
                            .start();
                    break;
            }
            return true;
        }
    };
}