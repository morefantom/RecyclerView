package com.kotlintut.prathamesh.recyclerview;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    String[] titles={"One","Two","Three","Four","Five","Six","Seven","Eight"};

    String[] details={"One Details","Two Details","Three Details","Four Details","Five Details","Six Details","Seven Details","Eight Details"};

    int[] images={R.mipmap.img1,R.mipmap.img2,R.mipmap.img3,R.mipmap.img4,R.mipmap.img5,R.mipmap.img6,R.mipmap.img7,R.mipmap.img8};

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView Title,Details;

        public ViewHolder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.img_v);
            Title=(TextView)itemView.findViewById(R.id.tv_title);
            Details=(TextView)itemView.findViewById(R.id.tv_descript);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos=getAdapterPosition();

                    Snackbar.make(view,"Click detected on item "+pos,Snackbar.LENGTH_SHORT).setAction("Action",null).show();

                }
            });

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.img.setImageResource(images[position]);
        holder.Title.setText(titles[position]);
        holder.Details.setText(details[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
