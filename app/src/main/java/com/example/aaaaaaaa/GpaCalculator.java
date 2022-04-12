package com.example.aaaaaaaa;

import androidx.appcompat.app.AppCompatActivity;

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

public class GpaCalculator extends AppCompatActivity {

    private Spinner spinner;
    private EditText CreditHours;
    private Button addCourse,calculate,clear;
    private TextView GPA_view;
    double totalPoints=0,total_credit=0,creditHours=0,gradePoints;
    ImageView courses;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa_calculator);
        CreditHours = findViewById(R.id.creditHours);
        addCourse = findViewById(R.id.Add);
        calculate = findViewById(R.id.calculate);
        clear = findViewById(R.id.Clear);
        GPA_view = findViewById(R.id.GPA_view);
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
            public void onClick(View view)
            {
                Intent intent=new Intent(GpaCalculator.this,CoursesActivity.class);
                startActivity(intent);
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
                ((TextView) parent.getChildAt(0)).setTextSize(15);
                String selectedGrade = (String) parent.getItemAtPosition(i);
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
                if(!CreditHours.getText().toString().isEmpty()){
                    creditHours = Double.parseDouble(CreditHours.getText().toString());
                    totalPoints += (gradePoints*creditHours);
                    total_credit+=creditHours;
                    Toast.makeText(getApplicationContext(),"Credit : "+creditHours+"\ngrade : "+gradePoints,Toast.LENGTH_LONG).show();
                    CreditHours.setText("");
                } else {
                    Toast.makeText(getApplicationContext() , "Enter credit hours" , Toast.LENGTH_SHORT).show();
                }


            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result = totalPoints/total_credit;
                GPA_view.setText(""+result);

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalPoints=0;
                total_credit=0;
                creditHours=0;
                CreditHours.setText("");
                GPA_view.setText("Here is your GPA");
            }
        });
    }
}