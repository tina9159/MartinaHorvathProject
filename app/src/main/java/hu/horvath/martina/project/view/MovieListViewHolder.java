package hu.horvath.martina.project.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hu.horvath.martina.project.R;

public class MovieListViewHolder extends RecyclerView.ViewHolder{

    public ImageView image;
    public TextView title;

    public MovieListViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        title = itemView.findViewById(R.id.title);
    }
}
