package ru.hackrussia.foodsharing1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdListAdapter extends RecyclerView.Adapter<AdListAdapter.ViewHolder> {
    private List<Ad> ads;
    private OnListItemClickListener clickListener;

    public AdListAdapter(List<Ad> ads, OnListItemClickListener clickListener) {
        this.ads = ads;
        this.clickListener = clickListener;
    }

    @Override
    public AdListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_ad, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(ads.get(position));
    }

    @Override
    public int getItemCount() {
        return ads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView image;
        TextView title;
        TextView description;
        TextView created;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (TextView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            created = (TextView) itemView.findViewById(R.id.created);
        }

        public void bind(Ad ad) {
            title.setText(ad.getTitle());
            created.setText("2016");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }
}
