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

public class SearchProductScreenController {
	@FXML
	TextField pnametxt;
	
	@FXML
	TextField pidtxt;
	
	@FXML
	TextField ppricetxt;
	
	@FXML
	TextField pquantitytxt;
	
	@FXML
	Button searchbtn;
	
	@FXML
	Button resetbtn;
	
	public void resetbtnClick()
	{
		pnametxt.setText("");
		pidtxt.setText("");
		ppricetxt.setText("");
		pquantitytxt.setText("");
	}
	
	public void searchbtnClick() throws Exception
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
			int pprice=resultset.getInt(3);
			int pquantity=resultset.getInt(4);
			String pname=resultset.getString(2);
			
			System.out.println("Product Infomation Available..!");
			ppricetxt.setText(Integer.toString(pprice));
			pquantitytxt.setText(String.valueOf(pquantity));
			pnametxt.setText(pname);
		}
		else
		{
			System.out.println("Product Not Available..!");
			pnametxt.setText("");
			pidtxt.setText("");
			ppricetxt.setText("");
			pquantitytxt.setText("");
		}
	}
}
