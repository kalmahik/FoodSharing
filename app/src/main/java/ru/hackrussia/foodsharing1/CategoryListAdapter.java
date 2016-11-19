package ru.hackrussia.foodsharing1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {
    private List<Category> category;
    private OnListItemClickListener clickListener;

    public CategoryListAdapter(List<Category> category, OnListItemClickListener clickListener) {
        this.category = category;
        this.clickListener = clickListener;
    }

    @Override
    public CategoryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_category, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(category.get(position));
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
        }

        public void bind(Category category) {
            title.setText(category.getTitle());
            itemView.setOnClickListener(this);

            if (category.getId().equals("96"))
            image.setImageResource(R.drawable.bread); else

            if (category.getId().equals("97"))
                image.setImageResource(R.drawable.candy); else

            if (category.getId().equals("99"))
                image.setImageResource(R.drawable.drinks); else

            if (category.getId().equals("100"))
                image.setImageResource(R.drawable.frozen); else

            if (category.getId().equals("102"))
                image.setImageResource(R.drawable.grocery); else

            if (category.getId().equals("98"))
                image.setImageResource(R.drawable.milk); else

            if (category.getId().equals("106"))
                image.setImageResource(R.drawable.tins); else

            if (category.getId().equals("103"))
                image.setImageResource(R.drawable.sauce); else

            if (category.getId().equals("101"))
                image.setImageResource(R.drawable.fruits); else

            if (category.getId().equals("105"))
                image.setImageResource(R.drawable.tea); else

            if (category.getId().equals("104"))
                image.setImageResource(R.drawable.something);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }
}
