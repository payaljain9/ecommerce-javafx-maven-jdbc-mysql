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

public class DeleteUserScreenController {
	@FXML
	TextField useridtxt;
	
	@FXML
	Button deletebtn;
	
	@FXML
	Button resetbtn;
	
	public void resetbtnClick()
	{
		useridtxt.setText("");
	}
	
	public void deletebtnClick() throws Exception
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
	    	stmt.executeUpdate("delete from user where id="+userid+"");
	    	System.out.println("User Details Deleted Successfully..!");
	    	useridtxt.setText("");
	    }
	    else
	    {
	    	System.out.println("User With "+userid+" UserID Does Not Exists..!");
	    	useridtxt.setText("");
	    }
				
	}
}
