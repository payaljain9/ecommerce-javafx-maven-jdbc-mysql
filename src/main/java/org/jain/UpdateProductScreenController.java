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

public class UpdateProductScreenController {
	@FXML
	TextField pnametxt;
	
	@FXML
	TextField pidtxt;
	
	@FXML
	TextField ppricetxt;
	
	@FXML
	TextField pquantitytxt;
	
	@FXML
	Button updatebtn;
	
	@FXML
	Button resetbtn;
	
	public void resetbtnClick()
	{
		pnametxt.setText("");
		pidtxt.setText("");
		ppricetxt.setText("");
		pquantitytxt.setText("");
	}
	
	public void updatebtnClick() throws Exception
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
		
		resultset=stmt.executeQuery("select * from product where id="+pid+"");
		
		if(resultset.next())
		{
			stmt.executeUpdate("update product set name='"+pname+"',price="+pprice+", quantity="+pquantity+" where id="+pid+"  ");
			System.out.println("Product Infomation Updated Successfully..!");
		}
		else
		{
			System.out.println("Product Not Available..!");
		}
		pnametxt.setText("");
		pidtxt.setText("");
		ppricetxt.setText("");
		pquantitytxt.setText("");
		
	}
}
