package ru.horekdev.calculationofthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HotLineActivity extends AppCompatActivity {
    TextView message, mini, title;
    Button send;
    EditText name, email, comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_line);

        message = findViewById(R.id.forPersonMessage);
        mini = findViewById(R.id.miniTitle);
        title = findViewById(R.id.hotlineTitle);

        send = findViewById(R.id.send);

        name = findViewById(R.id.personName);
        email = findViewById(R.id.personEmail);
        comment = findViewById(R.id.personComment);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.soundbutton);

        send.setOnClickListener(view -> {
            MainActivity.MediaControl(mediaPlayer);

            dataBaseManager dataBaseManager = new dataBaseManager(HotLineActivity.this);
            dataBaseManager.addRequest(name.getText().toString(),
                    email.getText().toString(),
                    comment.getText().toString());

            name.setVisibility(View.INVISIBLE);
            email.setVisibility(View.INVISIBLE);
            comment.setVisibility(View.INVISIBLE);
            send.setVisibility(View.INVISIBLE);
            mini.setVisibility(View.INVISIBLE);
            title.setVisibility(View.INVISIBLE);

            message.setVisibility(View.VISIBLE);
        });
    }
}