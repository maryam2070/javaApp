package com.example.aaaaaaaa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
    private List<CourseGrade> viewList = new ArrayList<>();
    @NonNull
    @Override
    public ViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_view,parent,false);
        return new ViewAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter.ViewHolder holder, int position) {
        CourseGrade addCourse = viewList.get(position);
        holder.course_code.setText(addCourse.getCourseCode());
        holder.View_Grade.setText(addCourse.getCourseGrade());
        holder.View_Points.setText(String.valueOf(addCourse.getCoursePoints()));
        holder.View_CreditH.setText(String.valueOf(addCourse.getCourseCredit()));
    }

    @Override
    public int getItemCount() {
        return viewList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView course_code,View_Grade,View_Points,View_CreditH;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            course_code = itemView.findViewById(R.id.course_code);
            View_Grade = itemView.findViewById(R.id.View_Grade);
            View_CreditH= itemView.findViewById(R.id.View_CreditH);
            View_Points = itemView.findViewById(R.id.View_Points);

        }
    }
}