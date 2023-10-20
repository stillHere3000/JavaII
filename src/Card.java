

import javafx.scene.image.Image;

public class Card{
    private String suit;
    private String rank;
    private Image CardImage;

    public Card(String suit, String rank, String CardImageURL){
        this.suit = suit;
        this.rank = rank;
        this.CardImage = new Image(CardImageURL);
    }

    public String getSuit(){
        return suit;
    }

    public String getRank(){
        return rank;
    }

    public Image getCardImage(){
        return CardImage;
    }

    public void setSuit(String suit){
        this.suit = suit;
    }

    public void setRank(String rank){
        this.rank = rank;
    }

    public void setCardImage(String CardImageURL){
        this.CardImage = new Image(CardImageURL);
    }

    public String toString(){
        return rank + " of " + suit;
    }
}   