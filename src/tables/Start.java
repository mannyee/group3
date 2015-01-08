package tables;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Start extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Welcome Page");
				
		VBox topContainer = new VBox();
		MenuBar mainMenu = new MenuBar();
		Text label = new Text("E-Bazaar");
		label.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 60));
		label.setFill(Color.DARKRED);
		
		HBox labelBox = new HBox(10);
		labelBox.setAlignment(Pos.CENTER);
		labelBox.getChildren().add(label);
		labelBox.setId("ebazzar"); 
		
		topContainer.getChildren().add(mainMenu);
		topContainer.getChildren().add(labelBox);

		Menu custMenu = new Menu("Customer");
		MenuItem onlinePurchase = new MenuItem("Online Purchase");
		onlinePurchase.setOnAction(evt -> {	
			CatalogListWindow catalogs = new CatalogListWindow(primaryStage);
	        catalogs.setData(DefaultData.CATALOG_LIST_DATA);
	        catalogs.show();  
	        primaryStage.hide();
					
		});
		MenuItem reviewOrder = new MenuItem("Review Orders");
	    MenuItem retrieveCart = new MenuItem("Retrieve Saved Cart");
	    
		MenuItem exitApp = new MenuItem("Exit");
		exitApp.setOnAction(evt -> Platform.exit());
			
		custMenu.getItems().addAll(onlinePurchase, reviewOrder, retrieveCart, exitApp);

		//did not add menu item for menu edit
		Menu adminMenu = new Menu("Administrator");
		MenuItem productCatalog = new MenuItem("Maintain Product Catalog");
		MenuItem catalogType = new MenuItem("Maintain Catalog Types");
		adminMenu.getItems().addAll(productCatalog, catalogType);
		mainMenu.getMenus().addAll(custMenu, adminMenu);
		
		
		productCatalog.setOnAction(evt -> {
			primaryStage.hide();
			ProductCatalog pc = new ProductCatalog();
			pc.show();
			
		});

		Scene scene = new Scene(topContainer, 400, 300);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
