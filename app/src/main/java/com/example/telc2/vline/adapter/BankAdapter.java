package com.example.telc2.vline.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by TEL-C on 9/22/17.
 */

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.HolderData> {

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HolderData extends RecyclerView.ViewHolder {
        public HolderData(View itemView) {
            super(itemView);
        }
    }
}
