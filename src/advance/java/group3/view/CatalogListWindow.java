package advance.java.group3.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class CatalogListWindow {
	public Scene scene;
	
	public CatalogListWindow(){
		BorderPane borderPane = new BorderPane();
		Label browseCatalogLabel = new Label("Browse Catalog");
		browseCatalogLabel.setAlignment(Pos.CENTER);
		borderPane.setTop(browseCatalogLabel);
		scene = new Scene(borderPane);
	}
	public Scene getScene(){
		return scene;
	}
}
