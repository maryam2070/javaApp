package com.example.aaaaaaaa;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class NotificationActivity extends AppCompatActivity {
    private NotificationViewModel viewModel;
    RecyclerView recyclerView;
    NotificationAdapter adapter;
    ImageView delete;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        delete=(ImageView)findViewById(R.id.delete_iv);
        back=(ImageView)findViewById(R.id.back_iv);

        adapter=new NotificationAdapter(getApplication());

        viewModel= new ViewModelProvider(this).get(NotificationViewModel.class);/////////

        viewModel.getAllNotifications().observe(this, new Observer<List<Notfication>>() {
            @Override
            public void onChanged(List<Notfication> notfications ) {
               adapter.setNotifications(notfications);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        recyclerView = findViewById(R.id.notification_rv);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void showCustomDialog()
    {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.confirm_dialog);
        dialog.show();

        Button yesBtn=(Button) dialog.findViewById(R.id.yes_btn);
        Button noBtn=(Button) dialog.findViewById(R.id.no_btn);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                viewModel.deleteAll();

                dialog.dismiss();
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }


}