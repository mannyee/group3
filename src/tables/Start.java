package tables;

import java.util.List;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
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

//bikram pradhab 

public class Start extends Application {
	Stage primaryStage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
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
		custMenu.getStyleClass().add("font-style");
		MenuItem onlinePurchase = new MenuItem("Online Purchase");

		/*
		 * onlinePurchase.setOnAction(evt -> { CatalogListWindow catalogs = new
		 * CatalogListWindow(primaryStage); //
		 * catalogs.setData(DefaultData.CATALOG_LIST_DATA); List<Catalog> filter
		 * = DefaultData.CATALOG_LIST_DATA.stream().filter( (Catalog c) ->
		 * DefaultData.PRODUCT_LIST_DATA.get(c) != null
		 * ).collect(Collectors.toList());
		 * catalogs.setData(FXCollections.observableList(filter) );
		 * catalogs.show(); primaryStage.hide();
		 * 
		 * });
		 */

		onlinePurchase.setOnAction(evt -> {
			openCatalogListWindow();
		});
		MenuItem reviewOrder = new MenuItem("Review Orders");
		reviewOrder.setOnAction(evt -> {
			ReviewOrdersWindow reviewOrders = new ReviewOrdersWindow(
					primaryStage);
			reviewOrders.show();
			primaryStage.hide();
		});
		MenuItem retrieveCart = new MenuItem("Retrieve Saved Cart");
		retrieveCart.setOnAction(evt -> {
			CartItems cartItems = new CartItems(this);
			cartItems.show();
			primaryStage.hide();
		});

		MenuItem exitApp = new MenuItem("Exit");
		exitApp.setOnAction(evt -> Platform.exit());

		custMenu.getItems().addAll(onlinePurchase, reviewOrder, retrieveCart,
				exitApp);

		// did not add menu item for menu edit
		Menu adminMenu = new Menu("Administrator");
		MenuItem productCatalog = new MenuItem("Maintain Product Catalog");
		MenuItem catalogType = new MenuItem("Maintain Catalog Types");
		adminMenu.getItems().addAll(productCatalog, catalogType);
		mainMenu.getMenus().addAll(custMenu, adminMenu);
		
		
		productCatalog.setOnAction(evt -> {
			primaryStage.hide();
			ProductCatalog pc = new ProductCatalog(primaryStage);
			pc.show();
			
		});

		// Maintain Catalog types event handle
		catalogType.setOnAction(evt -> {

			MaintainCatalogTypes maintainCatalogs = new MaintainCatalogTypes(
					primaryStage);
			maintainCatalogs.setData(DefaultData.CATALOG_LIST_DATA);
			maintainCatalogs.show();
			primaryStage.hide();

		});

		Scene scene = new Scene(topContainer, 400, 300);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void openCatalogListWindow() {
		CatalogListWindow catalogs = new CatalogListWindow(primaryStage);
		// catalogs.setData(DefaultData.CATALOG_LIST_DATA);
		List<Catalog> filter = DefaultData.CATALOG_LIST_DATA
				.stream()
				.filter((Catalog c) -> DefaultData.PRODUCT_LIST_DATA.get(c) != null
						&& DefaultData.PRODUCT_LIST_DATA.get(c).size() > 0)
				.collect(Collectors.toList());
		catalogs.setData(FXCollections.observableList(filter));
		catalogs.show();
		primaryStage.hide();
	}

}
