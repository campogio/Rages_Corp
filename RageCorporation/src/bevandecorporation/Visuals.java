package bevandecorporation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Visuals extends Application{

	
	public void start(Stage primaryStage) {
	        primaryStage.setTitle("Rage Corp Login");
	        
	        GridPane grid = new GridPane();
	        grid.setAlignment(Pos.CENTER);
	        grid.setHgap(10);
	        grid.setVgap(10);
	        grid.setPadding(new Insets(25, 25, 25, 25));
	        
	        
	        
	        Text scenetitle = new Text("Benvenuto");
	        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	        grid.add(scenetitle, 0, 0, 2, 1);

	        Label userName = new Label("User Name:");
	        grid.add(userName, 0, 1);

	        TextField userTextField = new TextField();
	        grid.add(userTextField, 1, 1);

	        Label pw = new Label("Password:");
	        grid.add(pw, 0, 2);

	        PasswordField pwBox = new PasswordField();
	        grid.add(pwBox, 1, 2);
	        
	        Button btnAd = new Button("Accesso Admin");
	        HBox hbBtnA = new HBox(10);
	        hbBtnA.setAlignment(Pos.BOTTOM_LEFT);
	        hbBtnA.getChildren().add(btnAd);
	        grid.add(hbBtnA, 0, 4);
	        
	        
	        
	        Button btnOp = new Button("Accesso Operatore");
	        HBox hbBtnO = new HBox(10);
	        hbBtnO.setAlignment(Pos.BOTTOM_RIGHT);
	        hbBtnO.getChildren().add(btnOp);
	        grid.add(hbBtnO, 1, 4);
	        
	        
	        final Text actiontarget = new Text();
	        grid.add(actiontarget, 1, 6);
	        
	        
	        btnOp.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	                actiontarget.setFill(Color.FIREBRICK);
	                actiontarget.setText("Accesso come Operatore");
	                
	                LogOperatore(userName.getText(),pw.getText());
	                
	                
	            }
	        });
	        
	        
	        btnAd.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	                actiontarget.setFill(Color.FIREBRICK);
	                actiontarget.setText("Accesso come Amministratore");
	                
	                LogAmministratore(userName.getText(),pw.getText());

	                
	                
	            }
	        });
	        

	        Scene scene = new Scene(grid, 300, 275);
	        primaryStage.setScene(scene);
	        
	        primaryStage.show();
	    }
	
	private void LogAmministratore(String nome,String psw) {
		
        StackPane secondaryLayout = new StackPane();
		
		Scene adminScene = new Scene(secondaryLayout, 300, 275);
		
		 // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Dashboard Amministratore");
        newWindow.setScene(adminScene);
        
        newWindow.show();
		
	}
	
	private void LogOperatore(String nome,String psw) {
		
		GridPane secondaryLayout = new GridPane();
		
		secondaryLayout.setAlignment(Pos.CENTER);
		secondaryLayout.setHgap(10);
		secondaryLayout.setVgap(10);
		secondaryLayout.setPadding(new Insets(25, 25, 25, 25));
		
		Text scenetitle = new Text("Dashboard Operatore");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        secondaryLayout.add(scenetitle, 0, 0, 2, 1);
		
		
        Button btnSt = new Button("Storico Ordini");
        HBox hbBtnSt = new HBox(10);
        hbBtnSt.setAlignment(Pos.BOTTOM_LEFT);
        hbBtnSt.getChildren().add(btnSt);
        secondaryLayout.add(hbBtnSt, 0, 2);
        
        
        Button btnOr = new Button("Ordine Attuale");
        HBox hbBtnOr = new HBox(10);
        hbBtnOr.setAlignment(Pos.BOTTOM_LEFT);
        hbBtnOr.getChildren().add(btnOr);
        secondaryLayout.add(hbBtnOr, 2, 2);
        
        
        Button btnStat = new Button("Stato Ordine");
        HBox hbBtnStat = new HBox(10);
        hbBtnStat.setAlignment(Pos.BOTTOM_LEFT);
        hbBtnStat.getChildren().add(btnStat);
        secondaryLayout.add(hbBtnStat, 2, 4);
        
		
		
		Scene opScene = new Scene(secondaryLayout, 300, 275);
		
		 // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Dashboard Operatore");
        newWindow.setScene(opScene);
        
        newWindow.show();
		
	}
	

}																							
