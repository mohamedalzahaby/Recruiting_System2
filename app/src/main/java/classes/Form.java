package classes;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

public class Form extends TimeStamps {
    protected String name;
    protected String creatorId;
    protected String departmentId;

    protected ArrayList<Question> questions = new ArrayList<>();


    public Form(String name, String creatorId, String departmentId , ArrayList<Question> questions) {
        this.name = name;
        this.creatorId = creatorId;
        this.departmentId = departmentId;
        this.questions = questions;
    }
    public Form(String id,String name, String creatorId, String departmentId , ArrayList<Question> questions) {
        super(id);
        this.name = name;
        this.creatorId = creatorId;
        this.departmentId = departmentId;
        this.questions = questions;
    }
    public Form(String id, String name, String creatorId, String departmentId) {
        super(id);
        this.name = name;
        this.creatorId = creatorId;
        this.departmentId = departmentId;
    }

    public Form(DataSnapshot dataSnapshot) {
        this.id = dataSnapshot.child("id").toString();
        this.name = dataSnapshot.child("name").toString();
        this.creatorId = dataSnapshot.child("creatorId").toString();
        this.departmentId = dataSnapshot.child("departmentId").toString();
        this.questions = questions;
    }


    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }



}
