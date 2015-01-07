package tables;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProductListWindow extends Stage {
	private TableView<Product> table = new TableView<Product>();
	Stage primaryStage;
	Catalog selectedCatalog;
	CatalogListWindow catalogList;
	Product selectedProduct;
	
	public void setData(ObservableList<Product> prods) {
		table.setItems(prods);
	}
	@SuppressWarnings("unchecked")
	public ProductListWindow(CatalogListWindow list, Catalog catalog) {
		this.catalogList = list;
		this.selectedCatalog = catalog;
		setTitle("Product List");
		
		final Label label = new Label(String.format("Available %s", catalog.getName()));
        label.setFont(new Font("Arial", 16));
        HBox labelHbox = new HBox(10);
        labelHbox.setAlignment(Pos.CENTER);
        labelHbox.getChildren().add(label);
		
		TableColumn<Product, String> productNameCol 
		  = new TableColumn<>(String.format(catalog.getName()));
		productNameCol.setMinWidth(250);
		productNameCol.setCellValueFactory(
            new PropertyValueFactory<Product, String>("productName"));
		productNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		
		table.getColumns().addAll(productNameCol);
		
		Button viewButton = new Button("Select Product");
		Button backButton = new Button("Go Back to Catalogs");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10); 
		grid.setHgap(10);
		grid.add(labelHbox, 0, 0);
		grid.add(table, 0, 1);
		HBox btnBox = new HBox(10);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().add(viewButton);
		btnBox.getChildren().add(backButton);
		grid.add(btnBox,0,3);
		    
		backButton.setOnAction(evt -> {
			catalogList.show();
			hide();
		});
	

		viewButton.setOnAction(evt -> {
			selectedProduct = table.getSelectionModel().getSelectedItem();
			ProductDetailsWindow prodDetails = new ProductDetailsWindow(this, selectedProduct);
			hide();
			prodDetails.show();
		});
  
        Scene scene = new Scene(grid,300, 250);  
		setScene(scene);
	}
	
}
