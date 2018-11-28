package unq.alu.educards_android_app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RankingDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        String totalString = getArguments().getString("total");
        int total = Integer.valueOf(totalString);

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_ranking, null);

        TextView content1 = view.findViewById(R.id.textViewContentRanking);
        TextView content2 = view.findViewById(R.id.textViewContentRanking2);
        TextView content3 = view.findViewById(R.id.textViewContentRanking3);
        TextView content4 = view.findViewById(R.id.textViewContentRanking4);
        TextView content5 = view.findViewById(R.id.textViewContentRanking5);
	TextView content6 = view.findViewById(R.id.textViewContentRanking6);
        TextView content7 = view.findViewById(R.id.textViewContentRanking7);
        TextView content8 = view.findViewById(R.id.textViewContentRanking8);
        TextView content9 = view.findViewById(R.id.textViewContentRanking9);
        TextView content10 = view.findViewById(R.id.textViewContentRanking10);


        List<TextView> contents = new ArrayList<>();
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
            String c = getArguments().getString(i.toString());
            contents.get(i).setText(c);
        }

        builder.setView(view)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();

    };
}
