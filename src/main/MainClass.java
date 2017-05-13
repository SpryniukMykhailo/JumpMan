package main;

import controller.GameController;
import controller.MainMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class MainClass extends Application {
    private Stage primaryStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        showMainMenu();
    }

    private void showMainMenu() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getResource("/view/MainMenu.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            MainMenuController controller = loader.getController();
            controller.setMainClass(this);

            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {e.printStackTrace();}
    }

    public void showNewGamePage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainClass.class.getResource("/view/NewGame.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("New Game");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            GameController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setMainClass(this);

            dialogStage.showAndWait();

        } catch (IOException e) {e.printStackTrace();}
    }
    public void closeMainMenu() {
        primaryStage.close();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
