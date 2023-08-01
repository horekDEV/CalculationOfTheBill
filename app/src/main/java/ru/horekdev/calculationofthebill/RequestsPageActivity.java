package ru.horekdev.calculationofthebill;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RequestsPageActivity extends AppCompatActivity {
    dataBaseManager dataBaseManager;
    ArrayList<String> id, author, email, comment;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests_page);

        dataBaseManager = new dataBaseManager(this);
        recyclerView = findViewById(R.id.dataRecycle);
        deleteBtn = findViewById(R.id.delete);

        id = new ArrayList<>();
        author = new ArrayList<>();
        email = new ArrayList<>();
        comment = new ArrayList<>();

        displayData();

        customAdapter = new CustomAdapter(this, comment, id, email);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        deleteBtn.setOnClickListener(view -> {
            dataBaseManager.deleteAllRequests();
        });
    }

    private void displayData() {
        Cursor cursor = dataBaseManager.getRequest();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Нет данных", Toast.LENGTH_SHORT).show();
        } else {
                while (cursor.moveToNext()) {
                id.add(cursor.getString(0));
                author.add(cursor.getString(1));
                email.add(cursor.getString(2));
                comment.add(cursor.getString(3));
            }
        }
    }
}