package com.android.goeasy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Listviewholder> {

    private Context context;
    private List<Book> bookList;

    public ListAdapter(@NonNull Context context,List<Book> bookList ) {
        this.context = context;
        this.bookList=bookList;
    }
    @NonNull
    @Override
    public Listviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_item, null);
        return new Listviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Listviewholder holder, @SuppressLint("RecyclerView") int position) {
        final Book book = bookList.get(position);
        holder.textViewTitle.setText(book.getTitle());
        holder.textViewAuthor.setText(book.getAuthor());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(book.getImage()));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), BookView.class);
                i.putExtra("title",bookList.get(position).getTitle());
                i.putExtra("author",bookList.get(position).getAuthor());
                i.putExtra("Image",bookList.get(position).getImage());
                i.putExtra("link",bookList.get(position).getLink());
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class Listviewholder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        TextView textViewAuthor;
        ImageView imageView;
        CardView cardView;
        public Listviewholder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview_imageview);
            textViewTitle = itemView.findViewById(R.id.text1);
            textViewAuthor = itemView.findViewById(R.id.text2);
            imageView = itemView.findViewById(R.id.card_image1);
        }
    }
}


