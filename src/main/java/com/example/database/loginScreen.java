package com.example.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class loginScreen extends Application {

	private TextField textField1;
	private PasswordField passwordField1;
	private Label loginStatusLabel;
	static String role;

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Employee Account");

		// Create an ImageView for the background image
		Image backgroundImage = new Image("logo.png");
		ImageView backgroundImageView = new ImageView(backgroundImage);
		backgroundImageView.setFitWidth(1300); // Set the width to match the scene width
		backgroundImageView.setFitHeight(400); // Set the height to match the scene height

		StackPane stackPane = new StackPane();
		stackPane.getChildren().add(backgroundImageView); // Add the background image

		VBox vbox = new VBox(10);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(20));

		Label employeeName = new Label("Name:");
		employeeName.setFont(Font.font("Arial", FontWeight.BOLD, 14)); // Set font to Arial, bold, size 16
		textField1 = new TextField();
		textField1.setPromptText("Enter your name");

		// Create an HBox to hold the text field
		HBox nameBox = new HBox(textField1);
		nameBox.setAlignment(Pos.CENTER);
		nameBox.setPrefWidth(200); // Set preferred width for the HBox

		Label employeePassword = new Label("Password:");
		employeePassword.setFont(Font.font("Arial", FontWeight.BOLD, 14)); // Set font to Arial, bold, size 16
		passwordField1 = new PasswordField();
		passwordField1.setPromptText("Enter your password");

		// Create an HBox to hold the password field
		HBox passwordBox = new HBox(passwordField1);
		passwordBox.setAlignment(Pos.CENTER);
		passwordBox.setPrefWidth(200); // Set preferred width for the HBox

		Button logInButton = new Button("Log in");
		logInButton.setStyle("-fx-background-color: #0000FF; -fx-text-fill: #FFFFFF;");

		Button cancelButton = new Button("Cancel");
		cancelButton.setStyle("-fx-background-color: #0000FF; -fx-text-fill: #FFFFFF;");

		logInButton.setStyle("-fx-background-color: #0000FF; -fx-text-fill: #FFFFFF; -fx-background-radius: 30;");
		cancelButton.setStyle("-fx-background-color: #0000FF; -fx-text-fill: #FFFFFF; -fx-background-radius: 30;");

		loginStatusLabel = new Label("");
		loginStatusLabel.setFont(Font.font("System", FontWeight.BOLD, 12)); // Set font to numeric and bold

		vbox.getChildren().addAll(employeeName, nameBox, employeePassword, passwordBox, logInButton, cancelButton,
				loginStatusLabel);

		stackPane.getChildren().add(vbox); // Add the vbox containing login elements to the stackPane

		logInButton.setOnAction(e -> loginUser(primaryStage));
		cancelButton.setOnAction(e -> primaryStage.close());

		Scene scene = new Scene(stackPane, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false); // Set window resizable to false
		primaryStage.show();
	}

	private void loginUser(Stage primaryStage) {
		String name = textField1.getText();
		String password = passwordField1.getText();
		if (name.isEmpty()) {
			loginStatusLabel.setText("Enter your name");
		} else if (password.isEmpty()) {
			loginStatusLabel.setText("Enter a password");
		} else {
			MySQLJDBCConnection con = new MySQLJDBCConnection();
			Connection Con = con.getConnection();

			String query = "select Username,Password,Role from employee where Username= '" + name + "'";
			Statement stmt;
			role = "";
			try {
				stmt = Con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				if (!(rs.isBeforeFirst())) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setContentText("User Not Found");
					alert.showAndWait();
				} else {
					String DBpassword = "";
					while (rs.next()) {
						String UserName = rs.getString("Username");
						DBpassword = rs.getString("Password");
						role = rs.getString("Role");

						if (name.equals(UserName) && password.equals(DBpassword)) {
							if (role.equals("Manager")) {
								loginStatusLabel.setText("Logged in as " + role + " " + name);

								// show the main Scene !
								primaryStage.close();
								Driver driver = new Driver();
								driver.GetDBData();
								driver.start(new Stage());

								showAlert("Success", "Logged in as " + role + " " + name);
							} else if (role.equals("Employee")) {
								loginStatusLabel.setText("Logged in as " + role + " " + name);

								// show the main Scene !
								primaryStage.close();
								Driver driver = new Driver();
								EmployeeRestrict(driver);
								driver.GetDBData();
								driver.start(new Stage());

								showAlert("Success", "Logged in as " + role + " " + name);

							}

						} else {
							Alert alert = new Alert(Alert.AlertType.ERROR);
							loginStatusLabel.setText("invalid password or user");
							alert.setContentText("User Not Found");
						}
					}
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

//        	

		}
	}

	private void showAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	public void EmployeeRestrict(Driver driver) {

		driver.employeeI.setDisable(true);
		driver.employeeD.setDisable(true);
		driver.employeeU.setDisable(true);
		driver.EmployeeSoldItem.setDisable(true);
	}

	public static void main(String[] args) {
		launch(args);

	}

	public String getRole() {
		return this.role;

	}
}
