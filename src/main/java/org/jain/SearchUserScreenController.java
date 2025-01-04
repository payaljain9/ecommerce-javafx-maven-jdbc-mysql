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

public class SearchUserScreenController {
	@FXML
	TextField useridtxt;
	
	@FXML
	TextField passwordtxt;
	
	@FXML
	TextField usernametxt;
	
	@FXML
	TextField emailtxt;
	
	@FXML
	Button deletebtn;
	
	@FXML
	Button resetbtn;
	
	public void resetbtnClick()
	{
		useridtxt.setText("");
		passwordtxt.setText("");
		usernametxt.setText("");
		emailtxt.setText("");
	}
	
	public void searchbtnClick() throws Exception
	{
		//establishing connection with db
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/managment","root","Payal@j9067");
		//creating stmt obj 
		Statement stmt=con.createStatement();
		//resultset to store fetched records(reference variable)
		ResultSet resultset;
						
		int userid=Integer.parseInt(useridtxt.getText());
		
	    resultset=stmt.executeQuery("select * from user where id="+userid+"");
	    
	    if(resultset.next())
	    {
	    	System.out.println("User Records Available..!");
	    	usernametxt.setText(resultset.getString(2));
	    	passwordtxt.setText(resultset.getString(3));
	    	emailtxt.setText(resultset.getString(4));
	    }
	    else
	    {
	    	System.out.println("User With "+userid+" UserID Does Not Exists..!");
	    	useridtxt.setText("");
	    }		
	}
}
