package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			MenuBar menuBar = new MenuBar();
		    final Menu fileMenu = new Menu("File");
		    menuBar.getMenus().add(fileMenu);
		    
			GridPane grid = new GridPane();
			
			grid.add(menuBar, 0, 0);
			Scene scene = new Scene(grid,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
