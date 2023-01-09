package Vista;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainLightConsume extends Application {
    
    private static double xOffset = 0, yOffset = 0;
    public static Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        MainLightConsume.stage = stage;
        Parent rootLoginUser = FXMLLoader.load(getClass().getResource("FXMLs/FXMLLoginUser.fxml"));
        Scene sceneLoginUser = new Scene(rootLoginUser);
        stage.initStyle(StageStyle.TRANSPARENT);
        
        MovementVoid(rootLoginUser, stage);
        stage.setScene(sceneLoginUser);
        stage.show();
        
    }
    
    public static void MovementVoid(Parent root, Stage stage){
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void setStage(URL a) throws IOException{
        Parent ParentRoot = (Parent)FXMLLoader.load(a);
        stage.setScene(new Scene(ParentRoot));
        MovementVoid(ParentRoot, stage);
    }
    
    public static void setStageT(URL a) throws IOException{
        Parent ParentRoot = (Parent)FXMLLoader.load(a);
        stage.setScene(new Scene(ParentRoot));
        stage.getScene().setFill(javafx.scene.paint.Color.TRANSPARENT);
        MovementVoid(ParentRoot, stage);
    }
}
