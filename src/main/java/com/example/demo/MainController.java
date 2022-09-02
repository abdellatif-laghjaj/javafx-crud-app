package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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

        if (name.isEmpty() || email.isEmpty() || mobile.isEmpty() || course.isEmpty()) {
            //show error alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Feilds cannot be empty");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
        } else {
            try {
                preparedStatement = conn.prepareStatement("insert into registration (name, email, mobile, course) values(?, ?, ?)");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, mobile);
                preparedStatement.setString(4, course);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Update(ActionEvent event) {

    }
}
