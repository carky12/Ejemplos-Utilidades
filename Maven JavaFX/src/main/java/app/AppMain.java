package app;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/frmMain.fxml"));
			
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			
			primaryStage.setTitle("Ventana Principal");
			
			primaryStage.show();
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
