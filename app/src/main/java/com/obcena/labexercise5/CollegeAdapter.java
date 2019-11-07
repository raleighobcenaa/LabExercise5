package com.obcena.labexercise5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CollegeAdapter extends ArrayAdapter<Android> {
    Context mContext;
    int mResource;

    public CollegeAdapter(@NonNull Context context, int resource, @NonNull List<Android> objects) {
        super(context, resource, objects);

        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int image = getItem(position).getLogo();
        String names = getItem(position).getNames();
        String version = getItem(position).getVersion();
        String apiLvl = getItem(position).getApiLvl();
        String rDate = getItem(position).getRDate();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);
        TextView tvNames = convertView.findViewById(R.id.tvNames);
        TextView tvVersion = convertView.findViewById(R.id.tvVersion);
        TextView tvApiLvl = convertView.findViewById(R.id.tvApiLvl);
        TextView tvRDate = convertView.findViewById(R.id.tvRDate);
        ImageView ivLogo = convertView.findViewById(R.id.ivLogo);
        tvNames.setText(names);
        tvVersion.setText(version);
        tvApiLvl.setText(apiLvl);
        tvRDate.setText(rDate);
        ivLogo.setImageResource(image);
        return convertView;
    }
}
