package br.edu.ifsp.dmo.palavras;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.palavras.R;

import java.util.ArrayList;
import java.util.List;

public class LetrasAdapter extends RecyclerView.Adapter<LetrasAdapter.ViewHolder> {
    private Context context;
    private List<Character> letras;

    public LetrasAdapter(Context context){
        this.context = context;

        letras = new ArrayList<>(23);
        for(char c = 'a'; c <= 'z'; c++){
            letras.add(c);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.itemButton.setText(letras.get(position).toString());
        holder.itemButton.setOnClickListener(v -> abrirDetalhes(position));
    }

    @Override
    public int getItemCount(){
        return letras.size();
    }

    private void abrirDetalhes(int position){
        Intent intent = new Intent(context, DetalhesActivity.class);
        intent.putExtra(Constants.LETRA_ID, letras.get(position).toString());
        context.startActivity(intent);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public Button itemButton;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            itemButton = itemView.findViewById(R.id.button_item);
        }
    }
}
