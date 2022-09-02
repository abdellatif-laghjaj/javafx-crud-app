package com.example.demo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty email;
    private final StringProperty mobile;
    private final StringProperty course;

    public Student() {
        id = new SimpleStringProperty(this, "id");
        name = new SimpleStringProperty(this, "name");
        email = new SimpleStringProperty(this, "email");
        mobile = new SimpleStringProperty(this, "mobile");
        course = new SimpleStringProperty(this, "course");
    }

    public StringProperty getId() {
        return id;
    }

    public StringProperty getName() {
        return name;
    }

    public StringProperty getEmail() {
        return email;
    }

    public StringProperty getMobile() {
        return mobile;
    }

    public StringProperty getCourse() {
        return course;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public void setMobile(String mobile) {
        this.mobile.set(mobile);
    }

    public void setCourse(String course) {
        this.course.set(course);
    }
}
