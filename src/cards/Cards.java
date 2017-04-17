package cards;

import cards.entity.Card;
import cards.entity.CardDeck;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author andrew
 */
public class Cards extends Application {
    private List<ImageView> topCardImages;
    private List<ImageView> bottomCardImages;
    private List<ImageView> frontCardImages;
    List<Card> playersCardsFromDeck;
    boolean isCardsWereOpened = false;
    
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
        playersCardsFromDeck = topDeck.getTo5CardsFromDeck();
        topCardImages = setUpTopDeck(playersCardsFromDeck, root);        
        bottomCardImages = new ArrayList<>();        
        
        final Timeline timeline = new Timeline();
        timeline.setDelay(Duration.millis(500));
        
        Button btnDeal = new Button();
        btnDeal.setLayoutX(40);
        btnDeal.setLayoutY(270);
        btnDeal.setText("Start dealing new cards");       
        btnDeal.setStyle("-fx-font: bold italic 10pt Georgia;-fx-text-fill: fuchsia;-fx-background-color: green;-fx-border-width: 1px; -fx-border-color:black");
        btnDeal.setOnAction((ActionEvent event) -> {Animation.Status status = timeline.getStatus();
                if (!timeline.getStatus().equals(Animation.Status.RUNNING)) {
                    List<TranslateTransition> topDeckTransitions = setUpTranslateTransitionsToDeck(topCardImages, bottomCardImages);
                    topDeckTransitions.stream().forEach((TranslateTransition tt) -> tt.play());                    
                    timeline.play();status = timeline.getStatus();
                    bottomCardImages = topCardImages;
                    playersCardsFromDeck = topDeck.getTo5CardsFromDeck();
                    topCardImages = setUpTopDeck(playersCardsFromDeck, root);
                    frontCardImages = setUpFrontCardImages(playersCardsFromDeck);
                }
        });
        
        Button btnShow = new Button();
        btnShow.setLayoutX(580);
        btnShow.setLayoutY(270);
        btnShow.setText("Show cards");       
        btnShow.setStyle("-fx-font: bold italic 10pt Georgia;-fx-text-fill: fuchsia;-fx-background-color: green;-fx-border-width: 1px; -fx-border-color:black");
        btnShow.setOnAction((ActionEvent event) -> {
            if (!isCardsWereOpened) {
                List<RotateTransition> rotateTransitions = setUpRotateToShowTheCards(bottomCardImages);
                rotateTransitions.stream().forEach((RotateTransition rt) -> rt.play());
                if (frontCardImages != null) {
                    root.getChildren().addAll(frontCardImages);
                }
                isCardsWereOpened = true;
            } else {
                List<RotateTransition> rotateTransitions = setUpRotateToShowTheCards(bottomCardImages);
                rotateTransitions.stream().forEach((RotateTransition rt) -> rt.play());
                root.getChildren().removeAll(frontCardImages);
                isCardsWereOpened = false;
            }
        });
        
        root.getChildren().addAll(btnDeal, btnShow);
    }
    
    private List<ImageView> setUpTopDeck(List<Card> cardsFromDeck, Group group) {      
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
    
    private List<ImageView> setUpFrontCardImages(List<Card> cardsFromDeck) {
        List<ImageView> cardImages = new ArrayList<>();
        for (Card c:cardsFromDeck) {
            cardImages.add(c.getFrontSide());
        }
        
        int rightReplacementStep = 0;
        for (ImageView cardImage:cardImages) {
            cardImage.setX(245 + rightReplacementStep);
            cardImage.setY(133);
            cardImage.setFitWidth(44);
            cardImage.setFitHeight(60);
            rightReplacementStep = rightReplacementStep + 52;
        }
        return cardImages;
    }
    
    private List<RotateTransition> setUpRotateToShowTheCards(List<ImageView> bottomCards) {
        List<RotateTransition> transitions = new ArrayList<>();
        
        for (ImageView image:bottomCards) {
            final RotateTransition backTransition = new RotateTransition(Duration.millis(400), image);
            backTransition.setByAngle(90);
            backTransition.setAxis(new Point3D(0.0, 1.0, 0.0));
            backTransition.setCycleCount(1);
            transitions.add(backTransition);
        }       
        return transitions;
    }
    
    private List<RotateTransition> setUpRotateToCloseTheCards(List<ImageView> bottomCards) {
        List<RotateTransition> transitions = new ArrayList<>();
        
        for (ImageView image:bottomCards) {
            final RotateTransition backTransition = new RotateTransition(Duration.millis(400), image);
            backTransition.setByAngle(90);
            backTransition.setAxis(new Point3D(0.0, 1.0, 0.0));
            backTransition.setCycleCount(1);
            transitions.add(backTransition);
        }       
        return transitions;
    }
    
    private List<TranslateTransition> setUpTranslateTransitionsToDeck(List<ImageView> topCards, List<ImageView> bottomCards) {
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
        
        if (!bottomCards.isEmpty()) {
            final TranslateTransition leftBottomCardTransition = new TranslateTransition(Duration.millis(1000), bottomCards.get(0));
            leftBottomCardTransition.setCycleCount(1);
            leftBottomCardTransition.setByX(105.0);
            leftBottomCardTransition.setToY(160.0);
            leftBottomCardTransition.setAutoReverse(false);
            transitions.add(leftBottomCardTransition);
            
            final TranslateTransition leftCenterBottomCardTransition = new TranslateTransition(Duration.millis(1000), bottomCards.get(1));
            leftCenterBottomCardTransition.setCycleCount(1);
            leftCenterBottomCardTransition.setByX(55.0);
            leftCenterBottomCardTransition.setToY(160.0);
            leftCenterBottomCardTransition.setAutoReverse(false);
            transitions.add(leftCenterBottomCardTransition);

            final TranslateTransition centerBottomCardTransition = new TranslateTransition(Duration.millis(1000), bottomCards.get(2));
            centerBottomCardTransition.setCycleCount(1);
            centerBottomCardTransition.setByX(3.0);
            centerBottomCardTransition.setToY(160.0);
            centerBottomCardTransition.setAutoReverse(false);
            transitions.add(centerBottomCardTransition);

            final TranslateTransition rightCenterBottomCardTransition = new TranslateTransition(Duration.millis(1000), bottomCards.get(3));
            rightCenterBottomCardTransition.setCycleCount(1);
            rightCenterBottomCardTransition.setByX(-50.0);
            rightCenterBottomCardTransition.setToY(160.0);
            rightCenterBottomCardTransition.setAutoReverse(false);
            transitions.add(rightCenterBottomCardTransition);

            if (bottomCards.size() > 4) {
                final TranslateTransition rightBottomCardTransition = new TranslateTransition(Duration.millis(1000), bottomCards.get(4));
                rightBottomCardTransition.setCycleCount(1);
                rightBottomCardTransition.setByX(-100.0);
                rightBottomCardTransition.setToY(160.0);
                rightBottomCardTransition.setAutoReverse(false);
                transitions.add(rightBottomCardTransition);
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
