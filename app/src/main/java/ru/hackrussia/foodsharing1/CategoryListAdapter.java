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

        public void bind(Category ad) {
            title.setText(ad.getTitle());
            itemView.setOnClickListener(this);

            if (ad.getTitle().equals("Хлебобулочные изделия"))
            image.setImageResource(R.drawable.bread); else

            if (ad.getTitle().equals("Кондитерские изделия"))
                image.setImageResource(R.drawable.candy); else

            if (ad.getTitle().equals("Напитки"))
                image.setImageResource(R.drawable.drinks); else

            if (ad.getTitle().equals("Замороженные продукты"))
                image.setImageResource(R.drawable.frozen); else

            if (ad.getTitle().equals("Бакалея"))
                image.setImageResource(R.drawable.grocery); else

            if (ad.getTitle().equals("Молочные продукты"))
                image.setImageResource(R.drawable.milk); else

            if (ad.getTitle().equals("Консервы"))
                image.setImageResource(R.drawable.tins); else

            if (ad.getTitle().equals("Соусы"))
                image.setImageResource(R.drawable.sauce); else

            if (ad.getTitle().equals("Полуфабрикаты"))
                image.setImageResource(R.drawable.ready); else

            if (ad.getTitle().equals("Фрукты и овощи"))
                image.setImageResource(R.drawable.fruits); else

            if (ad.getTitle().equals("Чай и кофе"))
                image.setImageResource(R.drawable.tea); else

            if (ad.getTitle().equals("Прочее"))
                image.setImageResource(R.drawable.something);

        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }
}
