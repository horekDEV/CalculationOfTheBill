package ru.horekdev.calculationofthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HotLineActivity extends AppCompatActivity {
    TextView message;
    TextView mini;
    TextView title;
    Button send;
    EditText name;
    EditText email;
    EditText comment;

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

            if (name != null || email != null || comment != null) {


            } else {
                Toast.makeText(this, "Вы что-то забыли указать!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}