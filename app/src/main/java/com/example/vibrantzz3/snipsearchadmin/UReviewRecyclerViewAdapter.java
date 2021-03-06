package com.example.vibrantzz3.snipsearchadmin;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vibrantzz3 on 3/3/2018.
 */

public class UReviewRecyclerViewAdapter extends RecyclerView.Adapter<UReviewRecyclerViewAdapter.ViewHolder> {


    private Context mContext;
    private List <UReview> hData;

    public UReviewRecyclerViewAdapter(Context mContext, List<UReview> hData) {
        this.mContext=mContext;
        this.hData=hData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.ureview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent intent = new Intent(mContext,SalonProfile.class);
                //mContext.startActivity(intent);

            }
        });




    }

    @Override
    public int getItemCount() {
        return hData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hname,hlocation,hrating,hrcount;

        CardView cardview;

        public ViewHolder(View itemview)
        {   super(itemview);


            cardview=(CardView) itemview.findViewById(R.id.maincard);
        }
    }

}
