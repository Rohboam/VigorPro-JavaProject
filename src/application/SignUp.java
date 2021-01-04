package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class SignUp {
	@FXML
	private Button back1;
	
	@FXML
	private TextField fullname;
	
	@FXML
	private TextField txt_age;
	
	@FXML
	private TextField txt_username;
	
	@FXML
	private PasswordField txt_password;
	
	@FXML
	private Label signal;
	
	public void Register(ActionEvent event) {
		SqliteConnection.getInstance();
		Connection conn = SqliteConnection.Connector();
		try {
			String name = fullname.getText();
			String age = txt_age.getText();
			String username = txt_username.getText();
			String password = txt_password.getText();
			
			Statement statement = conn.createStatement();
			int status = statement.executeUpdate("insert into users (name, age, username, password)" + " values('" + name + age + username + password + "')");
			
			if (status > 0) {
				System.out.println("User registered!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void changescreentoMain(ActionEvent event) throws IOException {
		Parent new_root = FXMLLoader.load(getClass().getResource("vigorpro.fxml"));
		Scene new_rootscene = new Scene(new_root);
		
		// Getting Stage Information
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(new_rootscene);
		window.show();
		
	}
	
	public void sign_up_signal(ActionEvent event) {
		signal.setText("User Registered");
	}
}
