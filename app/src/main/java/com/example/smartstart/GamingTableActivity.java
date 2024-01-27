package com.example.smartstart;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GamingTableActivity extends AppCompatActivity {
    private static final int NUM_IMAGES = 16;
    private List<Integer> unusedImageIndices = new ArrayList<>();
    private List<Integer> usedImageIndices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gaming_table);

        for (int i = 1; i <= NUM_IMAGES; i++) {
            unusedImageIndices.add(i);
        }

        ImageButton card1 = findViewById(R.id.card1);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImageDialog();
            }
        });
    }

    private void showImageDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.TransparentDialog);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_layout, null);
        ImageView imageView = dialogView.findViewById(R.id.imageView);

        int randomImageIndex = getRandomUnusedImageIndex();

        if (randomImageIndex == -1) {

            showMessageDialog("All cards have been used!");
            return;
        }

        String imageName = "card1_" + randomImageIndex;
        int imageResourceId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        imageView.setImageResource(imageResourceId);

        builder.setView(dialogView)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
    }

    private int getRandomUnusedImageIndex() {
        if (unusedImageIndices.isEmpty()) {

            return -1;
        }


        if (unusedImageIndices.isEmpty()) {
            unusedImageIndices.addAll(usedImageIndices);
            usedImageIndices.clear();
            Collections.shuffle(unusedImageIndices);
        }


        int randomImageIndex = unusedImageIndices.remove(0);


        usedImageIndices.add(randomImageIndex);

        return randomImageIndex;
    }

    private void showMessageDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
