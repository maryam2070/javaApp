package com.example.aaaaaaaa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class GpaCalculator extends AppCompatActivity {

    private Spinner spinner;
    private EditText CreditHours , courseCode , completedH , CGPA;
    private Button addCourse,calculate,clear;
    private TextView GPA_view , total_view;
    ArrayList<CourseGrade>Courses= new ArrayList<>();
    ViewAdapter adapter1=new ViewAdapter();
    String selectedGrade;
    double totalPoints=0,total_credit=0,creditHours=0,gradePoints ,coursePoints,completedHours=0,previousGPA=0;
    ImageView back;
    ImageView courses;
    RecyclerView viewCourses ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa_calculator);

        viewCourses = findViewById(R.id.courses_view);
        adapter1.setList(Courses);
        viewCourses.setAdapter(adapter1);
        viewCourses.setLayoutManager(new LinearLayoutManager(GpaCalculator.this));
        completedH=findViewById(R.id.creditH);
        CGPA = findViewById(R.id.CGPA);
        CreditHours = findViewById(R.id.creditHours);
        courseCode=findViewById(R.id.course_code);
        addCourse = findViewById(R.id.Add);
        calculate = findViewById(R.id.calculate);
        clear = findViewById(R.id.Clear);
        GPA_view = findViewById(R.id.gpa_view);
        total_view= findViewById(R.id.total_view);
        spinner = findViewById(R.id.Grades);
        final String[] grades =new String[] {"A", "A-", "B+", "B", "C+", "C", "D", "F" , "Abs" , "I" , "W" , "Ba"};
        back=(ImageView)findViewById(R.id.back_iv);
        courses=(ImageView)findViewById(R.id.courses);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, grades);
        spinner.setAdapter(adapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GpaCalculator.this,CoursesActivity.class));
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                ((TextView) parent.getChildAt(0)).setTextSize(15);
                selectedGrade = (String) parent.getItemAtPosition(i);
                if(selectedGrade.equals("A"))
                    gradePoints = 4.00;
                else if (selectedGrade.equals("A-"))
                    gradePoints = 3.67;
                else if (selectedGrade.equals("B+"))
                    gradePoints = 3.33;
                else if (selectedGrade.equals("B"))
                    gradePoints = 3.00;
                else if (selectedGrade.equals("C+"))
                    gradePoints = 2.67;
                else if (selectedGrade.equals("C"))
                    gradePoints = 2.33;
                else if (selectedGrade.equals("D"))
                    gradePoints = 2.00;
                else if (selectedGrade.equals("F"))
                    gradePoints = 0;
                else if (selectedGrade.equals("Abs"))
                    gradePoints = 0;
                else if (selectedGrade.equals("I"))
                    gradePoints = 0;
                else if (selectedGrade.equals("W"))
                    gradePoints = 0;
                else if (selectedGrade.equals("Ba"))
                    gradePoints = 0;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((!CreditHours.getText().toString().isEmpty())&&(!courseCode.getText().toString().isEmpty())){
                    creditHours = Double.parseDouble(CreditHours.getText().toString());
                    coursePoints=gradePoints*creditHours;
                    totalPoints += coursePoints;
                    total_credit+=creditHours;

                    Courses.add(new CourseGrade(courseCode.getText().toString(),selectedGrade,Integer.parseInt(CreditHours.getText().toString()),coursePoints));

                    adapter1.setList(Courses);
                    viewCourses.setAdapter(adapter1);
                    Toast.makeText(getApplicationContext(),"Credit : "+creditHours+"\ngrade : "+gradePoints,Toast.LENGTH_LONG).show();
                    CreditHours.setText("");
                    courseCode.setText("");
                } else {
                    Toast.makeText(getApplicationContext() , "Enter missing data values" , Toast.LENGTH_SHORT).show();
                }


            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((!CGPA.getText().toString().isEmpty())&&(!completedH.getText().toString().isEmpty()))
                {   previousGPA= Double.parseDouble(CGPA.getText().toString());
                    completedHours=Double.parseDouble(completedH.getText().toString());
                    double result = totalPoints/total_credit;
                    double Total = ((previousGPA*completedHours)+totalPoints)/(total_credit+completedHours);
                    GPA_view.setText(""+result);
                    total_view.setText(""+Total);
                }
                else if(creditHours==0){
                    GPA_view.setText("");
                    total_view.setText("");
                }
                else
                {
                    double result = totalPoints/total_credit;
                    GPA_view.setText(""+result);
                    total_view.setText(""+result);
                }

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalPoints=0;
                total_credit=0;
                creditHours=0;
                completedHours=0;
                previousGPA=0;
                coursePoints=0;
                CGPA.setText("");
                completedH.setText("");
                CreditHours.setText("");
                courseCode.setText("");
                GPA_view.setText("");
                total_view.setText("");
                Courses.clear();
                adapter1.setList(Courses);
                viewCourses.setAdapter(adapter1);
            }
        });
    }
}