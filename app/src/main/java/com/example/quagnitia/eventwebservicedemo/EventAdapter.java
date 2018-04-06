package com.example.quagnitia.eventwebservicedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by V@iBh@V on 3/22/2018.
 */

public class EventAdapter extends BaseAdapter {
    Context context;
    List<ResponseData> eventList;
    LayoutInflater lf;
    Holder holder;

    public EventAdapter(Context context, List<ResponseData> eventList) {
        this.context=context;
        this.eventList=eventList;
        lf= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int position) {
        return eventList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
        {
            convertView=lf.inflate(R.layout.row_event,null);
            holder=new Holder();
            holder.txtId=convertView.findViewById(R.id.txtId);
            holder.txtName=convertView.findViewById(R.id.txtName);
            holder.txtVenue=convertView.findViewById(R.id.txtVenue);
            holder.txtStartDate=convertView.findViewById(R.id.txtStartDate);
            holder.txtEndDate=convertView.findViewById(R.id.txtEndDate);
            holder.txtTimeZone=convertView.findViewById(R.id.txtTimeZone);

        }
        ResponseData event=eventList.get(position);
        holder.txtName.setText(event.getEvent().getName());
        holder.txtId.setText(event.getEvent().getId());
        holder.txtVenue.setText(event.getEvent().getVenue());
        holder.txtStartDate.setText(event.getEvent().getStart_time());
        holder.txtEndDate.setText(event.getEvent().getEnd_time());
        holder.txtTimeZone.setText(event.getEvent().getTimezone());
        return convertView;
    }

    private class Holder {
        TextView txtId,txtName,txtVenue,txtStartDate,txtEndDate,txtTimeZone;

    }
}
