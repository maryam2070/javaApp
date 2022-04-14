package com.example.aaaaaaaa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CoursesActivity extends AppCompatActivity {

    public static final int ADD_COURSE_REQUEST = 1;

     ProjectViewModel courseViewModel;
    CourseAdapter courseAdapter;
    ImageView delete;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        back=(ImageView)findViewById(R.id.back_iv);
        delete=(ImageView)findViewById(R.id.delete_iv);
        FloatingActionButton buttonAddCourse = findViewById(R.id.button_add_course);
        buttonAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursesActivity.this,addNewCourseActivity .class);
                startActivityForResult(intent,ADD_COURSE_REQUEST);
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
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        courseAdapter = new CourseAdapter();
        recyclerView.setAdapter(courseAdapter);

        courseViewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(ProjectViewModel.class);
        courseViewModel.getAllCourses().observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(List<Course> courses) {
                courseAdapter.setCourses(courses);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }


            //before add this add function called getCourseAt() in CourseAdapter class there exist under setCourse function
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                showCustomDialog2(viewHolder);


            }
        }).attachToRecyclerView(recyclerView);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ADD_COURSE_REQUEST && resultCode==RESULT_OK){
            String courseName = data.getStringExtra(addNewCourseActivity.ExtraCourseName);
            String courseCode = data.getStringExtra(addNewCourseActivity.ExtraCourseCode);
            int courseCredit = data.getIntExtra(addNewCourseActivity.ExtraCourseCredit,0);
            int coursePoints = data.getIntExtra(addNewCourseActivity.ExtraCoursePoints,0);
            char courseGrades = (char) data.getCharExtra(addNewCourseActivity.ExtraCourseGrades,'A');
            System.out.println("sssssssssss"+data.getCharExtra(addNewCourseActivity.ExtraCourseGrades,'A'));
            Course course = new Course(courseName,courseCode,courseGrades,coursePoints,courseCredit);
            courseViewModel.insert(course);
            Toast.makeText(this,"Course Saved" , Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Not Saved",Toast.LENGTH_LONG).show();
        }
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


                courseViewModel.deleteAllCourses();
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
    private void showCustomDialog2(RecyclerView.ViewHolder viewHolder)
    {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.confirm_dialog);
        dialog.show();

        Button yesBtn=(Button) dialog.findViewById(R.id.yes_btn);
        Button noBtn=(Button) dialog.findViewById(R.id.no_btn);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                courseViewModel.delete(courseAdapter.getCourseAt(viewHolder.getAdapterPosition()));
                Toast.makeText(CoursesActivity.this,"Course Deleted" ,Toast.LENGTH_LONG);;
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