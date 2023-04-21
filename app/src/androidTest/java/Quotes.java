import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.Adapters.QuotesAdapter;
import com.example.quotes.R;

import java.util.ArrayList;

public class Quotes extends AppCompatActivity {

    NestedScrollView nestedScroll;

    RecyclerView rcvList;

    ArrayList<String> arrayList = new ArrayList<>();


    @SuppressLint("MissingInflateId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindi_quotes);

        rcvList = findViewById(R.id.rcvList);
        nestedScroll = findViewById(R.id.nestedScroll);

        for (int i = 0; i < Utils.Quotes.length; i++) {
            arrayList.add((Utils.Quotes[i]));
        }

        loadData();

    }

    private void loadData() {

        quotesClick click = new quotesClicl() {

            @Override
            public void getQuotes(String quotes) {


                Intent intent = new Intent(HindiQuotes.this, Quotes.class);
                intent.putExtra("quotes", quotes);
                startActivity(intent);

            }

        };

    }

    RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
    QuotesAdapter adapter = new QuotesAdapter(arrayList, click);
    rcvList.setLayoutManager(manager);
    rcvList.setAdapter(adapter);



}

