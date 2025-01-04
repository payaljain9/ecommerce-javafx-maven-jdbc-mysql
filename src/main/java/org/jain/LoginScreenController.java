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

public class LoginScreenController {
	int temp=0;
	
	@FXML
	TextField usernametxt;
	
	@FXML
	TextField passwordtxt;
	
	@FXML
	Button loginbtn;
	
	public void resetbtnClick()
	{
		usernametxt.setText("");
		passwordtxt.setText("");
	}
	
	public void loginbtnClick() throws Exception
	{
		//establishing connection with db
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/managment","root","Payal@j9067");
		//creating stmt obj 
		Statement stmt=con.createStatement();
		//resultset to store fetched records(reference variable)
		ResultSet resultset;
		
		String username=usernametxt.getText();
		String password=passwordtxt.getText();
		
		resultset=stmt.executeQuery("Select * from login");
		if(resultset.next())
		{
			String usernamedb=resultset.getString(1);
			String passworddb=resultset.getString(2);
			if((username.equals(usernamedb)) && (password.equals(passworddb)))
			{
				temp=1;
			}
		}
		
		if(temp==1)
		{
			System.out.println("Login Successfully..!");
			
			usernametxt.setText("");
			passwordtxt.setText("");
		}
		else
		{
			System.out.println("Invalid Username/Password..!");
			usernametxt.setText("");
			passwordtxt.setText("");
		}
		
	}
}
