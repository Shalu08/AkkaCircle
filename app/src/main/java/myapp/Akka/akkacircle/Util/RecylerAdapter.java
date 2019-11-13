package myapp.Akka.akkacircle.Util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import myapp.Akka.akkacircle.Model.Gridlist;
import myapp.Akka.akkacircle.R;

public class RecylerAdapter extends RecyclerView.Adapter {
    private List<Gridlist> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
public ImageView img;
        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.dailygrocery);
            img=(ImageView) view.findViewById(R.id.dailygroceryimg);
    }
    }
    public RecylerAdapter(List<Gridlist> moviesList) {
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruits, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Gridlist movie = moviesList.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
