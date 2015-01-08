package tables;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MaintainCatalogTypes extends Stage {
	private TableView<Catalog> table = new TableView<Catalog>();
	Stage primaryStage;
	Catalog selected;

	Stage dialogStage;

	int selectdIndex;

	public void setData(ObservableList<Catalog> cats) {
		table.setItems(cats);
	}

	@SuppressWarnings("unchecked")
	public MaintainCatalogTypes(Stage ps) {
		primaryStage = ps;
		setTitle("Maintain Catalogs Types");

		final Label label = new Label("Maintain Catalogs Types");
		label.getStyleClass().add("custom-tile-font-style");
//		label.setFont(new Font("Arial", 16));
		HBox labelHbox = new HBox(10);
		labelHbox.setAlignment(Pos.CENTER);
		labelHbox.getChildren().add(label);

		TableColumn<Catalog, String> catalogNameCol = new TableColumn<>(
				"Name of Category Group");
		catalogNameCol.setMinWidth(250);
		catalogNameCol
				.setCellValueFactory(new PropertyValueFactory<Catalog, String>(
						"name"));
		catalogNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.getColumns().addAll(catalogNameCol);

		Button addBtn = new Button("Add");
		Button editBtn = new Button("Edit");
		Button deleteBtn = new Button("Delete");
		Button backBtn = new Button("Back");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.add(labelHbox, 0, 0);
		grid.add(table, 0, 1);

		HBox btnBox = new HBox(10);
		btnBox.setPadding(new Insets(0,0,10,0));
		btnBox.setAlignment(Pos.CENTER);
		btnBox.getChildren().add(addBtn);
		btnBox.getChildren().add(editBtn);
		btnBox.getChildren().add(deleteBtn);
		btnBox.getChildren().add(backBtn);
		grid.add(btnBox, 0, 3);

		addBtn.setOnAction(evt -> {
			selected = table.getSelectionModel().getSelectedItem();
			selectdIndex = table.getSelectionModel().getSelectedIndex();
			editAddMsgBox("Add Catalog","Please input new catalog name ", "add");
		});

		editBtn.setOnAction(evt -> {
			selected = table.getSelectionModel().getSelectedItem();
			selectdIndex = table.getSelectionModel().getSelectedIndex();
			editAddMsgBox("Edit Catalog","Please input new catalog name " + "instead of "
					+ selected.getName(), "edit");
		});

		deleteBtn.setOnAction(evt -> {

			selected = table.getSelectionModel().getSelectedItem();
			selectdIndex = table.getSelectionModel().getSelectedIndex();

			deleteMsgBox("Do you want to delete" + " " + selected.getName()
					+ " catalog?");

		});

		backBtn.setOnAction(evt -> {
			primaryStage.show();
			hide();
		});

		Scene scene = new Scene(grid, 400, 250);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		setScene(scene);
	}

	public void deleteMsgBox(String title) {
		dialogStage = new Stage();
		GridPane grd_pan = new GridPane();
		grd_pan.setAlignment(Pos.CENTER);
		grd_pan.setHgap(10);
		grd_pan.setVgap(10);// pading
		Scene scene = new Scene(grd_pan, 300, 150);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		dialogStage.setScene(scene);
		dialogStage.setTitle("Remove Catalog");
		dialogStage.initModality(Modality.APPLICATION_MODAL);

		Label lab_alert = new Label(title);
		grd_pan.add(lab_alert, 0, 0);

		Button okBtn = new Button("Ok");
		okBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dialogStage.hide();

				DefaultData.CATALOG_LIST_DATA.remove(selectdIndex);

			}
		});

		Button cancelBtn = new Button("Cancel");
		cancelBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dialogStage.hide();

			}
		});
		HBox box = new HBox(10);
		box.getChildren().addAll(okBtn, cancelBtn);

		grd_pan.add(box, 0, 2);

		dialogStage.show();

	}

	public void editAddMsgBox(String title,String textLbl, String type) {
		dialogStage = new Stage();
		GridPane grd_pan = new GridPane();
		grd_pan.setAlignment(Pos.CENTER);
		grd_pan.setHgap(10);
		grd_pan.setVgap(10);// pading
		Scene scene = new Scene(grd_pan, 300, 150);
		scene.getStylesheets().add(
				getClass().getResource("style.css").toExternalForm());
		dialogStage.setScene(scene);
		dialogStage.setTitle(title);
		dialogStage.initModality(Modality.APPLICATION_MODAL);

		Label lab_alert = new Label(textLbl);
		grd_pan.add(lab_alert, 0, 0);

		TextField nameTF = new TextField();
		grd_pan.add(nameTF, 0, 1);
		
		final Text errorMsg = new Text();
		errorMsg.getStyleClass().add("error-font-style");
		errorMsg.setFill(Color.RED);
		Button okBtn = new Button("Ok");
		okBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				

				String name = nameTF.getText().toString();

				if (name.length() > 0) {

					if (type.equals("edit")) {
						List<Product> oldProduct =  DefaultData.PRODUCT_LIST_DATA.get(DefaultData.CATALOG_LIST_DATA.get(selectdIndex));
						DefaultData.CATALOG_LIST_DATA.remove(selectdIndex);
						
						Catalog newCatalog = new Catalog(name);
						DefaultData.CATALOG_LIST_DATA.add(selectdIndex,newCatalog);
						DefaultData.PRODUCT_LIST_DATA.put(newCatalog, oldProduct);
				
						dialogStage.hide();
					} else if (type.equals("add")) {
						boolean check = DefaultData.CATALOG_LIST_DATA.stream().filter((Catalog c) -> c.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).size() > 0;
						if(check){
							errorMsg.setText("Catalog already present");
						}else{
							DefaultData.CATALOG_LIST_DATA.add(new Catalog(name));
							dialogStage.hide();
						}
					}

				}

			}
		});

		Button cancelBtn = new Button("Cancel");
		cancelBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dialogStage.hide();

			}
		});
		HBox box = new HBox(10);
		box.getChildren().addAll(okBtn, cancelBtn);

		grd_pan.add(errorMsg, 0, 3);
		grd_pan.add(box, 0, 4);

		dialogStage.show();

	}

}
