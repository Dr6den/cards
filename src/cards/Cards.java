package cards;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author andrew
 */
public class Cards extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Тестирование GUI-компонентов");
        Group root = new Group();
        Scene scene = new Scene(root, 744, 360, Color.DARKGREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
              
        File imageFile = new File("resources/images/pokertable.png");
        File backSideFile = new File("resources/images/PNG-cards-1.3/back_side.jpg");
        Image im = new Image(imageFile.toURI().toString());               
        ImageView imv = new ImageView(im);
        imv.setPreserveRatio(true);      
        
        List<ImageView> cardImages = new ArrayList<>();
        int num = 1;
        int deckPart = 0;
        while (num <= 52) {
            Image cardBackSide = new Image(backSideFile.toURI().toString());
            ImageView backSideImageView = new ImageView(cardBackSide);
            backSideImageView.setX(350 + deckPart);
            backSideImageView.setY(50 + deckPart);
            backSideImageView.setFitWidth(44);
            backSideImageView.setFitHeight(60);
            
            cardImages.add(backSideImageView);
            deckPart = (deckPart < 3) ? deckPart + 1 : 0;
            num++;
        }
        
        Button btnDeal = new Button();
        btnDeal.setLayoutX(40);
        btnDeal.setLayoutY(270);
        btnDeal.setText("Start dealing new cards");       
        btnDeal.setStyle("-fx-font: bold italic 10pt Georgia;-fx-text-fill: fuchsia;-fx-background-color: green;-fx-border-width: 1px; -fx-border-color:black");
        
        Button btnShow = new Button();
        btnShow.setLayoutX(580);
        btnShow.setLayoutY(270);
        btnShow.setText("Show cards");       
        btnShow.setStyle("-fx-font: bold italic 10pt Georgia;-fx-text-fill: fuchsia;-fx-background-color: green;-fx-border-width: 1px; -fx-border-color:black");
        
        root.getChildren().add(imv);
        root.getChildren().addAll(cardImages);
        root.getChildren().addAll(btnDeal, btnShow);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
