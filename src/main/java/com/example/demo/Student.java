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
}
