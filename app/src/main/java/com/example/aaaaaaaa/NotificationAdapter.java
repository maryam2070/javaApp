package com.example.aaaaaaaa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationAdapter extends ListAdapter<Notfication, NotificationViewHolder> {

    public NotificationAdapter(@NonNull DiffUtil.ItemCallback<Notfication> diffCallback) {
        super(diffCallback);
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return NotificationViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {
        Notfication current = getItem(position);
        holder.bind(current.getText());
    }


    static class NotifictaionDiff extends DiffUtil.ItemCallback<Notfication> {

        @Override
        public boolean areItemsTheSame(@NonNull Notfication oldItem, @NonNull Notfication newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Notfication oldItem, @NonNull Notfication newItem) {
            return oldItem.getText().equals(newItem.getText());
        }
    }


}
class NotificationViewHolder extends RecyclerView.ViewHolder {
    private final TextView notificationContent;

    private NotificationViewHolder(View itemView) {
        super(itemView);
        notificationContent = itemView.findViewById(R.id.notification_content_tv);
    }

    public void bind(String text) {
        notificationContent.setText(text);
    }

    static NotificationViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_item, parent, false);
        return new NotificationViewHolder(view);
    }
}


