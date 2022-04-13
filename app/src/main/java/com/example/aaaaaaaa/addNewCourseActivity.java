package com.example.aaaaaaaa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class addNewCourseActivity extends AppCompatActivity {


    public static final String ExtraCourseName =
            "com.example.coursesregisterd.ExtraCourseName";
    public static final String ExtraCourseCredit =
            "com.example.coursesregisterd.ExtraCourseCredit";
    public static final String ExtraCourseCode =
            "com.example.coursesregisterd.ExtraCourseCode";
    public static final String ExtraCoursePoints =
            "com.example.coursesregisterd.ExtraCoursePoints";
    public static final String ExtraCourseGrades=
            "com.example.coursesregisterd.ExtraCourseGrades";

    private EditText courseName;
    private EditText courseCode;
    private EditText courseCredit;
    private EditText coursePoints;


    String[] Grades;
    private NumberPicker numberPickerGrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_course);

/*
        Grades = getResources().getStringArray(R.array.Grades);
        numberPickerGrades.setDisplayedValues(Grades);

        courseName=findViewById(R.id.ETCourseName);
        courseCode = findViewById(R.id.ETCourseCode);
        courseCredit = findViewById(R.id.ETCourseCredit);
        coursePoints = findViewById(R.id.ETCoursePoints);
        numberPickerGrades = findViewById(R.id.NumberPickerGrades);

        numberPickerGrades.setMinValue(0);
        numberPickerGrades.setMaxValue(4);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);
        setTitle("Add Course");

    }

    private void saveCourse(){
        String courseNameSave = courseName.getText().toString();
        String courseCodeSave = courseCode.getText().toString();
        String courseCreditSave = courseCredit.getText().toString();

        int courseGradeSave = numberPickerGrades.getValue();
        String coursePointsSave = coursePoints.getText().toString();

        if(courseCodeSave.trim().isEmpty()||courseNameSave.trim().isEmpty()||courseCreditSave.trim().isEmpty()){
            Toast.makeText(this,"Please Enter Values", Toast.LENGTH_LONG);
            return;
        }

        Intent data = new Intent();
        data.putExtra(ExtraCourseName,courseNameSave);
        data.putExtra(ExtraCourseGrades,courseGradeSave);
        data.putExtra(ExtraCourseCode,courseCodeSave);
        data.putExtra(ExtraCourseCredit,courseCreditSave);
        data.putExtra(ExtraCoursePoints,coursePointsSave);

        setResult(RESULT_OK,data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_course_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.saveCourse:
                saveCourse();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }*/
    }
 }
