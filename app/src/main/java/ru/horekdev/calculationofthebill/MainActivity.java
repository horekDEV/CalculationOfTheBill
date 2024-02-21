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

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {
    public EditText sum;
    public AtomicInteger percent = new AtomicInteger();
    public AtomicInteger peopleCount = new AtomicInteger(2);
    public TextView title;
    private MediaPlayer click;
    private TextView twoPeople, threePeople, fourPeople,
            zero, twenty, fifty, hundred, order;
    private Button start, clear;

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
        clear = findViewById(R.id.clear);
        ImageButton phone = findViewById(R.id.phone);

        click = MediaPlayer.create(this, R.raw.soundbutton);

        zero.setOnClickListener(view ->  {
            percent.set(0);
            Toast.makeText(MainActivity.this, "Вы выбрали, что чаевые будут составлять 0%", Toast.LENGTH_SHORT).show();
        });

        twenty.setOnClickListener(view ->  {
            percent.set(20);
            Toast.makeText(MainActivity.this,  "Вы выбрали, что чаевые будут составлять 20%", Toast.LENGTH_SHORT).show();
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

        start.setOnClickListener(view -> startBtnLogic());
        clear.setOnClickListener(view -> clearBtnLogic());

        phone.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, HotLineActivity.class);
            startActivity(intent);
        });
    }

    public static void MediaControl(MediaPlayer sound) {
        if (sound.isPlaying()) {
            sound.pause();
            sound.seekTo(0);
        }

        sound.start();
    }

    private void clearBtnLogic() {
        MediaControl(click);

        if (!sum.getText().toString().isEmpty()) {
            sum.clearComposingText();
        }

        order.setVisibility(View.INVISIBLE);
        title.setText("Счетчик");

        peopleCount.set(2);
        percent.set(0);
    }

    private void startBtnLogic() {
        MediaControl(click);
        order.setVisibility(View.VISIBLE);
        setSumOnTitle();
    }

    public double counter(AtomicInteger people, AtomicInteger percent, TextView sum) {
        double peopleCount = Double.parseDouble(people.toString());
        double sumText = Double.parseDouble(sum.getText().toString());
        double percents = Double.parseDouble(percent.toString());

        double tips;
        double result = 0;

        if (percents == 0.0) {
            result = sumText / peopleCount;
        } else {
            if (percents == 20.0) {
                tips = sumText * 0.20;
                result = sumText + tips / peopleCount;

            } else if (percents == 50.0) {
                tips = sumText * 0.50;
                result = sumText + tips / peopleCount;

            } else if (percents == 100.0) {
                result = sumText + sumText / peopleCount;
            }
        }

        return result;
    }

    private void setSumOnTitle() {
        title.setText(
                String.valueOf(counter(peopleCount, percent, sum))
        );
    }
}