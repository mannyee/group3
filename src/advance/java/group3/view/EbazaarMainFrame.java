package advance.java.group3.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class EbazaarMainFrame extends Application {

	 double screenWidth = Screen.getPrimary().getBounds().getWidth();
	 double screenHeight = Screen.getPrimary().getBounds().getHeight() - 100;

//	double screenWidth = 600;   
//	double screenHeight = 600;

	Stage primaryStage;
	Scene scene;
	//bikram

	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;

			primaryStage.setTitle("E-Bazzar Online Shopping Application");

			AnchorPane anchorPane = new AnchorPane();

			createMenuAndMenuItems(anchorPane);

			scene = new Scene(anchorPane);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setWidth(screenWidth);
			primaryStage.setHeight(screenHeight);
			primaryStage.setResizable(false);

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createMenuAndMenuItems(AnchorPane anchorPane){
		MenuBar menuBar = new MenuBar();
		
		
	    final Menu customerMenu = new Menu("Customer");
	    menuBar.getMenus().add(customerMenu);
	    
	    final Menu administratorMenu = new Menu("Administrator");
	    menuBar.getMenus().add(administratorMenu);
	    
	    final MenuItem onlinePurchaseCustomerMenuItem = new MenuItem("Online Purchase");
	    final MenuItem reviewOrderCustomerMenuItem = new MenuItem("Review Orders");
	    final MenuItem retrieveCartCustomerMenuItem = new MenuItem("Retrieve Saved Cart");
	    final MenuItem exitCustomerMenuItem = new MenuItem("Exit");
	    //adding menu items to customerMenu
	    customerMenu.getItems().addAll(onlinePurchaseCustomerMenuItem,reviewOrderCustomerMenuItem,retrieveCartCustomerMenuItem,exitCustomerMenuItem);
	    
	    final MenuItem productCatalogAdministratorMenuItem = new MenuItem("Maintain Product Catalog");
	    final MenuItem catalogTypeAdministratorMenuItem = new MenuItem("Maintain Catalog Types");
	    //adding menu items to administratorMenu
	    administratorMenu.getItems().addAll(productCatalogAdministratorMenuItem, catalogTypeAdministratorMenuItem);
	  
	    //for full width of menubar
	    AnchorPane.setTopAnchor(menuBar, 0.0);
        AnchorPane.setLeftAnchor(menuBar, 0.0);
        AnchorPane.setRightAnchor(menuBar, 0.0);
		
		anchorPane.getChildren().add(menuBar);
		
		
		onlinePurchaseCustomerMenuItem.setOnAction(evt -> primaryStage.setScene(new CatalogListWindow().getScene()));
		
		exitCustomerMenuItem.setOnAction(evt -> Platform.exit());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
