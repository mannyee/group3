package tables;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProductCatalog extends Stage {
	private TableView<Product> table = new TableView<Product>();
	private ComboBox<Catalog> comboBox;
	private TableColumn<Product, String> catalogName;
	private TableColumn<Product, String> mfgDate;
	private TableColumn<Product, Double> unitPrice;
	private Label label;
	private TableColumn<Product, Integer> quantity;
	private Button btnAdd;
	private Button btnEdit;
	private Button btnDelete;
	private Button btnSearch;
	private Button btnBack;
	private HBox btnBox;
	private GridPane grid;
	private ProductListWindow productList;
	
	
	@SuppressWarnings("unchecked")
	public ProductCatalog() {
		
		label = new Label("Maintain Product Catalog");
        label.setFont(new Font("Arial", 16));
        HBox labelHbox = new HBox(10);
        labelHbox.setAlignment(Pos.CENTER);
        labelHbox.getChildren().add(label);
        
        
        
		comboBox = new ComboBox<Catalog>();
		comboBox.getItems().setAll(DefaultData.CATALOG_LIST_DATA);
		comboBox.setValue(DefaultData.CATALOG_LIST_DATA.get(0));
		
		

		catalogName = new TableColumn<>();
		catalogName.setMinWidth(250);
		catalogName.setCellValueFactory(new PropertyValueFactory<Product, String>(
				"productName"));
		catalogName.setCellFactory(TextFieldTableCell.forTableColumn());
		
		mfgDate = new TableColumn<>();
		mfgDate.setMinWidth(250);
		mfgDate.setCellValueFactory(new PropertyValueFactory<Product, String>(
				"mfgDate"));
		mfgDate.setCellFactory(TextFieldTableCell.forTableColumn());
		
		
		unitPrice = new TableColumn<>();
		unitPrice.setMinWidth(250);
		unitPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>(
				"unitPrice"));
//		unitPrice.setCellFactory(TextFieldTableCell.forTableColumn());
		
		
		quantity = new TableColumn<>();
		quantity.setMinWidth(250);
		quantity.setCellValueFactory(new PropertyValueFactory<Product, Integer>(
				"quantityAvail"));
//		quantity.setCellFactory(TextFieldTableCell.forTableColumn());
		
		table.getColumns().addAll(catalogName, mfgDate, unitPrice, quantity);

		

		table.setItems(FXCollections.observableArrayList(DefaultData.PRODUCT_LIST_DATA.get(DefaultData.CATALOG_LIST_DATA.get(0))));
		
		comboBox.setOnAction(evt -> {
			
			System.out.println("model: " + comboBox.getSelectionModel().getSelectedItem());
			Catalog c = comboBox.getSelectionModel().getSelectedItem();
			table.setItems(FXCollections.observableArrayList(DefaultData.PRODUCT_LIST_DATA.get(c)));
			
			
		});
		
		
		
			
		
						        
		
		btnAdd = new Button("Add");
		btnEdit = new Button("Edit");
		btnDelete = new Button ("Delete");
		btnSearch = new Button("Search");
		btnBack = new Button("Back to Main");
		
		btnBox = new HBox(10);
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().addAll(btnAdd, btnEdit, btnDelete, btnSearch, btnBack);
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10); 
		grid.setHgap(10);
		grid.add(labelHbox, 0, 0);
		grid.add(comboBox, 0, 1);
		grid.add(table, 0, 2);
		grid.add(btnBox,0,3);
		
        
		btnBack.setOnAction(evt -> {
			productList.show();
			hide();
		});
	

        
		btnAdd.setOnAction(evt -> {
			hide();
			AddProduct add = new AddProduct();
			add.show();
		});
        
		
		btnEdit.setOnAction(evt -> {
			Product p = table.getSelectionModel().getSelectedItem();
			
			if(p == null){
				final Stage dialogStage = new Stage();
				dialogStage.initModality(Modality.WINDOW_MODAL);

                Label msg = new Label("Please select a row first!!");
                msg.setAlignment(Pos.CENTER);
                
                Button btnOk = new Button("Ok");
                
                
                dialogStage.show();

                
                btnOk.setOnAction(e -> {
                	dialogStage.close();
                });
                
                HBox hBox = new HBox();
                hBox.setAlignment(Pos.CENTER);
                hBox.setSpacing(40.0);
                hBox.getChildren().addAll(msg, btnOk);

                VBox vBox = new VBox();
                vBox.setSpacing(40.0);
                vBox.getChildren().addAll(msg, btnOk); 
                
                GridPane grid1 = new GridPane();
                grid1.setAlignment(Pos.CENTER);
                grid.setVgap(10); 
        		grid.setHgap(10);
               /* grid1.add(msg, 0, 0);
                grid1.add(btnOk, 0, 1);*/
                
//                grid1.add(msg, 0, 0);
//                grid1.add(btnOk, 0, 1);
                
                dialogStage.setScene(new Scene(vBox, 350, 200));
                dialogStage.show();
                
                
            }else{
            	
            	EditProduct ep = new EditProduct(p, comboBox.getSelectionModel().getSelectedItem());
            	ep.show();
            	
            	// hide product catalog
            	hide();
            	
            }
		});
		
		
		btnDelete.setOnAction(evt -> {
			Product p = table.getSelectionModel().getSelectedItem();
			Iterator<Product> list = DefaultData.PRODUCT_LIST_DATA.get(comboBox.getSelectionModel().getSelectedItem()).iterator();
			
			while (list.hasNext()){
				Product prod = list.next();
				
				if(prod.getProductName().equals(p.getProductName())){
					list.remove();
				}
					
			}
			
			
			List<Product> lp = DefaultData.PRODUCT_LIST_DATA.get(comboBox.getSelectionModel().getSelectedItem());
			DefaultData.PRODUCT_LIST_DATA.put(comboBox.getSelectionModel().getSelectedItem(), lp);
			
			
		});
        
   
        Scene scene = new Scene(grid,300, 250);  
		setScene(scene);
	}
}
