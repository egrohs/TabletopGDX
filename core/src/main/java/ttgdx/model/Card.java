package ttgdx.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import lombok.Data;

@Data
public class Card {
    // Atributos específicos do Card podem ser adicionados aqui
    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    public enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
        NINE, TEN, JACK, QUEEN, KING
    }

    private Suit suit; // Naipe
    private Rank rank; // Valor
    private boolean faceUp;
    Image image;
    //TODO dave aceitar caminho relativo na pasta assets
    Texture cardTexture = new Texture(Gdx.files.internal("C:\\Users\\Pc\\workspace\\TabletopGDX\\assets\\cards\\back.gif"));

    public Card(Suit suit, Rank rank) {
        //super(cardTexture);
        image=new Image(cardTexture);
        this.suit = suit;
        this.rank = rank;
        this.faceUp = false;
    }
}