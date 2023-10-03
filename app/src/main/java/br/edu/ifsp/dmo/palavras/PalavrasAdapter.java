package br.edu.ifsp.dmo.palavras;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.palavras.R;

import java.util.ArrayList;
import java.util.List;

public class PalavrasAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> palavras;

    public PalavrasAdapter(Context context, String letraId) {
        this.context = context;
        palavras = new ArrayList<>();

        String todas[] =
                context.getResources().getStringArray(R.array.palavras);
        for (String s : todas){
            if (s.startsWith(letraId)){
                palavras.add(s);
            }
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewTpe) {
        View view;
        view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item, parent, false);
        RecyclerView.ViewHolder holder = new RecyclerView.ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull LetrasAdapter.ViewHolder holder, int position) {
        holder.palavraButton.setText(palavras.get(position));
        holder.palavraButton.setOnClickListener(v -> abrirNavegador(position));
    }
    @Override
public int getItemCount(){
    return palavras.size();
    }
    private void abrirNavegador(int position){
        Uri query = Uri.parse(Constants.SEARCH_PREFIX + palavras.get(position));
        Intent intent = new Intent(Intent.ACTION_VIEW, query);
        context.startActivity(intent);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public Button palavraButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            palavraButton = itemView.findViewById(R.id.button_item);
        }
    }
}