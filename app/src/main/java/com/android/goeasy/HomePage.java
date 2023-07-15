package com.android.goeasy;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    SliderView sliderView;
    RecyclerView recyclerView;
    ImageView imageView,imageView2;
    HorizontalScrollView horizontalScrollView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    RelativeLayout relativeLayout;


    List<Book> bookList;
    CardView cardView;

    int[] sliderImages = {R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5};
    int[] books = {R.drawable.book1, R.drawable.book2, R.drawable.book3, R.drawable.book4,
            R.drawable.book5,R.drawable.book6, R.drawable.book7, R.drawable.book8};
    String[] booksnames = {"Percy Jackson and the Greek Heroes", "Glass Sword",
            "Days of Blood and Starlight","The Bane Chronicles",
            "Lord of Shadows","The Lost Hero",
            "The Battle of Labyrinth","Magnus chase and the Gods of Asgard"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        sliderView = findViewById(R.id.image_slider);
        imageView = findViewById(R.id.menu);
        imageView2 = findViewById(R.id.card_image1);
        SliderAdapter sliderAdapter = new SliderAdapter((sliderImages));
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.setScrollTimeInSec(3);
        sliderView.startAutoCycle();
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        cardView = findViewById(R.id.cardview_imageview);
        relativeLayout = findViewById(R.id.recycle_ralative);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Books");
        LinearLayout gallery = findViewById(R.id.gallery);
        LayoutInflater inflater = LayoutInflater.from(this);
        horizontalScrollView  = findViewById(R.id.horizontal);
        bookList = new ArrayList<>();
        for(int i=0;i<8;i++)
        {
            View view = inflater.inflate(R.layout.gallery_item,gallery,false);
            ImageView imageView = view.findViewById(R.id.galleryimageView);
            imageView.setImageResource(books[i]);
            TextView textView = view.findViewById(R.id.gallerytextview);
            textView.setText(booksnames[i]);
            gallery.addView(view);
        }
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(HomePage.this));
        registerForContextMenu(imageView);

        bookList.add(new Book("Lethal White","J.K.Rowling" ,R.drawable.lethal_white, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F4.Lethal%20White.pdf?alt=media&token=547d90da-cdac-477c-b114-9a222fe15cb5"));
        bookList.add(new Book("Troubled Blood","J.K.Rowling", R.drawable.troubled_blood, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F5.Troubled%20Blood.pdf?alt=media&token=e3ea9385-e0ab-4988-818e-bf03469cf514"));
        bookList.add(new Book("Seven Days","Alex Lake", R.drawable.seven_days, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2FFAMOUS%20FIVE%20COMPLETE%20SERIES.pdf?alt=media&token=3c5426bf-c60e-4e88-bc03-f67a999e7910"));
        bookList.add(new Book("The Half Blood Prince","J.K.Rowling", R.drawable.hp6, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F6.The%20Half%20Blood%20Prince.pdf?alt=media&token=d80037a1-8e7e-4941-ba2d-cbf100477c9a"));
        bookList.add(new Book("The Deathly Hallows","J.K.Rowling", R.drawable.hp7, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F7.%20The%20Deathly%20Hallows.pdf?alt=media&token=96c8512f-9e3a-4f05-8d26-cb6ce37db3c0"));
        bookList.add(new Book("HarryPotter and the cursed child","J.K.Rowling", R.drawable.cursed_child, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FHarry-Potter-and-the-Cursed-Child.pdf?alt=media&token=60f120ff-cbf1-4cb8-841f-0accf3c91cf9"));
        bookList.add(new Book("Alice in Wonderland","Lewis Carrol", R.drawable.alice_in_wonderland, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FAlice%20in%20Wonderland-Lewis%20Carroll.pdf?alt=media&token=ec5cfda0-8505-4d0d-b61b-7220dd2c5aa8"));
        bookList.add(new Book("Enchantment of Ravens","Margaret Rogerson", R.drawable.enchantment_of_ravens, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FAn%20Enchantment%20of%20Ravens-Margaret%20Rogerson.pdf?alt=media&token=66e21e53-c146-434c-80e5-7482907ebcf1"));
        bookList.add(new Book("Sorcery of Thorns","Margaret Rogerson", R.drawable.sorcery_of_thorns, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FSorcery%20of%20Thorns-%20Margaret%20Rogerson.pdf?alt=media&token=dccf86bc-d8bd-4e32-a8f0-66ebe92af187"));
        bookList.add(new Book("Stardust","Neil Gaiman", R.drawable.stardust, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FStardust-Neil%20Gaiman.pdf?alt=media&token=ffd4955c-eb4d-4cd3-92c4-3b7cee01c34c"));
        bookList.add(new Book("The Magic Thief","Sarah Prineas", R.drawable.the_magic_thief_complete_collection, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FThe%20Magic%20Thief%20(Complete%20Collection)-Sarah%20Prineas.pdf?alt=media&token=4e2c2101-89de-4249-b63d-fb3b9eb4b29a"));
        bookList.add(new Book("Delirium","Lauren Oliver", R.drawable.delirium, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Delirium.pdf?alt=media&token=fb432fa0-7971-4358-8022-4114ab4f4e1c"));
        bookList.add(new Book("Pandemonium","Tamal Bandyopadhyay", R.drawable.pandemonium, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Pandemonium.pdf?alt=media&token=f2b55168-0891-43a0-8c1d-b729aaad877f"));
        bookList.add(new Book("Requiem","Lauren Oliver", R.drawable.requiem, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Requiem.pdf?alt=media&token=47f2cb05-09d9-4a25-8e9b-883a828dff92"));
        bookList.add(new Book("Divergent","Veronica roth", R.drawable.divergent, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Divergent.pdf?alt=media&token=c0322150-e17c-48c8-ba1b-52618c1c3349"));
        bookList.add(new Book("Insurgent","Veronica roth", R.drawable.insurgent, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Insurgent.pdf?alt=media&token=c17c1d3e-6c60-4624-b9fe-10c8c0a8fa55"));
        bookList.add(new Book("Allegiant","Veronica roth", R.drawable.allegiant, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Allegiant.pdf?alt=media&token=6c96851c-d652-4ef1-b166-e9e2dea499a9"));
        bookList.add(new Book("Hunger Games","Suzanne Collins", R.drawable.hunger_games, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Hunger%20Games.pdf?alt=media&token=47ef546a-f0f7-4922-9b06-fa4b9ecd90d9"));
        bookList.add(new Book("Catching Fire","Suzanne Collins", R.drawable.catching_fire, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Catching%20Fire.pdf?alt=media&token=fa008ada-a961-42c8-b366-ffb2a29709f6"));
        bookList.add(new Book("Famous Five","Enid Blyton", R.drawable.famous_five, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2FSeven%20Days-Alex%20Lake.pdf?alt=media&token=6d671223-b10d-4877-8389-7dace52ab535"));
        ListAdapter adapter = new ListAdapter(this, bookList);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.homepage_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId())
       {
           case R.id.about:
               startActivity(new Intent(HomePage.this,About.class));
               return true;
           case R.id.feedback:
               startActivity(new Intent(HomePage.this,Feedback.class));
               return true;
           default:
               return super.onContextItemSelected(item);
       }
    }

    public void onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                startActivity(new Intent(HomePage.this, HomePage.class));
                break;
            case R.id.category:
                startActivity(new Intent(HomePage.this, Categories.class));
                break;
            case R.id.profile:
                startActivity(new Intent(HomePage.this, Profile.class));
                break;
        }
    }
}