package ru.horekdev.calculationofthebill;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.horekdev.calculationofthebill.dataBaseManager.DataBaseHelper;

public class HotLineActivity extends AppCompatActivity {
    TextView mini, title;
    Button send;
    EditText name, email, comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot_line);

        mini = findViewById(R.id.miniTitle);
        title = findViewById(R.id.hotlineTitle);

        send = findViewById(R.id.send);

        name = findViewById(R.id.personName);
        email = findViewById(R.id.personEmail);
        comment = findViewById(R.id.personComment);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.soundbutton);
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this, null);

        send.setOnClickListener(view -> {
            MainActivity.MediaControl(mediaPlayer);
            dataBaseHelper.addReport(email.getText().toString(), comment.getText().toString());

            finish();
        });
    }
}