package com.example.telc2.vline.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.telc2.vline.R;
import com.example.telc2.vline.model.Bank;

import java.util.List;

import static com.example.telc2.vline.R.id.tx_list_teller_nomorantri;

/**
 * Created by TEL-C on 9/22/17.
 */

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.HolderData> {

    private List<Bank> bankList;
    private Context mContext;

    public BankAdapter(List<Bank> bankList, Context mContext) {
        this.bankList = bankList;
        this.mContext = mContext;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_bank, parent, false);
        HolderData holder = new HolderData(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        holder.txNamaBank.setText(bankList.get(position).getBank_nama());
        holder.txNomorAntriTeller.setText(bankList.get(position).getBank_nomor_antri_teller_sekarang());
        holder.txNomorAntriCS.setText(bankList.get(position).getBank_nomor_antri_cs_sekarang());
        holder.txJumlahAntriTeller.setText(bankList.get(position).getBank_jumlah_antri_teller());
        holder.txJumlahAntriCS.setText(bankList.get(position).getBank_jumlah_antri_cs());
    }

    @Override
    public int getItemCount() {
        return bankList.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {

        TextView txNamaBank, txNomorAntriTeller, txJumlahAntriTeller, txNomorAntriCS, txJumlahAntriCS;

        public HolderData(View itemView) {
            super(itemView);

            txNamaBank = (TextView) itemView.findViewById(R.id.tx_item_list_nama_bank);
            txNomorAntriTeller = (TextView) itemView.findViewById(R.id.tx_list_teller_nomorantri);
            txJumlahAntriTeller = (TextView) itemView.findViewById(R.id.tx_list_teller_jumlahantrian);
            txNomorAntriCS = (TextView) itemView.findViewById(R.id.tx_list_cs_nomorantri);
            txJumlahAntriCS = (TextView) itemView.findViewById(R.id.tx_list_cs_jumlahantrian);

        }
    }
}
