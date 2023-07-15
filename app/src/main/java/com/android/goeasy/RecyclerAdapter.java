package com.android.goeasy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.BookViewHolder> {

    private ArrayList<String> booksNamesList ;
    private ArrayList<String> authorsList;
    private ArrayList<Integer> booksImagesList ;
    private Context context;

    public RecyclerAdapter(ArrayList<String> booksNamesList, ArrayList<String> authorsList, ArrayList<Integer> booksImagesList, Context context) {
        this.booksNamesList = booksNamesList;
        this.authorsList = authorsList;
        this.booksImagesList = booksImagesList;
        this.context = context;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {

        holder.boookName.setText(booksNamesList.get(position));
        holder.authorName.setText(authorsList.get(position));
        holder.imageView.setImageResource(booksImagesList.get(position));
    }

    @Override
    public int getItemCount() {
        return booksImagesList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        private TextView boookName,authorName;
        private ImageView imageView;
        CardView cardView;
         public BookViewHolder(@NonNull View itemView) {
             super(itemView);
             cardView=itemView.findViewById(R.id.cardview_imageview);
             boookName = itemView.findViewById(R.id.text1);
             authorName = itemView.findViewById(R.id.text2);
             imageView = itemView.findViewById(R.id.card_image1);
         }
     }
}
