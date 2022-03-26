package com.example.aaaaaaaa;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationViewHolder> {

    List<Notfication> notifications=Collections.emptyList();


    public void setNotifications(List<Notfication> notifications) {
        this.notifications = notifications;
        notifyDataSetChanged();
    }

    Context context;
    public NotificationAdapter( Application application)
    {
        this.context = application;
    }


    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item,parent,false);
        NotificationViewHolder vh= new NotificationViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {

        holder.notificationText.setText(notifications.get(position).getText());
        holder.notificationTime.setText(notifications.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }



}
    class NotificationViewHolder extends RecyclerView.ViewHolder {
        public final TextView notificationText;
        public final TextView notificationTime;

        public NotificationViewHolder(View itemView) {
            super(itemView);
            notificationText = itemView.findViewById(R.id.notification_content_tv);
            notificationTime=itemView.findViewById(R.id.time_tv);
        }

}



