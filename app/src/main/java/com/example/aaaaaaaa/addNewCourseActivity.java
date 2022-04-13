package com.example.aaaaaaaa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
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
    public static final String ExtraCourseGrades =
            "com.example.coursesregisterd.ExtraCourseGrades";
    String selectedGrade;
    private EditText courseName;
    private EditText courseCode;
    private EditText courseCredit;
    private EditText coursePoints;

    private Button save;
    private ProjectViewModel courseViewModel;
    String[] Grades;
    private Spinner numberPickerGrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_course);

        courseName = findViewById(R.id.ETCourseName);
        courseCode = findViewById(R.id.ETCourseCode);
        courseCredit = findViewById(R.id.ETCourseCredit);
        coursePoints = findViewById(R.id.ETCoursePoints);
        numberPickerGrades = findViewById(R.id.NumberPickerGrades);
        final String[] grades = new String[]{"A", "A-", "B+", "B", "C+", "C", "D", "F", "Abs", "I", "W", "Ba"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, grades);
        numberPickerGrades.setAdapter(adapter);
        save = findViewById(R.id.save_btn);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCourse();
            }
        });
        //   getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24);
        setTitle("Add Course");


        numberPickerGrades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                //   ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                //    ((TextView) parent.getChildAt(0)).setTextSize(15);
                selectedGrade = (String) parent.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void saveCourse() {
        String courseNameSave = courseName.getText().toString();
        String courseCodeSave = courseCode.getText().toString();
        String courseCreditSave = courseCredit.getText().toString();

        String coursePointsSave = coursePoints.getText().toString();

        if (courseCodeSave.trim().isEmpty() || courseNameSave.trim().isEmpty() || courseCreditSave.trim().isEmpty()) {
            Toast.makeText(this, "Please Enter Values", Toast.LENGTH_LONG);
            return;
        }

        Intent data = new Intent();
        data.putExtra(ExtraCourseName, courseNameSave);
        data.putExtra(ExtraCourseGrades, selectedGrade);
        data.putExtra(ExtraCourseCode, courseCodeSave);
        data.putExtra(ExtraCourseCredit, courseCreditSave);
        data.putExtra(ExtraCoursePoints, coursePointsSave);

        setResult(RESULT_OK, data);
        finish();
    }

}




