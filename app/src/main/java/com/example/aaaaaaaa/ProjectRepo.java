package com.example.aaaaaaaa;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
///////////
public class ProjectRepo {
    private ProjectDao dao;
    private LiveData<List<Notfication>>notifications;//


    public ProjectRepo(Application application){
        ProjectDatabase database= ProjectDatabase.getDatabase(application);
        dao= database.Dao();
        notifications=dao.getAllNotifications();
        allCourses=dao.getAllCourses();
    }
    public void insert(Notfication notfication){
        ProjectDatabase.databaseWriteExecutor.execute(() -> {
            dao.insertNotfictaion(notfication);
        });

    }
    public void deleteAll(){
        ProjectDatabase.databaseWriteExecutor.execute(() -> {
            dao.deleteAll();
        });

    }
    public LiveData<List<Notfication>>getAllNotifications()
    {
        return notifications;
    }

/*___________________________________________*/
    private LiveData<List<Course>> allCourses;

    public void insert(Course course){
        new InsertCourseAsyncTask(dao).execute(course);
    }
    public void update(Course course){
        new UpdateCourseAsyncTask(dao).execute(course);
    }
    public void delete(Course course){
        new DeleteCourseAsyncTask(dao).execute(course);
    }
    public void deleteAllCourses(){
        new DeleteAllCourseAsyncTask(dao).execute();
    }

    public LiveData<List<Course>> getAllCourses(){
        return allCourses;
    }

    private static class InsertCourseAsyncTask extends AsyncTask<Course,Void,Void> {

        private ProjectDao dao;

        private InsertCourseAsyncTask(ProjectDao dao){
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Course... courses) {
            dao.insert(courses[0]);
            return null;
        }
    }
    private static class UpdateCourseAsyncTask extends AsyncTask<Course,Void,Void>{

        private ProjectDao courseDao;

        private UpdateCourseAsyncTask(ProjectDao courseDao){
            this.courseDao = courseDao;
        }
        @Override
        protected Void doInBackground(Course... courses) {
            courseDao.update(courses[0]);
            return null;
        }
    }
    private static class DeleteCourseAsyncTask extends AsyncTask<Course,Void,Void>{

        private ProjectDao courseDao;

        private DeleteCourseAsyncTask(ProjectDao courseDao){
            this.courseDao = courseDao;
        }
        @Override
        protected Void doInBackground(Course... courses) {
            courseDao.delete(courses[0]);
            return null;
        }
    }
    private static class DeleteAllCourseAsyncTask extends AsyncTask<Void,Void,Void>{

        private ProjectDao courseDao;

        private DeleteAllCourseAsyncTask(ProjectDao courseDao){
            this.courseDao = courseDao;
        }
        @Override
        protected Void doInBackground(Void... Voids) {
            courseDao.deleteAllCourses();
            return null;
        }
    }

}
