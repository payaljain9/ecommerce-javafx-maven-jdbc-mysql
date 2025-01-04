package org.jain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddUserScreenController {
	@FXML
	TextField usernametxt;
	
	@FXML
	TextField useridtxt;
	
	@FXML
	TextField passwordtxt;
	
	@FXML
	TextField emailtxt;
	
	@FXML
	Button addbtn;
	
	@FXML
	Button resetbtn;
	
	public void resetbtnClick()
	{
		usernametxt.setText("");
		passwordtxt.setText("");
		useridtxt.setText("");
		emailtxt.setText("");
	}
	
	public void addbtnClick() throws Exception
	{
		//establishing connection with db
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/managment","root","Payal@j9067");
		//creating stmt obj 
		Statement stmt=con.createStatement();
		//resultset to store fetched records(reference variable)
		ResultSet resultset;
		
		String username=usernametxt.getText();
		String password=passwordtxt.getText();
		int userid=Integer.parseInt(useridtxt.getText());
		String email=emailtxt.getText();
		
		stmt.executeUpdate("insert into user values("+userid+",'"+username+"','"+password+"','"+email+"')");
		
		System.out.println("New User Added Successfully..!");
		usernametxt.setText("");
		passwordtxt.setText("");
		useridtxt.setText("");
		emailtxt.setText("");
	}
}
