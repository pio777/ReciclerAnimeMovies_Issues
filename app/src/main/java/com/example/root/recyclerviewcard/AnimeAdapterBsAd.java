/**
 * Created by ejecutivo on 05/06/2017.
 */

package com.example.root.recyclerviewcard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class AnimeAdapterBsAd extends BaseAdapter<Object, AnimeAdapterBsAd.ViewHolder> {
    //ivate List<Anime> items;

    public AnimeAdapterBsAd(Context ctx){
        super(ctx);
    }

    public static final int ITEM_TYPE_NORMAL = 0;
    public static final int ITEM_TYPE_NORMAL2 = 1;

    //class AnimeViewHolder extends BaseAdapter.ViewHolder{
    class ViewHolder extends BaseAdapter.ViewHolder{
        public TextView nombre;
        public TextView contador;
        public ImageView imagen;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            contador = (TextView) itemView.findViewById(R.id.contador);
        }

        public void bindData(Anime animeModel){
            imagen.setImageResource(animeModel.getImagen());
            nombre.setText(animeModel.getNombre());
            contador.setText(String.valueOf(animeModel.getContador()));
        }
    }


    class ViewHolder2 extends ViewHolder{ // Tipo Anime
        public TextView nombre;
        public TextView contador;
        public TextView descripcion;
        public TextView anio;
        public ImageView imagen;


        public ViewHolder2(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            contador = (TextView) itemView.findViewById(R.id.contador);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion);
            anio = (TextView) itemView.findViewById(R.id.anio);
        }

        public void bindData(Manga animeModel){
            imagen.setImageResource(animeModel.getImagen());
            nombre.setText(animeModel.getNombre());
            descripcion.setText(animeModel.getDescripcion());
            contador.setText(String.valueOf(animeModel.getContador()));
            anio.setText(animeModel.getAnio());
        }

    }

    @Override
    public int getItemViewType(int position) { // Saber tipo de viewholdert a retornr, aquí se programa el alternado
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return position % 2 * 2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroupParent, int viewType) {
        Log.d("Tipo ", String.valueOf(viewType));

        if (viewType == ITEM_TYPE_NORMAL){
            View v = LayoutInflater.from(viewGroupParent.getContext())
                    .inflate(R.layout.anime_card_view, viewGroupParent, false);
            return new ViewHolder(v);
        }
        // viewType == ITEM_TYPE_NORMAL2
        View v2 = LayoutInflater.from(viewGroupParent.getContext())
                .inflate(R.layout.anime_card_view2, viewGroupParent, false);
        return new ViewHolder2  (v2);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int itemPosition){
        int itemType = getItemViewType(itemPosition);

        if (itemType == ITEM_TYPE_NORMAL){
            ((ViewHolder)viewHolder).bindData((Anime)list.get(itemPosition));
        }
        else if(itemType == ITEM_TYPE_NORMAL2){
            ((ViewHolder2)viewHolder).bindData((Manga)list.get(itemPosition)); 
        }
    }


}
