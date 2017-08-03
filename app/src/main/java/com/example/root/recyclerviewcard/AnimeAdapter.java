package com.example.root.recyclerviewcard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 6/3/17.
 */

public class AnimeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Anime> items;

    public static final int ITEM_TYPE_NORMAL = 0;
    public static final int ITEM_TYPE_NORMAL2 = 2;


    public class AnimeViewHolder extends RecyclerView.ViewHolder{
        // Campos de los items
        public ImageView imagen;
        public TextView nombre;
        public TextView contador;

        public AnimeViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            contador = (TextView) itemView.findViewById(R.id.contador);
        }

        public void bindData(Anime animeModel){
            imagen.setImageResource(animeModel.getImagen());
            nombre.setText("Nombre " + animeModel.getNombre());
            contador.setText("Contador " + String.valueOf(animeModel.getContador()));
        }
    }


    public class AnimeViewHolder2 extends RecyclerView.ViewHolder{
        // Campos de los items
        public ImageView imagen;
        public TextView nombre;
        public TextView contador;

        public AnimeViewHolder2(View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            contador = (TextView) itemView.findViewById(R.id.contador);
            contador = (TextView) itemView.findViewById(R.id.contador);
        }

        public void bindData(Anime animeModel){
            imagen.setImageResource(animeModel.getImagen());
            nombre.setText("Nombre " + animeModel.getNombre());
            contador.setText("Contador " + String.valueOf(animeModel.getContador()));
        }
    }

    public AnimeAdapter(List<Anime> items){
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) { // Saber tipo de viewholdert a retornr, aquí se programa el alternado
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return position % 2 * 2;
    }

    @Override
    public int getItemCount(){
        return items.size();
    }

//    @Override
//    public AnimeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){ // retorna un anime viewholder
//        View v = LayoutInflater.from(viewGroup.getContext())
//                .inflate(R.layout.anime_card_view, viewGroup, false);
//        /*switch (i) {
//            case 0: return new AnimeViewHolder(v);
//            case 2: return new AnimeViewHolder2(v);
//        }*/
//        return new AnimeViewHolder(v); // Aqií retorna el viewHolder (es un xml, definido en esta clas, puede haber multiples )
//    }

    /*public void swap(ArrayList<Anime> datas){
        items.clear();
        items.addAll(datas);
        notifyDataSetChanged();
    }*/


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroupParent, int itemViewType){
        Log.d("itemtype ", String.valueOf(itemViewType));

        if (itemViewType == ITEM_TYPE_NORMAL){
            View v1 = LayoutInflater.from(viewGroupParent.getContext())
                    .inflate(R.layout.anime_card_view, viewGroupParent, false);
            return new AnimeViewHolder(v1);
        }
        //else if (itemViewType == ITEM_TYPE_NORMAL2){

            //itemViewType == ITEM_TYPE_NORMAL2

            View v2 = LayoutInflater.from(viewGroupParent.getContext())
                    .inflate(R.layout.anime_card_view2, viewGroupParent, false);
            return new AnimeViewHolder(v2);

        //}


        /*switch(itemViewType){
            case 0:
                View v0 = LayoutInflater.from(getContext())
                        .inflate(R.layout.anime_card_view2, viewGroupParent, false);
                return new AnimeViewHolder(v0);

            case 2:
                View v1= LayoutInflater.from(getContext())
                        .inflate(R.layout.anime_card_view2, viewGroupParent, false);
                return new AnimeViewHolder(v1);
        }*/
    }



    @Override
    public void onBindViewHolder(final  RecyclerView.ViewHolder viewHolder, final int itemPosition){
        final int itemType = getItemViewType(itemPosition);
        if (itemType == ITEM_TYPE_NORMAL){
            ((AnimeViewHolder)viewHolder).bindData((Anime)items.get(itemPosition));

        }
        else if (itemType == ITEM_TYPE_NORMAL2){
            ((AnimeViewHolder)viewHolder).bindData((Anime)items.get(itemPosition));

        }

        /*switch (viewHolder.getItemViewType()) {
            case 0: AnimeViewHolder animeViewHolder = (AnimeViewHolder) viewHolder;
                animeViewHolder.imagen.setImageResource(items.get(i).getImagen());
                animeViewHolder.nombre.setText("Nombre " + items.get(i).getNombre());
                animeViewHolder.contador.setText("Contador " + String.valueOf(items.get(i).getContador()));
                break;

            case 2: AnimeViewHolder2 animeViewHolder2 = (AnimeViewHolder2) viewHolder;
                animeViewHolder2.imagen.setImageResource(items.get(i).getImagen());
                animeViewHolder2.nombre.setText("Nombre " + items.get(i).getNombre());
                animeViewHolder2.contador.setText("Contador " + String.valueOf(items.get(i).getContador()));
                break;
        }*/

        /*viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText("Nombre " + items.get(i).getNombre());
        viewHolder.contador.setText("Contador " + String.valueOf(items.get(i).getContador()));*/

    }

}
