package com.example.aaaaaaaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class NotificationActivity extends AppCompatActivity {

    private NotficationViewModel mNotificationViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        mNotificationViewModel = new ViewModelProvider(this).get(NotficationViewModel.class);
       /* Notfication notfication=new Notfication() ;
        notfication.setId(66);
        notfication.setTitle("aaaaaaaa");
        notfication.setText("mmmmmmmmmmmmmmmmmmmm");
        mNotificationViewModel.insert(notfication);
*/


        RecyclerView recyclerView = findViewById(R.id.notification_rv);
        final NotificationAdapter adapter = new NotificationAdapter(new NotificationAdapter.NotifictaionDiff());
        mNotificationViewModel.getAll().observe(this, notfications -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(notfications);
        });


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}