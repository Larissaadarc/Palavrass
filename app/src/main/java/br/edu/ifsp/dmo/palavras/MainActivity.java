package br.edu.ifsp.dmo.palavras;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.palavras.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private boolean linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = false;
        recyclerView = findViewById(R.id.recyclerview_letras);
        recyclerView.setAdapter(new LetrasAdapter(this));
        alterarLayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem trocarLayoutButton = menu.findItem(R.id.Trocar_Layout);
        alterarIconeMenu(trocarLayoutButton);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.Trocar_Layout){
            alterarLayout();
            alterarIconeMenu(item);
        }
        return super.onOptionsItemSelected(item);
    }

    private void alterarLayout(){
        linearLayout = !linearLayout;
        if(linearLayout){
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        }
    }

    private void alterarIconeMenu(MenuItem itemMenu){
        if(itemMenu != null){
            if(linearLayout){
                itemMenu.setIcon(getDrawable(R.drawable.ic_grid_background));
            }else {
                itemMenu.setIcon(getDrawable(R.drawable.ic_lista_background));
            }
        }
    }
}