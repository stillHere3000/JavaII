// Purpose: Creates a deck of cards and displays 3 random cards from the deck
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class deckofCards extends Application{

    private ArrayList<Card> deck = new ArrayList<Card>();
    private ArrayList<Card> hand = new ArrayList<Card>();

    @Override
    public void start(Stage primaryStage){
        //create a scene and place it in the stage
        Scene scene = new Scene(setupHandImages() , 500, 400);


        

        primaryStage.setTitle("Excercise_14.3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public HBox setupHandImages(){

        HBox hbox = new HBox(10);
        ImageView handCardView1 = new ImageView(this.hand.get(0).getCardImage());
        ImageView handCardView2 = new ImageView(this.hand.get(1).getCardImage());
        ImageView handCardView3 = new ImageView(this.hand.get(2).getCardImage());
        setImageViewStyles(handCardView1);
        setImageViewStyles(handCardView2);
        setImageViewStyles(handCardView3);
        
        hbox.setPadding(new Insets(15, 15, 15, 15));
        hbox.getChildren().addAll(handCardView1, handCardView2, handCardView3);
        

        return hbox;
    }

    public void setImageViewStyles(ImageView imgV){
        imgV.setFitHeight(75);        imgV.setFitWidth(75);        
    }

    public deckofCards(){
        intializeClubs();        intializeDiamonds();
        intializeHearts();        intializeSpades();
        hand.add( this.deck.get((int)(Math.random()*52)%52));
        hand.add( this.deck.get((int)(Math.random()*52)%52));
        hand.add( this.deck.get((int)(Math.random()*52)%52));
        
    }

    public void intializeClubs(){
        deck.add(new Card("Clubs", "Ace", "./clubs/ace_of_clubs.png"));
        deck.add(new Card("Clubs", "2", "./clubs/2_of_clubs.png"));
        deck.add(new Card("Clubs", "3", "./clubs/3_of_clubs.png"));
        deck.add(new Card("Clubs", "4", "./clubs/4_of_clubs.png"));
        deck.add(new Card("Clubs", "5", "./clubs/5_of_clubs.png"));
        deck.add(new Card("Clubs", "6", "./clubs/6_of_clubs.png"));
        deck.add(new Card("Clubs", "7", "./clubs/7_of_clubs.png"));
        deck.add(new Card("Clubs", "8", "./clubs/8_of_clubs.png"));
        deck.add(new Card("Clubs", "9", "./clubs/9_of_clubs.png"));
        deck.add(new Card("Clubs", "10", "./clubs/10_of_clubs.png"));
        deck.add(new Card("Clubs", "Jack", "./clubs/jack_of_clubs.png"));
        deck.add(new Card("Clubs", "Queen", "./clubs/queen_of_clubs.png"));
        deck.add(new Card("Clubs", "King", "./clubs/king_of_clubs.png"));
    }

    public void intializeHearts(){
        deck.add(new Card("Hearts", "Ace", "./hearts/ace_of_hearts.png"));
        deck.add(new Card("Hearts", "2", "./hearts/2_of_hearts.png"));
        deck.add(new Card("Hearts", "3", "./hearts/3_of_hearts.png"));
        deck.add(new Card("Hearts", "4", "./hearts/4_of_hearts.png"));
        deck.add(new Card("Hearts", "5", "./hearts/5_of_hearts.png"));
        deck.add(new Card("Hearts", "6", "./hearts/6_of_hearts.png"));
        deck.add(new Card("Hearts", "7", "./hearts/7_of_hearts.png"));
        deck.add(new Card("Hearts", "8", "./hearts/8_of_hearts.png"));
        deck.add(new Card("Hearts", "9", "./hearts/9_of_hearts.png"));
        deck.add(new Card("Hearts", "10", "./hearts/10_of_hearts.png"));
        deck.add(new Card("Hearts", "Jack", "./hearts/jack_of_hearts.png"));
        deck.add(new Card("Hearts", "Queen", "./hearts/queen_of_hearts.png"));
        deck.add(new Card("Hearts", "King", "./hearts/king_of_hearts.png"));
    }

    public void intializeDiamonds(){
        deck.add(new Card("Diamonds", "Ace", "./diamonds/ace_of_diamonds.png"));
        deck.add(new Card("Diamonds", "2", "./diamonds/2_of_diamonds.png"));
        deck.add(new Card("Diamonds", "3", "./diamonds/3_of_diamonds.png"));
        deck.add(new Card("Diamonds", "4", "./diamonds/4_of_diamonds.png"));
        deck.add(new Card("Diamonds", "5", "./diamonds/5_of_diamonds.png"));
        deck.add(new Card("Diamonds", "6", "./diamonds/6_of_diamonds.png"));
        deck.add(new Card("Diamonds", "7", "./diamonds/7_of_diamonds.png"));
        deck.add(new Card("Diamonds", "8", "./diamonds/8_of_diamonds.png"));
        deck.add(new Card("Diamonds", "9", "./diamonds/9_of_diamonds.png"));
        deck.add(new Card("Diamonds", "10", "./diamonds/10_of_diamonds.png"));
        deck.add(new Card("Diamonds", "Jack", "./diamonds/jack_of_diamonds.png"));
        deck.add(new Card("Diamonds", "Queen", "./diamonds/queen_of_diamonds.png"));
        deck.add(new Card("Diamonds", "King", "./diamonds/king_of_diamonds.png"));
    }

    public void intializeSpades(){
        deck.add(new Card("Spades", "Ace", "./spades/ace_of_spades.png"));
        deck.add(new Card("Spades", "2", "./spades/2_of_spades.png"));
        deck.add(new Card("Spades", "3", "./spades/3_of_spades.png"));
        deck.add(new Card("Spades", "4", "./spades/4_of_spades.png"));
        deck.add(new Card("Spades", "5", "./spades/5_of_spades.png"));
        deck.add(new Card("Spades", "6", "./spades/6_of_spades.png"));
        deck.add(new Card("Spades", "7", "./spades/7_of_spades.png"));
        deck.add(new Card("Spades", "8", "./spades/8_of_spades.png"));
        deck.add(new Card("Spades", "9", "./spades/9_of_spades.png"));
        deck.add(new Card("Spades", "10", "./spades/10_of_spades.png"));
        deck.add(new Card("Spades", "Jack", "./spades/jack_of_spades.png"));
        deck.add(new Card("Spades", "Queen", "./spades/queen_of_spades.png"));
        deck.add(new Card("Spades", "King", "./spades/king_of_spades.png"));
    }

    public void getHand(){
        for(int i = 0; i < hand.size(); i++){
            System.out.println(hand.get(i));
        }
    }

    public static void main(String[] args){
        deckofCards dk= new deckofCards();
        dk.getHand();
        Application.launch(args);
    }


    
}

