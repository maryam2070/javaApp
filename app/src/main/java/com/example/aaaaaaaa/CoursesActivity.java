package com.example.aaaaaaaa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    private ProjectViewModel courseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        FloatingActionButton buttonAddCourse = findViewById(R.id.button_add_course);
        buttonAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursesActivity.this,addNewCourseActivity .class);
                startActivityForResult(intent,ADD_COURSE_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        CourseAdapter courseAdapter = new CourseAdapter();
        recyclerView.setAdapter(courseAdapter);

        courseViewModel = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(ProjectViewModel.class);
        courseViewModel.getAllCourses().observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(List<Course> courses) {
                courseAdapter.setCourses(courses);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ADD_COURSE_REQUEST && resultCode==RESULT_OK){
            String courseName = data.getStringExtra(addNewCourseActivity.ExtraCourseName);
            String courseCode = data.getStringExtra(addNewCourseActivity.ExtraCourseCode);
            int courseCredit = data.getIntExtra(addNewCourseActivity.ExtraCourseCredit,0);
            int coursePoints = data.getIntExtra(addNewCourseActivity.ExtraCoursePoints,0);
            char courseGrades = data.getCharExtra(addNewCourseActivity.ExtraCourseGrades,'A');

            Course course = new Course(courseName,courseCode,courseGrades,coursePoints,courseCredit);
            courseViewModel.insert(course);
            Toast.makeText(this,"Course Saved" , Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Not Saved",Toast.LENGTH_LONG).show();
        }
    }


}