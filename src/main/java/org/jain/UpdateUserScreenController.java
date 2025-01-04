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

public class UpdateUserScreenController {
	@FXML
	TextField useridtxt;
	
	@FXML
	TextField usernametxt;
	
	@FXML
	TextField emailtxt;
	
	@FXML
	TextField passwordtxt;
	
	@FXML
	Button savebtn;
	
	@FXML
	Button resetbtn;
	
	public void resetbtnClick()
	{
		useridtxt.setText("");
		usernametxt.setText("");
		emailtxt.setText("");
		passwordtxt.setText("");
	}
	public void savebtnClick() throws Exception
	{
		//establishing connection with db
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/managment","root","Payal@j9067");
		//creating stmt obj 
		Statement stmt=con.createStatement();
		//resultset to store fetched records(reference variable)
		ResultSet resultset;
		
		String username=usernametxt.getText();
		String password=passwordtxt.getText();
		String email=emailtxt.getText();
		int id=Integer.parseInt(useridtxt.getText());
		resultset=stmt.executeQuery("select name, password, email from user where id="+id+"");
		
		if(resultset.next())
		{
			stmt.executeUpdate("update user set name='"+username+"', password='"+password+"', email='"+email+"' where id="+id+"");
			System.out.println("User Details Updated Successfully..!");
		}
		else
		{
			System.out.println(username+" User With ID "+id+" Does Not Exists..!");
		}
		
		useridtxt.setText("");
		usernametxt.setText("");
		emailtxt.setText("");
		passwordtxt.setText("");
	}
	
}
