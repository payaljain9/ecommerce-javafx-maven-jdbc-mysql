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

public class AddProductScreenController {
	@FXML
	TextField pnametxt;
	
	@FXML
	TextField pidtxt;
	
	@FXML
	TextField ppricetxt;
	
	@FXML
	TextField pquantitytxt;
	
	@FXML
	Button addbtn;
	
	@FXML
	Button resetbtn;
	
	public void resetbtnClick()
	{
		pnametxt.setText("");
		pidtxt.setText("");
		ppricetxt.setText("");
		pquantitytxt.setText("");
	}
	
	public void addbtnClick() throws Exception
	{
		//establishing connection with db
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/managment","root","Payal@j9067");
		//creating stmt obj 
		Statement stmt=con.createStatement();
		//resultset to store fetched records(reference variable)
		ResultSet resultset;
		
		String pname=pnametxt.getText();
		int pid=Integer.parseInt(pidtxt.getText());
		int pprice=Integer.parseInt(ppricetxt.getText());
		int pquantity=Integer.parseInt(pquantitytxt.getText());
		
		stmt.executeUpdate("insert into product values("+pid+",'"+pname+"',"+pprice+","+pquantity+")");
		System.out.println("New Product Added Successfully..!");
		pnametxt.setText("");
		pidtxt.setText("");
		ppricetxt.setText("");
		pquantitytxt.setText("");
		
	}
}
