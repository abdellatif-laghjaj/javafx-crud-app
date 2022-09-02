package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

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
        Table();
    }

    @FXML
    private TableColumn<Student, String> idCol, nameCol, emailCol, mobileCol, courseCol;

    @FXML
    private TableView<Student> table;

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
            showAlert(Alert.AlertType.ERROR, "Feilds are empty", "Please fill all the feilds");
        } else {
            try {
                preparedStatement = conn.prepareStatement("insert into registration (name, email, mobile, course) values(?, ?, ?, ?)");
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, email);
                preparedStatement.setString(3, mobile);
                preparedStatement.setString(4, course);

                preparedStatement.executeUpdate();

                showAlert(Alert.AlertType.INFORMATION, "Success", "Record added successfully");

                reset();
                Table();
            } catch (SQLException e) {
                showAlert(Alert.AlertType.ERROR, "Error", "Error while adding record");
                e.printStackTrace();
            }
        }
    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Update(ActionEvent event) {

    }

    public void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void reset() {
        txtName.setText("");
        txtEmail.setText("");
        txtMobile.setText("");
        txtCourse.setText("");
    }

    public void Table() {
        Connect();
        ObservableList<Student> students = FXCollections.observableArrayList();
        try {
            preparedStatement = conn.prepareStatement("select * from registration");
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                Student student = new Student();
                student.setId(result.getString("id"));
                student.setName(result.getString("name"));
                student.setEmail(result.getString("email"));
                student.setMobile(result.getString("mobile"));
                student.setCourse(result.getString("course"));

                students.add(student);

                table.setItems(students);
                idCol.setCellValueFactory(data -> data.getValue().idProperty());
                nameCol.setCellValueFactory(data -> data.getValue().nameProperty());
                emailCol.setCellValueFactory(data -> data.getValue().emailProperty());
                mobileCol.setCellValueFactory(data -> data.getValue().mobileProperty());
                courseCol.setCellValueFactory(data -> data.getValue().courseProperty());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
