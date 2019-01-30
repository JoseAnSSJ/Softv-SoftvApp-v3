package com.example.pablo.prueba7.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.pablo.prueba7.Listas.Array;
import com.example.pablo.prueba7.MainActivity;
import com.example.pablo.prueba7.Orden;
import com.example.pablo.prueba7.R;
import com.example.pablo.prueba7.Request.Request;

import java.util.ArrayList;

public class ordenes_adapter_result extends BaseAdapter {


    LayoutInflater inflater;
    Context mContext;
    ArrayList<String>ordensrc;
    ArrayList<String>contratosrc;
    ArrayList<String>nombresrc;
    ArrayList<String>statusrc;
    Request request=new Request();

    public ordenes_adapter_result(Context context, ArrayList<String>ordensrc,ArrayList<String>nombrex,ArrayList<String>contratosrc,ArrayList<String>statusrc){

        this.ordensrc=ordensrc;
        this.contratosrc=contratosrc;
        this.nombresrc=nombrex;
        this.statusrc=statusrc;

        mContext=context;
        inflater=LayoutInflater.from(mContext);

    }
    public static class viewHolder{
        TextView status,contrato,nombre;
       public static   Button orden;
    }

    @Override
    public int getCount() {
        return Array.ordensrc.size();
                //&Array.nombresrc.size()&Array.statusrc.size()&Array.contratosrc.size();


    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final viewHolder holder;


        if (convertView == null) {
            holder = new viewHolder();

            convertView=inflater.inflate(R.layout.ordenes_list_items,null);

            holder.status=(TextView)convertView.findViewById(R.id.statusv);
            holder.orden=(Button)convertView.findViewById(R.id.ordenv);
            holder.contrato=(TextView)convertView.findViewById(R.id.contratov);
            holder.nombre=(TextView)convertView.findViewById(R.id.nombrev);


            convertView.setTag(holder);
        }
        else {
            holder=(viewHolder)convertView.getTag();
        }

        holder.nombre.setText(Array.nombresrc.get(position));
        holder.orden.setText(Array.ordensrc.get(position));
        holder.contrato.setText(Array.contratosrc.get(position));
        holder.status.setText(Array.statusrc.get(position));


holder.orden.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intento1 = new Intent(mContext, MainActivity.class);

        mContext.startActivity(intento1);
        request.getDeepCons();

    }
});
        return convertView;



    }



}