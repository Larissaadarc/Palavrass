package br.edu.ifsp.dmo.palavras;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.palavras.R;

public class DetalhesActivity extends AppCompatActivity {
    private String letra;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        if (getIntent().hasExtra(Constants.LETRA_ID)) {
            letra = getIntent().getStringExtra(Constants.LETRA_ID);
        }

        letra = "a";
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null){
            actionBar.setDisplayHomeAsUpEnabled(true);

            actionBar.setTitle("Palavras com: " + letra.toUpperCase());
        }
        recyclerView = findViewById(R.id.recyclerview_palavras);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PalavrasAdapter(this, letra));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}