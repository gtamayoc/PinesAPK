package com.example.pines;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdaptador extends RecyclerView.Adapter<ListAdaptador.ViewHolder> {

    private List<paquete> mDatos;
    private LayoutInflater minflater;
    private Context context;


    public ListAdaptador(List<paquete> mDatos, Context context) {
        this.minflater = LayoutInflater.from(context);
        this.context = context;
        this.mDatos = mDatos;
    }


    @Override
    public int getItemCount() {return mDatos.size();}

    @NonNull
    @Override
    public ListAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = minflater.inflate(R.layout.pines_element, null);
        return new ListAdaptador.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdaptador.ViewHolder holder, final int position) {
        holder.binData(mDatos.get(position));
    }

    public void setItems(List<paquete> items){ mDatos = items;}

        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView iconImagen;
            TextView  nombre, descripcion, planes;

            ViewHolder(View itemView){
                super(itemView);
                iconImagen = itemView.findViewById(R.id.iconoImagen);
                nombre= itemView.findViewById(R.id.nombrePin);
                descripcion=itemView.findViewById(R.id.nombrePinDescrip);
                planes= itemView.findViewById(R.id.nombrePindisponibilidad);
            }


            void binData(final paquete items){
                iconImagen.setImageResource(items.getImagen());
                nombre.setText(items.getNombrePin());
                descripcion.setText(items.getDescripcionPin());
                planes.setText(items.getCantPin());
        }





    }



}
