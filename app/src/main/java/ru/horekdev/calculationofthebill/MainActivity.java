package ru.horekdev.calculationofthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText sum;
    TextView title;
    TextView twoPeople;
    TextView threePeople;
    TextView fourPeople;
    TextView zero;
    TextView twenty;
    TextView fifty;
    TextView hundred;
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

        start = findViewById(R.id.startClaculating);

        MediaPlayer click = MediaPlayer.create(this, R.raw.soundbutton);
        //todo сделать лямбду


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                percent = 0;
                Toast.makeText(MainActivity.this, "Вы выбрали, что чаевые будут составлять 0%", Toast.LENGTH_SHORT).show();
            }
        });

        twenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                percent = 20;
                Toast.makeText(MainActivity.this, "Вы выбрали, что чаевые будут составлять 20%", Toast.LENGTH_SHORT).show();
            }
        });

        fifty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                percent = 50;
                Toast.makeText(MainActivity.this, "Вы выбрали, что чаевые будут составлять 50%", Toast.LENGTH_SHORT).show();
            }
        });

        hundred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                percent = 100;
                Toast.makeText(MainActivity.this, "Вы выбрали, что чаевые будут составлять 100%", Toast.LENGTH_SHORT).show();
            }
        });

        twoPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peopleCount = 2;
                Toast.makeText(MainActivity.this, "Вы выбрали, что людей которые будут делить деньги на заказ двое", Toast.LENGTH_SHORT).show();
            }
        });

        threePeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peopleCount = 3;
                Toast.makeText(MainActivity.this, "Вы выбрали, что людей которые будут делить деньги на заказ трое", Toast.LENGTH_SHORT).show();
            }
        });

        fourPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peopleCount = 4;
                Toast.makeText(MainActivity.this, "Вы выбрали, что людей которые будут делить деньги на заказ четверо", Toast.LENGTH_SHORT).show();
            }
        });
    }
}