package ru.horekdev.calculationofthebill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomHandler> {
    private Context context;
    private ArrayList comment, id, email;

    public CustomAdapter(Context context, ArrayList comment, ArrayList id, ArrayList email) {
        this.context = context;
        this.comment = comment;
        this.id = id;
        this.email = email;
    }

    @NonNull
    @Override
    public CustomHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.resycleview_design, parent, false);
        return new CustomHandler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHandler holder, int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.email.setText(String.valueOf(email.get(position)));
        holder.comment.setText(String.valueOf(comment.get(position)));
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class CustomHandler  extends RecyclerView.ViewHolder {
        TextView id, comment, email;

        public CustomHandler(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.idData);
            comment = itemView.findViewById(R.id.commentData);
            email = itemView.findViewById(R.id.emailData);
        }
    }
}
