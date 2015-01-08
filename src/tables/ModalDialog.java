package tables;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModalDialog {

	final Stage dialogStage = new Stage();
	
	public ModalDialog(){
		dialogStage.initModality(Modality.APPLICATION_MODAL);

	    Label msg = new Label("Please select a row first!!");
	    HBox hBoxMsg = new HBox(10);
	    hBoxMsg.setAlignment(Pos.CENTER);
	    hBoxMsg.getChildren().add(msg);
	    
	    Button btnOk = new Button("Ok");
	    HBox hBtn = new HBox(20);
	    hBtn.setAlignment(Pos.CENTER);
	    hBtn.getChildren().add(btnOk);
	    
	    
	    
	    btnOk.setOnAction(e -> {
	    	dialogStage.close();
	    });
	    

	    GridPane grid1 = new GridPane();
	    grid1.setAlignment(Pos.CENTER);
	    grid1.setVgap(10); 
		grid1.setHgap(10);
	    grid1.add(hBoxMsg, 1, 1);
	    grid1.add(hBtn, 1, 4);
	    
	    Scene scene = new Scene(grid1, 350, 200);
	    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
	    dialogStage.setScene(scene);
	    dialogStage.setAlwaysOnTop(true);
	    dialogStage.centerOnScreen();
//	    dialogStage.show();
	}
	
	public void show(){
		dialogStage.show();
	}
	
}
