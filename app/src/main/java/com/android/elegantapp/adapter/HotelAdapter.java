package com.android.elegantapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.android.elegantapp.R;
import com.android.elegantapp.modal.Hotel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rashmi 2020/04/03.
 */

public class HotelAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Hotel> hotelArrayList;

    public HotelAdapter(Context context, ArrayList<Hotel> hotelArrayList) {

        this.context = context;
        this.hotelArrayList = hotelArrayList;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }
    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return hotelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return hotelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_row, null, true);

            holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.address = (TextView) convertView.findViewById(R.id.address);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        Picasso.get().load(hotelArrayList.get(position).getImgURLsmall()).into(holder.iv);
        holder.title.setText(""+hotelArrayList.get(position).getTitle());
        holder.address.setText(""+hotelArrayList.get(position).getAddress());

        return convertView;
    }

    private class ViewHolder {

        protected TextView title, address;
        protected ImageView iv;
    }

}