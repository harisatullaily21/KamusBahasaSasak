package com.example.kamusbahasasasak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kamusbahasasasak.model.Kamus;

import java.util.List;

public class KamusSasakAdapter extends ArrayAdapter<Kamus> {
    Context context;

    public KamusSasakAdapter(@NonNull Context context, @NonNull List<Kamus> objects) {
        super(context, R.layout.row_kamus, objects);
        this.context = context;
    }

    class ViewHolder {
        TextView txKata;
        TextView txArti;
        TextView txJenis;
        TextView txContoh;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Kamus tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_kamus, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txKata = convertView.findViewById(R.id.row_kt);
            viewHolder.txArti = convertView.findViewById(R.id.row_at);
            viewHolder.txJenis = convertView.findViewById(R.id.row_js);
            viewHolder.txContoh = convertView.findViewById(R.id.row_cth);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txKata.setText(tr.getKata());
        viewHolder.txArti.setText(tr.getArti());
        viewHolder.txContoh.setText(tr.getContoh());
        if (tr.getJenis().equals(Kamus.KATA_BENDA)) {
            viewHolder.txJenis.setText("KATA_BENDA");
        } else if (tr.getJenis().equals(Kamus.KATA_SIFAT)) {
            viewHolder.txJenis.setText("KATA_SIFAT");
        } else if (tr.getJenis().equals(Kamus.KATA_KERJA)) {
            viewHolder.txJenis.setText("KATA_KERJA");
        } else {
            viewHolder.txJenis.setText("UMUM");
        }
        return convertView;
    }
}
