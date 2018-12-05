package unq.alu.educards_android_app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class JugarDialog extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        String username = getArguments().getString("name");
        String totalString = getArguments().getString("total");
        int total = Integer.valueOf(totalString);

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_jugar,null);

        TextView namePoints = view.findViewById(R.id.textViewNamePoints);
        namePoints.setText(username);

        TextView content1 = view.findViewById(R.id.textViewContentPoints1);
        TextView content2 = view.findViewById(R.id.textViewContentPoints2);
        TextView content3 = view.findViewById(R.id.textViewContentPoints3);
        TextView content4 = view.findViewById(R.id.textViewContentPoints4);
        TextView content5 = view.findViewById(R.id.textViewContentPoints5);
        TextView content6 = view.findViewById(R.id.textViewContentPoints6);
        TextView content7 = view.findViewById(R.id.textViewContentPoints7);
        TextView content8 = view.findViewById(R.id.textViewContentPoints8);
        TextView content9 = view.findViewById(R.id.textViewContentPoints9);
        TextView content10 = view.findViewById(R.id.textViewContentPoints10);

        List<TextView> contents = new ArrayList<TextView>();
        contents.add(content1);
        contents.add(content2);
        contents.add(content3);
        contents.add(content4);
        contents.add(content5);
        contents.add(content6);
        contents.add(content7);
        contents.add(content8);
        contents.add(content9);
        contents.add(content10);

        for (Integer i = 0; i < total  && i < 10; i++) {
            String score = getArguments().getString(i.toString());
            contents.get(i).setText( score);
        }

        builder.setView(view)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent returnHome = new Intent(JugarActivity.BROADCAST_JUGARACTIVITY_CLOSE);
                        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(returnHome);
                    }
                });

        return builder.create();

    };
}
