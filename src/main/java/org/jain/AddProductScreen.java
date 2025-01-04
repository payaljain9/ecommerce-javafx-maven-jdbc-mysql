package org.jain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddProductScreen extends Application{
	public static void main(String args[])
	{
		Application.launch();
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Stage stage=new Stage();
		stage.setTitle("Add Product Screen");
		
        Parent actorgroup=FXMLLoader.load(getClass().getResource("/Add Product.fxml"));
		
		Scene scene=new Scene(actorgroup,600, 400);
		stage.setScene(scene);
		
		stage.show();
	}
}
