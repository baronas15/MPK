package lt.mpk.mpk.activities;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lt.mpk.mpk.R;
import lt.mpk.mpk.app;

public class activity1_5 extends AppCompatActivity {
    //private List<Card> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1_5);

        MediaPlayer mp = MediaPlayer.create(this, R.raw.antras);
        mp.start();
    }
/*
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);

        createData();
        RVAdapter adapter = new RVAdapter(cards);
        rv.setAdapter(adapter);
    }

    public static class RVAdapter extends RecyclerView.Adapter<RVAdapter.RecyclerViewHolder>{
        List<Card> cards;

        RVAdapter(List<Card> cards){
            this.cards = cards;
        }
        public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
            RecyclerView rv;
            TextView cardTitle;
            TextView cardText;

            public RecyclerViewHolder(View itemView) {
                super(itemView);
                rv = (RecyclerView)itemView.findViewById(R.id.rv);
                cardTitle = (TextView)itemView.findViewById(R.id.cardTitle);
                cardText = (TextView)itemView.findViewById(R.id.cardText);
            }
        }
        @Override
        public int getItemCount() {
            return cards.size();
        }
        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
            RecyclerViewHolder cvh = new RecyclerViewHolder(v);
            return cvh;
        }
        @Override
        public void onBindViewHolder(RecyclerViewHolder cardViewHolder, int i) {
            cardViewHolder.cardTitle.setText(cards.get(i).title);
            cardViewHolder.cardText.setText(cards.get(i).text);
        }
        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }
    }

    private void createData(){
        cards = new ArrayList<>();

        cards.add(new Card("Meditacija1","Meditacijos aprasymas Meditacijos aprasymas Meditacijos aprasymas Meditacijos aprasymas",1));
        cards.add(new Card("Meditacija2","Meditacijos aprasymas Meditacijos aprasymas Meditacijos aprasymas Meditacijos aprasymas",2));
    }

    class Card {
        String title;
        String text;
        int id;

        Card(String title, String text, int id){
            this.title = title;
            this.text = text;
            this.id = id;
        }
    }*/
}
