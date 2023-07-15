package com.android.goeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
public class BooksList extends AppCompatActivity {
    RecyclerView recyclerView;
    TextView textView;
    List<Book> bookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        recyclerView = findViewById(R.id.books_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(BooksList.this));
        Bundle bundle = getIntent().getExtras();
        String category = bundle.getString("cat");
        bookList = new ArrayList<>();
        if (category.equals("Dystopian")) {
            bookList.add(new Book("Delirium","Lauren Oliver", R.drawable.delirium, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Delirium.pdf?alt=media&token=fb432fa0-7971-4358-8022-4114ab4f4e1c"));
            bookList.add(new Book("Pandemonium","Tamal Bandyopadhyay", R.drawable.pandemonium, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Pandemonium.pdf?alt=media&token=f2b55168-0891-43a0-8c1d-b729aaad877f"));
            bookList.add(new Book("Requiem","Lauren Oliver", R.drawable.requiem, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Requiem.pdf?alt=media&token=47f2cb05-09d9-4a25-8e9b-883a828dff92"));
            bookList.add(new Book("Divergent","Veronica roth", R.drawable.divergent, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Divergent.pdf?alt=media&token=c0322150-e17c-48c8-ba1b-52618c1c3349"));
            bookList.add(new Book("Insurgent","Veronica roth", R.drawable.insurgent, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Insurgent.pdf?alt=media&token=c17c1d3e-6c60-4624-b9fe-10c8c0a8fa55"));
            bookList.add(new Book("Allegiant","Veronica roth", R.drawable.allegiant, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Allegiant.pdf?alt=media&token=6c96851c-d652-4ef1-b166-e9e2dea499a9"));
            bookList.add(new Book("Hunger Games","Suzanne Collins", R.drawable.hunger_games, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Hunger%20Games.pdf?alt=media&token=47ef546a-f0f7-4922-9b06-fa4b9ecd90d9"));
            bookList.add(new Book("Catching Fire","Suzanne Collins", R.drawable.catching_fire, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Catching%20Fire.pdf?alt=media&token=fa008ada-a961-42c8-b366-ffb2a29709f6"));
            bookList.add(new Book("Mockingjay","Suzanne Collins", R.drawable.mockingjay, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Mockingjay.pdf?alt=media&token=9a352701-ae42-4ad4-8832-1642fef39514"));
            bookList.add(new Book("The Ballad of Songbirds and snakes","Suzanne Collins", R.drawable.the_ballad_of_songbirds_and_snakes, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2FThe%20Ballad%20of%20Songbirds%20and%20Snakes%20by%20Suzanne%20Collins.pdf?alt=media&token=7880cece-2fcc-40bc-a3ec-a81a48603044"));
            bookList.add(new Book("Matched","Ally Condie", R.drawable.matched, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Matched.pdf?alt=media&token=0de002f0-dde1-40bb-8063-95fe00dde60b"));
            bookList.add(new Book("Crossed","Garth Ennis", R.drawable.crossed, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Crossed.pdf?alt=media&token=b320d2ba-1c86-4fc1-97cc-7e12ce03ca02"));
            bookList.add(new Book("Reached","Ally Condie", R.drawable.reached, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Reached.pdf?alt=media&token=43bce1d3-cbf8-4085-894a-93f4e60433f4"));
            ListAdapter adapter = new ListAdapter(this, bookList);
            recyclerView.setAdapter(adapter);
        }
        if (category.equals("Fantasy")) {
            bookList.add(new Book("The Sorcerer's Stone","J.K.Rowling", R.drawable.hp1, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F1.The%20Sorcerer's%20Stone.pdf?alt=media&token=5edf4d75-25b5-4e3a-91c3-2eb14785ec46"));
            bookList.add(new Book("The Chamber of Secrets","J.K.Rowling", R.drawable.hp2, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F2.The%20Chamber%20of%20Secrets.pdf?alt=media&token=702c2a03-a9bc-4d03-8988-94918bc17ce7"));
            bookList.add(new Book("The Prisoner of Azkaban","J.K.Rowling", R.drawable.hp3, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F3.The%20Prisoner%20Of%20Azkaban.pdf?alt=media&token=b2294ec1-b6a5-4bfa-a25f-983506ae2e46"));
            bookList.add(new Book("The Goblet of Fire","J.K.Rowling", R.drawable.hp4, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F4.%20The%20Goblet%20of%20Fire.pdf?alt=media&token=a94ec8ae-e39d-42d7-93f3-599cfde169e0"));
            bookList.add(new Book("The Order of the Phoenix","J.K.Rowling", R.drawable.hp5, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F5.%20The%20Order%20of%20the%20Phoenix.pdf?alt=media&token=e3e58e19-89b2-499a-9c0b-204a4eba205e"));
            bookList.add(new Book("The Half Blood Prince","J.K.Rowling", R.drawable.hp6, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F6.The%20Half%20Blood%20Prince.pdf?alt=media&token=d80037a1-8e7e-4941-ba2d-cbf100477c9a"));
            bookList.add(new Book("The Deathly Hallows","J.K.Rowling", R.drawable.hp7, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F7.%20The%20Deathly%20Hallows.pdf?alt=media&token=96c8512f-9e3a-4f05-8d26-cb6ce37db3c0"));
            bookList.add(new Book("HarryPotter and the cursed child","J.K.Rowling", R.drawable.cursed_child, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FHarry-Potter-and-the-Cursed-Child.pdf?alt=media&token=60f120ff-cbf1-4cb8-841f-0accf3c91cf9"));
            bookList.add(new Book("Alice in Wonderland","Lewis Carrol", R.drawable.alice_in_wonderland, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FAlice%20in%20Wonderland-Lewis%20Carroll.pdf?alt=media&token=ec5cfda0-8505-4d0d-b61b-7220dd2c5aa8"));
            bookList.add(new Book("Enchantment of Ravens","Margaret Rogerson", R.drawable.enchantment_of_ravens, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FAn%20Enchantment%20of%20Ravens-Margaret%20Rogerson.pdf?alt=media&token=66e21e53-c146-434c-80e5-7482907ebcf1"));
            bookList.add(new Book("Sorcery of Thorns","Margaret Rogerson", R.drawable.sorcery_of_thorns, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FSorcery%20of%20Thorns-%20Margaret%20Rogerson.pdf?alt=media&token=dccf86bc-d8bd-4e32-a8f0-66ebe92af187"));
            bookList.add(new Book("Stardust","Neil Gaiman", R.drawable.stardust, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FStardust-Neil%20Gaiman.pdf?alt=media&token=ffd4955c-eb4d-4cd3-92c4-3b7cee01c34c"));
            bookList.add(new Book("The Magic Thief","Sarah Prineas", R.drawable.the_magic_thief_complete_collection, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FThe%20Magic%20Thief%20(Complete%20Collection)-Sarah%20Prineas.pdf?alt=media&token=4e2c2101-89de-4249-b63d-fb3b9eb4b29a"));
            bookList.add(new Book("The Starless Sea","Erin Morgenstern", R.drawable.starless_sea, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FThe%20Starless%20Sea-Erin%20Morgenstern.pdf?alt=media&token=e48fd14d-6bb3-48b7-b388-c34538fb7f52"));
            bookList.add(new Book("The Tales of Beedle the Bard","J.K.Rowling", R.drawable.tales_of_beedle_the_bard, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FThe%20Tales%20of%20Beedle%20the%20Bard%20by%20J%20K%20Rowling.pdf?alt=media&token=24d69cbb-94cc-442b-951f-b5c303a8f1d3"));
            ListAdapter adapter = new ListAdapter(this, bookList);
            recyclerView.setAdapter(adapter);
        }
        if (category.equals("Mystery")) {
            bookList.add(new Book("The Cuckoo's Calling","J.K.Rowling", R.drawable.cuckoo, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F1.The%20Cuckoo's%20Calling.pdf?alt=media&token=f0cf13b0-2a39-408c-97b0-4c85aafc10ac"));
            bookList.add(new Book("The Silkworm", "J.K.Rowling",R.drawable.silkworm, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F2.The%20Silkworm.pdf?alt=media&token=97396109-57f0-47e4-949e-4e9d637fa854"));
            bookList.add(new Book("Career of Evil","J.K.Rowling", R.drawable.career_of_evil, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F3.Career%20of%20Evil.pdf?alt=media&token=ce2de03e-8adf-4c43-bc0d-480cfce37a69"));
            bookList.add(new Book("Lethal White","J.K.Rowling" ,R.drawable.lethal_white, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F4.Lethal%20White.pdf?alt=media&token=547d90da-cdac-477c-b114-9a222fe15cb5"));
            bookList.add(new Book("Troubled Blood","J.K.Rowling", R.drawable.troubled_blood, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F5.Troubled%20Blood.pdf?alt=media&token=e3ea9385-e0ab-4988-818e-bf03469cf514"));
            bookList.add(new Book("Seven Days","Alex Lake", R.drawable.seven_days, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2FFAMOUS%20FIVE%20COMPLETE%20SERIES.pdf?alt=media&token=3c5426bf-c60e-4e88-bc03-f67a999e7910"));
            bookList.add(new Book("Famous Five","Enid Blyton", R.drawable.famous_five, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2FSeven%20Days-Alex%20Lake.pdf?alt=media&token=6d671223-b10d-4877-8389-7dace52ab535"));
            ListAdapter adapter = new ListAdapter(this, bookList);
            recyclerView.setAdapter(adapter);
        }
        if (category.equals("Romance")) {
            bookList.add(new Book("Delirium","Lauren Oliver", R.drawable.delirium, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Delirium.pdf?alt=media&token=fb432fa0-7971-4358-8022-4114ab4f4e1c"));
            bookList.add(new Book("Pandemonium","Tamal Bandyopadhyay", R.drawable.pandemonium, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Pandemonium.pdf?alt=media&token=f2b55168-0891-43a0-8c1d-b729aaad877f"));
            bookList.add(new Book("Requiem","Lauren Oliver", R.drawable.requiem, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Requiem.pdf?alt=media&token=47f2cb05-09d9-4a25-8e9b-883a828dff92"));
            bookList.add(new Book("Divergent","Veronica roth", R.drawable.divergent, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Divergent.pdf?alt=media&token=c0322150-e17c-48c8-ba1b-52618c1c3349"));
            bookList.add(new Book("Insurgent","Veronica roth", R.drawable.insurgent, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Insurgent.pdf?alt=media&token=c17c1d3e-6c60-4624-b9fe-10c8c0a8fa55"));
            bookList.add(new Book("Allegiant","Veronica roth", R.drawable.allegiant, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Allegiant.pdf?alt=media&token=6c96851c-d652-4ef1-b166-e9e2dea499a9"));
            bookList.add(new Book("Hunger Games","Suzanne Collins", R.drawable.hunger_games, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Hunger%20Games.pdf?alt=media&token=47ef546a-f0f7-4922-9b06-fa4b9ecd90d9"));
            bookList.add(new Book("Catching Fire","Suzanne Collins", R.drawable.catching_fire, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Catching%20Fire.pdf?alt=media&token=fa008ada-a961-42c8-b366-ffb2a29709f6"));
            bookList.add(new Book("Mockingjay","Suzanne Collins", R.drawable.mockingjay, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Mockingjay.pdf?alt=media&token=9a352701-ae42-4ad4-8832-1642fef39514"));
            bookList.add(new Book("The Ballad of Songbirds and snakes","Suzanne Collins", R.drawable.the_ballad_of_songbirds_and_snakes, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2FThe%20Ballad%20of%20Songbirds%20and%20Snakes%20by%20Suzanne%20Collins.pdf?alt=media&token=7880cece-2fcc-40bc-a3ec-a81a48603044"));
            bookList.add(new Book("Matched","Ally Condie", R.drawable.matched, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Matched.pdf?alt=media&token=0de002f0-dde1-40bb-8063-95fe00dde60b"));
            bookList.add(new Book("Crossed","Garth Ennis", R.drawable.crossed, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Crossed.pdf?alt=media&token=b320d2ba-1c86-4fc1-97cc-7e12ce03ca02"));
            bookList.add(new Book("Reached","Ally Condie", R.drawable.reached, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Reached.pdf?alt=media&token=43bce1d3-cbf8-4085-894a-93f4e60433f4"));
            ListAdapter adapter = new ListAdapter(this, bookList);
            recyclerView.setAdapter(adapter);
        }
        if (category.equals("Science Fiction")) {
            bookList.add(new Book("The Sorcerer's Stone","J.K.Rowling", R.drawable.hp1, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F1.The%20Sorcerer's%20Stone.pdf?alt=media&token=5edf4d75-25b5-4e3a-91c3-2eb14785ec46"));
            bookList.add(new Book("The Chamber of Secrets","J.K.Rowling", R.drawable.hp2, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F2.The%20Chamber%20of%20Secrets.pdf?alt=media&token=702c2a03-a9bc-4d03-8988-94918bc17ce7"));
            bookList.add(new Book("The Prisoner of Azkaban","J.K.Rowling", R.drawable.hp3, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F3.The%20Prisoner%20Of%20Azkaban.pdf?alt=media&token=b2294ec1-b6a5-4bfa-a25f-983506ae2e46"));
            bookList.add(new Book("The Goblet of Fire","J.K.Rowling", R.drawable.hp4, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F4.%20The%20Goblet%20of%20Fire.pdf?alt=media&token=a94ec8ae-e39d-42d7-93f3-599cfde169e0"));
            bookList.add(new Book("The Order of the Phoenix","J.K.Rowling", R.drawable.hp5, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F5.%20The%20Order%20of%20the%20Phoenix.pdf?alt=media&token=e3e58e19-89b2-499a-9c0b-204a4eba205e"));
            bookList.add(new Book("The Half Blood Prince","J.K.Rowling", R.drawable.hp6, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F6.The%20Half%20Blood%20Prince.pdf?alt=media&token=d80037a1-8e7e-4941-ba2d-cbf100477c9a"));
            bookList.add(new Book("The Deathly Hallows","J.K.Rowling", R.drawable.hp7, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F7.%20The%20Deathly%20Hallows.pdf?alt=media&token=96c8512f-9e3a-4f05-8d26-cb6ce37db3c0"));
            bookList.add(new Book("HarryPotter and the cursed child","J.K.Rowling", R.drawable.cursed_child, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FHarry-Potter-and-the-Cursed-Child.pdf?alt=media&token=60f120ff-cbf1-4cb8-841f-0accf3c91cf9"));
            bookList.add(new Book("Alice in Wonderland","Lewis Carrol", R.drawable.alice_in_wonderland, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FAlice%20in%20Wonderland-Lewis%20Carroll.pdf?alt=media&token=ec5cfda0-8505-4d0d-b61b-7220dd2c5aa8"));
            bookList.add(new Book("Enchantment of Ravens","Margaret Rogerson", R.drawable.enchantment_of_ravens, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FAn%20Enchantment%20of%20Ravens-Margaret%20Rogerson.pdf?alt=media&token=66e21e53-c146-434c-80e5-7482907ebcf1"));
            bookList.add(new Book("Sorcery of Thorns","Margaret Rogerson", R.drawable.sorcery_of_thorns, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FSorcery%20of%20Thorns-%20Margaret%20Rogerson.pdf?alt=media&token=dccf86bc-d8bd-4e32-a8f0-66ebe92af187"));
            bookList.add(new Book("Stardust","Neil Gaiman", R.drawable.stardust, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FStardust-Neil%20Gaiman.pdf?alt=media&token=ffd4955c-eb4d-4cd3-92c4-3b7cee01c34c"));
            bookList.add(new Book("The Magic Thief","Sarah Prineas", R.drawable.the_magic_thief_complete_collection, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FThe%20Magic%20Thief%20(Complete%20Collection)-Sarah%20Prineas.pdf?alt=media&token=4e2c2101-89de-4249-b63d-fb3b9eb4b29a"));
            bookList.add(new Book("The Starless Sea","Erin Morgenstern", R.drawable.starless_sea, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FThe%20Starless%20Sea-Erin%20Morgenstern.pdf?alt=media&token=e48fd14d-6bb3-48b7-b388-c34538fb7f52"));
            bookList.add(new Book("The Tales of Beedle the Bard","J.K.Rowling", R.drawable.tales_of_beedle_the_bard, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FThe%20Tales%20of%20Beedle%20the%20Bard%20by%20J%20K%20Rowling.pdf?alt=media&token=24d69cbb-94cc-442b-951f-b5c303a8f1d3"));
            ListAdapter adapter = new ListAdapter(this, bookList);
            recyclerView.setAdapter(adapter);
        }
        if (category.equals("Young Adult")) {
            bookList.add(new Book("The Cuckoo's Calling","J.K.Rowling", R.drawable.cuckoo, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F1.The%20Cuckoo's%20Calling.pdf?alt=media&token=f0cf13b0-2a39-408c-97b0-4c85aafc10ac"));
            bookList.add(new Book("The Silkworm", "J.K.Rowling",R.drawable.silkworm, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F2.The%20Silkworm.pdf?alt=media&token=97396109-57f0-47e4-949e-4e9d637fa854"));
            bookList.add(new Book("Career of Evil","J.K.Rowling", R.drawable.career_of_evil, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F3.Career%20of%20Evil.pdf?alt=media&token=ce2de03e-8adf-4c43-bc0d-480cfce37a69"));
            bookList.add(new Book("Lethal White","J.K.Rowling" ,R.drawable.lethal_white, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F4.Lethal%20White.pdf?alt=media&token=547d90da-cdac-477c-b114-9a222fe15cb5"));
            bookList.add(new Book("Troubled Blood","J.K.Rowling", R.drawable.troubled_blood, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F5.Troubled%20Blood.pdf?alt=media&token=e3ea9385-e0ab-4988-818e-bf03469cf514"));
            bookList.add(new Book("Seven Days","Alex Lake", R.drawable.seven_days, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2FFAMOUS%20FIVE%20COMPLETE%20SERIES.pdf?alt=media&token=3c5426bf-c60e-4e88-bc03-f67a999e7910"));
            bookList.add(new Book("Famous Five","Enid Blyton", R.drawable.famous_five, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2FSeven%20Days-Alex%20Lake.pdf?alt=media&token=6d671223-b10d-4877-8389-7dace52ab535"));
            ListAdapter adapter = new ListAdapter(this, bookList);
            recyclerView.setAdapter(adapter);
        }
        if (category.equals("Ghost")) {
            bookList.add(new Book("Delirium","Lauren Oliver", R.drawable.delirium, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Delirium.pdf?alt=media&token=fb432fa0-7971-4358-8022-4114ab4f4e1c"));
            bookList.add(new Book("Pandemonium","Tamal Bandyopadhyay", R.drawable.pandemonium, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Pandemonium.pdf?alt=media&token=f2b55168-0891-43a0-8c1d-b729aaad877f"));
            bookList.add(new Book("Requiem","Lauren Oliver", R.drawable.requiem, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Requiem.pdf?alt=media&token=47f2cb05-09d9-4a25-8e9b-883a828dff92"));
            bookList.add(new Book("Divergent","Veronica roth", R.drawable.divergent, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Divergent.pdf?alt=media&token=c0322150-e17c-48c8-ba1b-52618c1c3349"));
            bookList.add(new Book("Insurgent","Veronica roth", R.drawable.insurgent, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Insurgent.pdf?alt=media&token=c17c1d3e-6c60-4624-b9fe-10c8c0a8fa55"));
            bookList.add(new Book("Allegiant","Veronica roth", R.drawable.allegiant, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Allegiant.pdf?alt=media&token=6c96851c-d652-4ef1-b166-e9e2dea499a9"));
            bookList.add(new Book("Hunger Games","Suzanne Collins", R.drawable.hunger_games, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Hunger%20Games.pdf?alt=media&token=47ef546a-f0f7-4922-9b06-fa4b9ecd90d9"));
            bookList.add(new Book("Catching Fire","Suzanne Collins", R.drawable.catching_fire, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Catching%20Fire.pdf?alt=media&token=fa008ada-a961-42c8-b366-ffb2a29709f6"));
            bookList.add(new Book("Mockingjay","Suzanne Collins", R.drawable.mockingjay, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Mockingjay.pdf?alt=media&token=9a352701-ae42-4ad4-8832-1642fef39514"));
            bookList.add(new Book("The Ballad of Songbirds and snakes","Suzanne Collins", R.drawable.the_ballad_of_songbirds_and_snakes, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2FThe%20Ballad%20of%20Songbirds%20and%20Snakes%20by%20Suzanne%20Collins.pdf?alt=media&token=7880cece-2fcc-40bc-a3ec-a81a48603044"));
            bookList.add(new Book("Matched","Ally Condie", R.drawable.matched, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Matched.pdf?alt=media&token=0de002f0-dde1-40bb-8063-95fe00dde60b"));
            bookList.add(new Book("Crossed","Garth Ennis", R.drawable.crossed, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Crossed.pdf?alt=media&token=b320d2ba-1c86-4fc1-97cc-7e12ce03ca02"));
            bookList.add(new Book("Reached","Ally Condie", R.drawable.reached, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Reached.pdf?alt=media&token=43bce1d3-cbf8-4085-894a-93f4e60433f4"));
            ListAdapter adapter = new ListAdapter(this, bookList);
            recyclerView.setAdapter(adapter);
        }
        if (category.equals("History")) {
            bookList.add(new Book("The Sorcerer's Stone","J.K.Rowling", R.drawable.hp1, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F1.The%20Sorcerer's%20Stone.pdf?alt=media&token=5edf4d75-25b5-4e3a-91c3-2eb14785ec46"));
            bookList.add(new Book("The Chamber of Secrets","J.K.Rowling", R.drawable.hp2, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F2.The%20Chamber%20of%20Secrets.pdf?alt=media&token=702c2a03-a9bc-4d03-8988-94918bc17ce7"));
            bookList.add(new Book("The Prisoner of Azkaban","J.K.Rowling", R.drawable.hp3, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F3.The%20Prisoner%20Of%20Azkaban.pdf?alt=media&token=b2294ec1-b6a5-4bfa-a25f-983506ae2e46"));
            bookList.add(new Book("The Goblet of Fire","J.K.Rowling", R.drawable.hp4, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F4.%20The%20Goblet%20of%20Fire.pdf?alt=media&token=a94ec8ae-e39d-42d7-93f3-599cfde169e0"));
            bookList.add(new Book("The Order of the Phoenix","J.K.Rowling", R.drawable.hp5, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F5.%20The%20Order%20of%20the%20Phoenix.pdf?alt=media&token=e3e58e19-89b2-499a-9c0b-204a4eba205e"));
            bookList.add(new Book("The Half Blood Prince","J.K.Rowling", R.drawable.hp6, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F6.The%20Half%20Blood%20Prince.pdf?alt=media&token=d80037a1-8e7e-4941-ba2d-cbf100477c9a"));
            bookList.add(new Book("The Deathly Hallows","J.K.Rowling", R.drawable.hp7, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F7.%20The%20Deathly%20Hallows.pdf?alt=media&token=96c8512f-9e3a-4f05-8d26-cb6ce37db3c0"));
            bookList.add(new Book("HarryPotter and the cursed child","J.K.Rowling", R.drawable.cursed_child, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FHarry-Potter-and-the-Cursed-Child.pdf?alt=media&token=60f120ff-cbf1-4cb8-841f-0accf3c91cf9"));
            bookList.add(new Book("Alice in Wonderland","Lewis Carrol", R.drawable.alice_in_wonderland, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FAlice%20in%20Wonderland-Lewis%20Carroll.pdf?alt=media&token=ec5cfda0-8505-4d0d-b61b-7220dd2c5aa8"));
            bookList.add(new Book("Enchantment of Ravens","Margaret Rogerson", R.drawable.enchantment_of_ravens, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FAn%20Enchantment%20of%20Ravens-Margaret%20Rogerson.pdf?alt=media&token=66e21e53-c146-434c-80e5-7482907ebcf1"));
            bookList.add(new Book("Sorcery of Thorns","Margaret Rogerson", R.drawable.sorcery_of_thorns, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FSorcery%20of%20Thorns-%20Margaret%20Rogerson.pdf?alt=media&token=dccf86bc-d8bd-4e32-a8f0-66ebe92af187"));
            bookList.add(new Book("Stardust","Neil Gaiman", R.drawable.stardust, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FStardust-Neil%20Gaiman.pdf?alt=media&token=ffd4955c-eb4d-4cd3-92c4-3b7cee01c34c"));
            bookList.add(new Book("The Magic Thief","Sarah Prineas", R.drawable.the_magic_thief_complete_collection, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FThe%20Magic%20Thief%20(Complete%20Collection)-Sarah%20Prineas.pdf?alt=media&token=4e2c2101-89de-4249-b63d-fb3b9eb4b29a"));
            bookList.add(new Book("The Starless Sea","Erin Morgenstern", R.drawable.starless_sea, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FThe%20Starless%20Sea-Erin%20Morgenstern.pdf?alt=media&token=e48fd14d-6bb3-48b7-b388-c34538fb7f52"));
            bookList.add(new Book("The Tales of Beedle the Bard","J.K.Rowling", R.drawable.tales_of_beedle_the_bard, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FThe%20Tales%20of%20Beedle%20the%20Bard%20by%20J%20K%20Rowling.pdf?alt=media&token=24d69cbb-94cc-442b-951f-b5c303a8f1d3"));
            ListAdapter adapter = new ListAdapter(this, bookList);
            recyclerView.setAdapter(adapter);
        }
        if (category.equals("Philosophy")) {
            bookList.add(new Book("The Cuckoo's Calling","J.K.Rowling", R.drawable.cuckoo, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F1.The%20Cuckoo's%20Calling.pdf?alt=media&token=f0cf13b0-2a39-408c-97b0-4c85aafc10ac"));
            bookList.add(new Book("The Silkworm", "J.K.Rowling",R.drawable.silkworm, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F2.The%20Silkworm.pdf?alt=media&token=97396109-57f0-47e4-949e-4e9d637fa854"));
            bookList.add(new Book("Career of Evil","J.K.Rowling", R.drawable.career_of_evil, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F3.Career%20of%20Evil.pdf?alt=media&token=ce2de03e-8adf-4c43-bc0d-480cfce37a69"));
            bookList.add(new Book("Lethal White","J.K.Rowling" ,R.drawable.lethal_white, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F4.Lethal%20White.pdf?alt=media&token=547d90da-cdac-477c-b114-9a222fe15cb5"));
            bookList.add(new Book("Troubled Blood","J.K.Rowling", R.drawable.troubled_blood, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F5.Troubled%20Blood.pdf?alt=media&token=e3ea9385-e0ab-4988-818e-bf03469cf514"));
            bookList.add(new Book("Seven Days","Alex Lake", R.drawable.seven_days, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2FFAMOUS%20FIVE%20COMPLETE%20SERIES.pdf?alt=media&token=3c5426bf-c60e-4e88-bc03-f67a999e7910"));
            bookList.add(new Book("Famous Five","Enid Blyton", R.drawable.famous_five, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2FSeven%20Days-Alex%20Lake.pdf?alt=media&token=6d671223-b10d-4877-8389-7dace52ab535"));
            ListAdapter adapter = new ListAdapter(this, bookList);
            recyclerView.setAdapter(adapter);
        }
        if (category.equals("Poetry")) {
            bookList.add(new Book("Delirium","Lauren Oliver", R.drawable.delirium, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Delirium.pdf?alt=media&token=fb432fa0-7971-4358-8022-4114ab4f4e1c"));
            bookList.add(new Book("Pandemonium","Tamal Bandyopadhyay", R.drawable.pandemonium, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Pandemonium.pdf?alt=media&token=f2b55168-0891-43a0-8c1d-b729aaad877f"));
            bookList.add(new Book("Requiem","Lauren Oliver", R.drawable.requiem, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Requiem.pdf?alt=media&token=47f2cb05-09d9-4a25-8e9b-883a828dff92"));
            bookList.add(new Book("Divergent","Veronica roth", R.drawable.divergent, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Divergent.pdf?alt=media&token=c0322150-e17c-48c8-ba1b-52618c1c3349"));
            bookList.add(new Book("Insurgent","Veronica roth", R.drawable.insurgent, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Insurgent.pdf?alt=media&token=c17c1d3e-6c60-4624-b9fe-10c8c0a8fa55"));
            bookList.add(new Book("Allegiant","Veronica roth", R.drawable.allegiant, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Allegiant.pdf?alt=media&token=6c96851c-d652-4ef1-b166-e9e2dea499a9"));
            bookList.add(new Book("Hunger Games","Suzanne Collins", R.drawable.hunger_games, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Hunger%20Games.pdf?alt=media&token=47ef546a-f0f7-4922-9b06-fa4b9ecd90d9"));
            bookList.add(new Book("Catching Fire","Suzanne Collins", R.drawable.catching_fire, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Catching%20Fire.pdf?alt=media&token=fa008ada-a961-42c8-b366-ffb2a29709f6"));
            bookList.add(new Book("Mockingjay","Suzanne Collins", R.drawable.mockingjay, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Mockingjay.pdf?alt=media&token=9a352701-ae42-4ad4-8832-1642fef39514"));
            bookList.add(new Book("The Ballad of Songbirds and snakes","Suzanne Collins", R.drawable.the_ballad_of_songbirds_and_snakes, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2FThe%20Ballad%20of%20Songbirds%20and%20Snakes%20by%20Suzanne%20Collins.pdf?alt=media&token=7880cece-2fcc-40bc-a3ec-a81a48603044"));
            bookList.add(new Book("Matched","Ally Condie", R.drawable.matched, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F1.Matched.pdf?alt=media&token=0de002f0-dde1-40bb-8063-95fe00dde60b"));
            bookList.add(new Book("Crossed","Garth Ennis", R.drawable.crossed, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F2.Crossed.pdf?alt=media&token=b320d2ba-1c86-4fc1-97cc-7e12ce03ca02"));
            bookList.add(new Book("Reached","Ally Condie", R.drawable.reached, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Dystopian%2F3.Reached.pdf?alt=media&token=43bce1d3-cbf8-4085-894a-93f4e60433f4"));
            ListAdapter adapter = new ListAdapter(this, bookList);
            recyclerView.setAdapter(adapter);
        }
        if (category.equals("Epic")) {
            bookList.add(new Book("The Sorcerer's Stone","J.K.Rowling", R.drawable.hp1, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F1.The%20Sorcerer's%20Stone.pdf?alt=media&token=5edf4d75-25b5-4e3a-91c3-2eb14785ec46"));
            bookList.add(new Book("The Chamber of Secrets","J.K.Rowling", R.drawable.hp2, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F2.The%20Chamber%20of%20Secrets.pdf?alt=media&token=702c2a03-a9bc-4d03-8988-94918bc17ce7"));
            bookList.add(new Book("The Prisoner of Azkaban","J.K.Rowling", R.drawable.hp3, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F3.The%20Prisoner%20Of%20Azkaban.pdf?alt=media&token=b2294ec1-b6a5-4bfa-a25f-983506ae2e46"));
            bookList.add(new Book("The Goblet of Fire","J.K.Rowling", R.drawable.hp4, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F4.%20The%20Goblet%20of%20Fire.pdf?alt=media&token=a94ec8ae-e39d-42d7-93f3-599cfde169e0"));
            bookList.add(new Book("The Order of the Phoenix","J.K.Rowling", R.drawable.hp5, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F5.%20The%20Order%20of%20the%20Phoenix.pdf?alt=media&token=e3e58e19-89b2-499a-9c0b-204a4eba205e"));
            bookList.add(new Book("The Half Blood Prince","J.K.Rowling", R.drawable.hp6, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F6.The%20Half%20Blood%20Prince.pdf?alt=media&token=d80037a1-8e7e-4941-ba2d-cbf100477c9a"));
            bookList.add(new Book("The Deathly Hallows","J.K.Rowling", R.drawable.hp7, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2F7.%20The%20Deathly%20Hallows.pdf?alt=media&token=96c8512f-9e3a-4f05-8d26-cb6ce37db3c0"));
            bookList.add(new Book("HarryPotter and the cursed child","J.K.Rowling", R.drawable.cursed_child, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FHarry-Potter-and-the-Cursed-Child.pdf?alt=media&token=60f120ff-cbf1-4cb8-841f-0accf3c91cf9"));
            bookList.add(new Book("Alice in Wonderland","Lewis Carrol", R.drawable.alice_in_wonderland, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FAlice%20in%20Wonderland-Lewis%20Carroll.pdf?alt=media&token=ec5cfda0-8505-4d0d-b61b-7220dd2c5aa8"));
            bookList.add(new Book("Enchantment of Ravens","Margaret Rogerson", R.drawable.enchantment_of_ravens, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FAn%20Enchantment%20of%20Ravens-Margaret%20Rogerson.pdf?alt=media&token=66e21e53-c146-434c-80e5-7482907ebcf1"));
            bookList.add(new Book("Sorcery of Thorns","Margaret Rogerson", R.drawable.sorcery_of_thorns, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FSorcery%20of%20Thorns-%20Margaret%20Rogerson.pdf?alt=media&token=dccf86bc-d8bd-4e32-a8f0-66ebe92af187"));
            bookList.add(new Book("Stardust","Neil Gaiman", R.drawable.stardust, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FStardust-Neil%20Gaiman.pdf?alt=media&token=ffd4955c-eb4d-4cd3-92c4-3b7cee01c34c"));
            bookList.add(new Book("The Magic Thief","Sarah Prineas", R.drawable.the_magic_thief_complete_collection, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FThe%20Magic%20Thief%20(Complete%20Collection)-Sarah%20Prineas.pdf?alt=media&token=4e2c2101-89de-4249-b63d-fb3b9eb4b29a"));
            bookList.add(new Book("The Starless Sea","Erin Morgenstern", R.drawable.starless_sea, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FThe%20Starless%20Sea-Erin%20Morgenstern.pdf?alt=media&token=e48fd14d-6bb3-48b7-b388-c34538fb7f52"));
            bookList.add(new Book("The Tales of Beedle the Bard","J.K.Rowling", R.drawable.tales_of_beedle_the_bard, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Fantasy%2FThe%20Tales%20of%20Beedle%20the%20Bard%20by%20J%20K%20Rowling.pdf?alt=media&token=24d69cbb-94cc-442b-951f-b5c303a8f1d3"));
            ListAdapter adapter = new ListAdapter(this, bookList);
            recyclerView.setAdapter(adapter);
        }
        if (category.equals("Adventure")) {
            bookList.add(new Book("The Cuckoo's Calling","J.K.Rowling", R.drawable.cuckoo, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F1.The%20Cuckoo's%20Calling.pdf?alt=media&token=f0cf13b0-2a39-408c-97b0-4c85aafc10ac"));
            bookList.add(new Book("The Silkworm", "J.K.Rowling",R.drawable.silkworm, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F2.The%20Silkworm.pdf?alt=media&token=97396109-57f0-47e4-949e-4e9d637fa854"));
            bookList.add(new Book("Career of Evil","J.K.Rowling", R.drawable.career_of_evil, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F3.Career%20of%20Evil.pdf?alt=media&token=ce2de03e-8adf-4c43-bc0d-480cfce37a69"));
            bookList.add(new Book("Lethal White","J.K.Rowling" ,R.drawable.lethal_white, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F4.Lethal%20White.pdf?alt=media&token=547d90da-cdac-477c-b114-9a222fe15cb5"));
            bookList.add(new Book("Troubled Blood","J.K.Rowling", R.drawable.troubled_blood, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2F5.Troubled%20Blood.pdf?alt=media&token=e3ea9385-e0ab-4988-818e-bf03469cf514"));
            bookList.add(new Book("Seven Days","Alex Lake", R.drawable.seven_days, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2FFAMOUS%20FIVE%20COMPLETE%20SERIES.pdf?alt=media&token=3c5426bf-c60e-4e88-bc03-f67a999e7910"));
            bookList.add(new Book("Famous Five","Enid Blyton", R.drawable.famous_five, "https://firebasestorage.googleapis.com/v0/b/janu-go-easy.appspot.com/o/Mystery%2FSeven%20Days-Alex%20Lake.pdf?alt=media&token=6d671223-b10d-4877-8389-7dace52ab535"));
            ListAdapter adapter = new ListAdapter(this, bookList);
            recyclerView.setAdapter(adapter);
        }
            textView = findViewById(R.id.back_to_categories);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(BooksList.this, Categories.class));
                }
            });
        }
    }