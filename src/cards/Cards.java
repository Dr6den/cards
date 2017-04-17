package cards;

import cards.entity.Card;
import cards.entity.CardDeck;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
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
    private List<ImageView> topCardImages;
    private List<ImageView> bottomCardImages;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Тестирование GUI-компонентов");
        Group root = new Group();
        Scene scene = new Scene(root, 744, 360, Color.DARKGREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
              
        File imageFile = new File("resources/images/pokertable.png");
        Image im = new Image(imageFile.toURI().toString());               
        ImageView imv = new ImageView(im);
        imv.setPreserveRatio(true);
        root.getChildren().add(imv);
        
        CardDeck topDeck = new CardDeck();
        topDeck.getNewCardDeck();
        topCardImages = setUpTopDeck(topDeck, root);
        
        CardDeck bottomDeck = new CardDeck();
        
        /*final TranslateTransition ttJ = new TranslateTransition(Duration.millis(1500),cardImages.get(0));        
        ttJ.setCycleCount(2);
        ttJ.setByX(-100.0);
        ttJ.setToY(-170.0);
        ttJ.setAutoReverse(true);       
        
        final RotateTransition rtJ = new RotateTransition(Duration.millis(500),cardImages.get(0));
        rtJ.setByAngle(360);
        rtJ.setAxis(new Point3D(0.0, 0.0, 0.0));
        rtJ.setCycleCount(6);*/
        
        //final ParallelTransition ptJ = new ParallelTransition(cardImages.get(0),ttJ);        
        
        final Timeline timeline = new Timeline();
        timeline.setDelay(Duration.millis(100));
        
        Button btnDeal = new Button();
        btnDeal.setLayoutX(40);
        btnDeal.setLayoutY(270);
        btnDeal.setText("Start dealing new cards");       
        btnDeal.setStyle("-fx-font: bold italic 10pt Georgia;-fx-text-fill: fuchsia;-fx-background-color: green;-fx-border-width: 1px; -fx-border-color:black");
        btnDeal.setOnAction((ActionEvent event) -> {
                if (!timeline.getStatus().equals(Animation.Status.RUNNING)) {
                    List<TranslateTransition> topDeckTransitions = setUpTranslateTransitionsToTopDeck(topCardImages, bottomCardImages);
                    topDeckTransitions.stream().forEach((TranslateTransition tt) -> tt.play());                    
                    timeline.play();
                    bottomCardImages = topCardImages;
                    topCardImages = setUpTopDeck(topDeck, root);
                }
        });
        
        Button btnShow = new Button();
        btnShow.setLayoutX(580);
        btnShow.setLayoutY(270);
        btnShow.setText("Show cards");       
        btnShow.setStyle("-fx-font: bold italic 10pt Georgia;-fx-text-fill: fuchsia;-fx-background-color: green;-fx-border-width: 1px; -fx-border-color:black");
        
        root.getChildren().addAll(btnDeal, btnShow);
    }
    
    private List<ImageView> setUpTopDeck(CardDeck topCardDeck, Group group) {
        List<Card> cardsFromDeck = topCardDeck.getTo5CardsFromDeck();        
        List<ImageView> cardImages = new ArrayList<>();
        for (Card c:cardsFromDeck) {
            cardImages.add(c.getBackSide());
        }
        
        int deckPart = 0;
        for (ImageView cardImage:cardImages) {
            cardImage.setX(350 + deckPart);
            cardImage.setY(50 + deckPart);
            cardImage.setFitWidth(44);
            cardImage.setFitHeight(60);            
            deckPart++;
        }
        group.getChildren().addAll(cardImages);
        return cardImages;
    }
    
    private List<TranslateTransition> setUpTranslateTransitionsToTopDeck(List<ImageView> topCards, List<ImageView> bottomCards) {
        List<TranslateTransition> transitions = new ArrayList<>();
        
        if (!topCards.isEmpty()) {
            final TranslateTransition leftCardTransition = new TranslateTransition(Duration.millis(1000), topCards.get(0));
            leftCardTransition.setCycleCount(1);
            leftCardTransition.setByX(-105.0);
            leftCardTransition.setToY(85.0);
            leftCardTransition.setAutoReverse(false);
            transitions.add(leftCardTransition);

            final TranslateTransition leftCenterCardTransition = new TranslateTransition(Duration.millis(1000), topCards.get(1));
            leftCenterCardTransition.setCycleCount(1);
            leftCenterCardTransition.setByX(-55.0);
            leftCenterCardTransition.setToY(84.0);
            leftCenterCardTransition.setAutoReverse(false);
            transitions.add(leftCenterCardTransition);

            final TranslateTransition centerCardTransition = new TranslateTransition(Duration.millis(1000), topCards.get(2));
            centerCardTransition.setCycleCount(1);
            centerCardTransition.setByX(-3.0);
            centerCardTransition.setToY(83.0);
            centerCardTransition.setAutoReverse(false);
            transitions.add(centerCardTransition);

            final TranslateTransition rightCenterCardTransition = new TranslateTransition(Duration.millis(1000), topCards.get(3));
            rightCenterCardTransition.setCycleCount(1);
            rightCenterCardTransition.setByX(50.0);
            rightCenterCardTransition.setToY(82.0);
            rightCenterCardTransition.setAutoReverse(false);
            transitions.add(rightCenterCardTransition);

            if (topCards.size() > 4) {
                final TranslateTransition rightCardTransition = new TranslateTransition(Duration.millis(1000), topCards.get(4));
                rightCardTransition.setCycleCount(1);
                rightCardTransition.setByX(100.0);
                rightCardTransition.setToY(81.0);
                rightCardTransition.setAutoReverse(false);
                transitions.add(rightCardTransition);
            }
        }
        return transitions;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
