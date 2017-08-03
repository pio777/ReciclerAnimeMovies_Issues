package com.example.root.recyclerviewcard;

/**
 * Created by ejecutivo on 30/05/2017.
 */


        import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;

        import java.util.ArrayList;

/**
 * Clase que permite generalizar los adaptadores usados en la aplicación.
 *
 * @param <T> tipo de dato que se usará en el ArrayList de la fuente de datos.
 * @param <VH> view holder.
 */
public abstract class BaseAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>
{
    protected ArrayList<T> list;
    protected Context context;
    protected AdapterView.OnItemClickListener clickListener;

    /**
     * el constructor :v
     *
     * @param context
     */
    public BaseAdapter(Context context)
    {
        this.context = context;
        list = new ArrayList<>();
    }

    /**
     * <]:{v
     *
     * @param parent
     * @param viewType
     * @return
     */
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    /**
     * %&-#4 el que lo lea
     *
     * @param holder
     * @param position
     */
    public abstract void onBindViewHolder(VH holder, int position);

    /**
     * Sali en la fotooooo
     * @return
     */
    @Override
    public int getItemCount()
    {
        return list != null ? list.size() : 0;
    }

    /**
     * trabajar trabajar trabajar
     * dormir dormir dormzzzZzZzZZzZzZzZZzZZZZZZZZZzzzzzZzzz
     *
     * @param listener
     */
    public void setOnClickListener(AdapterView.OnItemClickListener listener)
    {
        clickListener = listener;
    }

    /**
     * fuaaaaaaaaaaaaaaaaaaaa
     */
    public void clear()
    {
        if(list != null)
            list.clear();
        notifyDataSetChanged();
    }

    /**
     * No choque, me chocaron
     *
     * @param agendaList
     */
    public void addAll(ArrayList<T> agendaList)
    {
        this.list = agendaList;
        notifyDataSetChanged();
    }

    /**
     * pa k kieres saber eso jaja salu2
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public ViewHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        /**
         * ola k ase
         *
         * @param v
         */
        @Override
        public void onClick(View v)
        {
            if(clickListener != null)
                clickListener.onItemClick(null, v, getLayoutPosition(), getItemId());
        }
    }
}
