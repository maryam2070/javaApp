package com.example.aaaaaaaa;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aaaaaaaa.Course;
import com.example.aaaaaaaa.R;

import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseHolder> {

    private List<Course> courses = new ArrayList<>();
    @NonNull
    @Override
    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_item,parent,false);
        return new CourseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, int position) {
        Course currentCourse = courses.get(position);
        holder.textViewName.setText(currentCourse.getCourseName());
        holder.textViewCode.setText(currentCourse.getCourseCode());
        holder.textViewGrade.setText(String.valueOf(currentCourse.getCourseGrade()));
        holder.textViewPoints.setText(String.valueOf(currentCourse.getCoursePoints()));
        holder.textViewCredit.setText(String.valueOf(currentCourse.getCourseCredit()));
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public void setCourses(List<Course> courses){
        this.courses = courses;
        notifyDataSetChanged();
    }

    class CourseHolder extends RecyclerView.ViewHolder{
        private TextView textViewName,textViewCode,textViewCredit,textViewGrade,textViewPoints;


        public CourseHolder(@NonNull View itemView) {
            super(itemView);
            textViewCode = itemView.findViewById(R.id.courseCodeItem);
            textViewName = itemView.findViewById(R.id.courseNameItem);
            textViewCredit= itemView.findViewById(R.id.courseCridetItem);
            textViewPoints = itemView.findViewById(R.id.coursePointsItem);
            textViewGrade = itemView.findViewById(R.id.courseGradeItem);
        }
    }
}
