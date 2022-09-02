package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import java.sql.*;

public class MainController implements Initializable {
    Connection conn;
    PreparedStatement preparedStatement;
    int index;
    int id;

    public void Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-crud", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Connect();
    }

    @FXML
    private TableColumn<?, ?> idCol, nameCol, emailCol, mobileCol, courseCol;

    @FXML
    private TableView<?> table;

    @FXML
    private TextField txtName, txtEmail, txtMobile, txtCourse;

    @FXML
    private Button addBtn, updateBtn, deleteBtn;

    @FXML
    void Add(ActionEvent event) {
        String name, email, mobile, course;

        name = txtName.getText();
        email = txtEmail.getText();
        mobile = txtMobile.getText();
        course = txtCourse.getText();

        System.out.println(name + " " + email + " " + mobile + " " + course);
    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Update(ActionEvent event) {

    }
}
