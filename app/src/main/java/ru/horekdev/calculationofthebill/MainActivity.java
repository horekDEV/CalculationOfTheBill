package ru.horekdev.calculationofthebill;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText sum;
    TextView title, twoPeople, threePeople, fourPeople, zero, twenty, fifty, hundred, order;
    Button start;
    int percent;
    int peopleCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sum = findViewById(R.id.sum);

        title = findViewById(R.id.title);

        twoPeople = findViewById(R.id.twoPeople);
        threePeople = findViewById(R.id.threePeople);
        fourPeople = findViewById(R.id.fourPeople);

        zero = findViewById(R.id.zero);
        twenty = findViewById(R.id.twenty);
        fifty = findViewById(R.id.fifty);
        hundred = findViewById(R.id.hundred);

        order = findViewById(R.id.order);

        start = findViewById(R.id.startClaculating);

        MediaPlayer click = MediaPlayer.create(this, R.raw.soundbutton);


        zero.setOnClickListener(view ->  {
            percent = 0;
            Toast.makeText(MainActivity.this, "Вы выбрали, что чаевые будут составлять 0%", Toast.LENGTH_SHORT).show();
        });

        twenty.setOnClickListener(view ->  {
            percent = 20;
            Toast.makeText(MainActivity.this, "Вы выбрали, что чаевые будут составлять 20%", Toast.LENGTH_SHORT).show();
        });

        fifty.setOnClickListener(view ->  {
            percent = 50;
            Toast.makeText(MainActivity.this, "Вы выбрали, что чаевые будут составлять 50%", Toast.LENGTH_SHORT).show();
        });

        hundred.setOnClickListener(view ->  {
            percent = 100;
            Toast.makeText(MainActivity.this, "Вы выбрали, что чаевые будут составлять 100%", Toast.LENGTH_SHORT).show();
        });

        twoPeople.setOnClickListener(view ->  {
            peopleCount = 2;
            Toast.makeText(MainActivity.this, "Вы выбрали, что людей которые будут делить деньги на заказ двое", Toast.LENGTH_SHORT).show();
        });

        threePeople.setOnClickListener(view ->  {
            peopleCount = 3;
            Toast.makeText(MainActivity.this, "Вы выбрали, что людей которые будут делить деньги на заказ трое", Toast.LENGTH_SHORT).show();
        });

        fourPeople.setOnClickListener(view ->  {
            peopleCount = 4;
            Toast.makeText(MainActivity.this, "Вы выбрали, что людей которые будут делить деньги на заказ четверо", Toast.LENGTH_SHORT).show();
        });

        start.setOnClickListener(view -> {
            MediaControl(click);
            int result = 0;
            int tips;

            if (percent == 0) {
                result = Integer.parseInt(sum.getText().toString()) / peopleCount;
            } else {
                if (percent == 20) {
                    tips = (int) (Integer.parseInt(sum.getText().toString()) * 0.20);
                    result = Integer.parseInt(sum.getText().toString()) + tips / peopleCount;

                } else if (percent == 50) {
                    tips = (int) (Integer.parseInt(sum.getText().toString()) * 0.50);
                    result = Integer.parseInt(sum.getText().toString()) + tips / peopleCount;

                } else if (percent == 100) {
                    result = (Integer.parseInt(sum.getText().toString()) + Integer.parseInt(sum.getText().toString())) / peopleCount;
                }
            }

            order.setVisibility(View.VISIBLE);
            title.setText(String.valueOf(result));
        });
    }

    public void MediaControl(MediaPlayer sound) {
        if (sound.isPlaying()) {
            sound.pause();
            sound.seekTo(0);
        }

        sound.start();
    }
}