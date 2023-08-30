package ru.horekdev.calculationofthebill;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText sum = findViewById(R.id.sum);
        TextView title = findViewById(R.id.title);

        TextView twoPeople = findViewById(R.id.twoPeople);
        TextView threePeople = findViewById(R.id.threePeople);
        TextView fourPeople = findViewById(R.id.fourPeople);

        TextView zero = findViewById(R.id.zero);
        TextView twenty = findViewById(R.id.twenty);
        TextView fifty = findViewById(R.id.fifty);
        TextView hundred = findViewById(R.id.hundred);

        TextView order = findViewById(R.id.order);

        Button start = findViewById(R.id.startClaculating);
        Button clear = findViewById(R.id.clear);
        ImageButton phone = findViewById(R.id.phone);

        AtomicInteger percent = new AtomicInteger();
        AtomicInteger peopleCount = new AtomicInteger(2);

        MediaPlayer click = MediaPlayer.create(this, R.raw.soundbutton);


        zero.setOnClickListener(view ->  {
            percent.set(0);
            Toast.makeText(MainActivity.this, "Вы выбрали, что чаевые будут составлять 0%", Toast.LENGTH_SHORT).show();
        });

        twenty.setOnClickListener(view ->  {
            percent.set(20);
            Toast.makeText(MainActivity.this, "Вы выбрали, что чаевые будут составлять 20%", Toast.LENGTH_SHORT).show();
        });

        fifty.setOnClickListener(view ->  {
            percent.set(50);
            Toast.makeText(MainActivity.this, "Вы выбрали, что чаевые будут составлять 50%", Toast.LENGTH_SHORT).show();
        });

        hundred.setOnClickListener(view ->  {
            percent.set(100);
            Toast.makeText(MainActivity.this, "Вы выбрали, что чаевые будут составлять 100%", Toast.LENGTH_SHORT).show();
        });

        twoPeople.setOnClickListener(view ->  {
            peopleCount.set(2);
            Toast.makeText(MainActivity.this, "Вы выбрали, что людей которые будут делить деньги на заказ двое", Toast.LENGTH_SHORT).show();
        });

        threePeople.setOnClickListener(view ->  {
            peopleCount.set(3);
            Toast.makeText(MainActivity.this, "Вы выбрали, что людей которые будут делить деньги на заказ трое", Toast.LENGTH_SHORT).show();
        });

        fourPeople.setOnClickListener(view ->  {
            peopleCount.set(4);
            Toast.makeText(MainActivity.this, "Вы выбрали, что людей которые будут делить деньги на заказ четверо", Toast.LENGTH_SHORT).show();
        });

        start.setOnClickListener(view -> {
            MediaControl(click);
            int result = 0;
            int tips;

            if (peopleCount.get() > 1) {
                if (percent.get() == 0) {
                    result = Integer.parseInt(sum.getText().toString()) / peopleCount.get();
                } else {
                    if (percent.get() == 20) {
                        tips = (int) (Integer.parseInt(sum.getText().toString()) * 0.20);
                        result = Integer.parseInt(sum.getText().toString()) + tips / peopleCount.get();

                    } else if (percent.get() == 50) {
                        tips = (int) (Integer.parseInt(sum.getText().toString()) * 0.50);
                        result = Integer.parseInt(sum.getText().toString()) + tips / peopleCount.get();

                    } else if (percent.get() == 100) {
                        result = (Integer.parseInt(sum.getText().toString()) + Integer.parseInt(sum.getText().toString())) / peopleCount.get();
                    }
                }
            } else {
                order.setVisibility(View.INVISIBLE);
                title.setText("Счетчик");
                Toast.makeText(this, "Вы не указали кол-во человек!", Toast.LENGTH_SHORT).show();
            }

            order.setVisibility(View.VISIBLE);
            title.setText(String.valueOf(result));
        });

        clear.setOnClickListener(view -> {
            MediaControl(click);

            if (!sum.getText().toString().isEmpty()) {
                sum.clearComposingText();
            }

            order.setVisibility(View.INVISIBLE);
            title.setText("Счетчик");

            peopleCount.set(0);
            percent.set(0);
        });

        phone.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, HotLineActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Вы уверены, что хотите выйти?");
        builder.setMessage("весь процесс будет удален!");
        builder.setPositiveButton("да, я хочу выйти", (dialogInterface, i) -> {
            dialogInterface.dismiss();
        });

        builder.setNegativeButton("нет, я хочу остаться", (dialogInterface, i) -> {
            dialogInterface.cancel();
        });

        builder.create();
    }

    public static void MediaControl(MediaPlayer sound) {
        if (sound.isPlaying()) {
            sound.pause();
            sound.seekTo(0);
        }

        sound.start();
    }
}