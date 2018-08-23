package hu.horvath.martina.project.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import hu.horvath.martina.project.R;

public class EmptyViewHolder extends RecyclerView.ViewHolder {
    public final TextView noItemTextView;

    public EmptyViewHolder(View view) {
        super(view);
        noItemTextView = view.findViewById(R.id.noItemTextView);
    }
}
