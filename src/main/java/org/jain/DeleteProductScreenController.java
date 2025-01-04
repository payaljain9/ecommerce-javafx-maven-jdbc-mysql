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

public class DeleteProductScreenController {
	@FXML
	TextField pidtxt;
	
	@FXML
	Button deletebtn;
	
	@FXML
	Button resetbtn;
	
	public void resetbtnClick()
	{
		pidtxt.setText("");
	}
	
	public void deletebtnClick() throws Exception
	{
		//establishing connection with db
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/managment","root","Payal@j9067");
		//creating stmt obj 
		Statement stmt=con.createStatement();
		//resultset to store fetched records(reference variable)
		ResultSet resultset;
		
		int pid=Integer.parseInt(pidtxt.getText());
		
		resultset=stmt.executeQuery("select * from product where id="+pid+"");
		
		if(resultset.next())
		{
			stmt.executeUpdate("delete from product where id="+pid+"");
			System.out.println("Product Deleted Successfully..!");
		}
		else
		{
			System.out.println("Product Not Available..!");
		}
		pidtxt.setText("");
		
	} 
}
