package ttgdx.libgdx.components;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;

import ttgdx.model.Card;

public class CardFactory {
    private CardTextures cardTextures;
    
    public CardFactory() {
        cardTextures = new CardTextures();
    }
    
    public CardActor createCardActor(Card.Suit suit, Card.Rank rank) {
        Card card = new Card(suit, rank);
        Texture front = cardTextures.getCardTexture(suit, rank);
        Texture back = cardTextures.getBackTexture();
        
        return new CardActor(card, front, back);
    }
    
    public List<CardActor> createDeck() {
        List<CardActor> deck = new ArrayList<>();
        
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(createCardActor(suit, rank));
            }
        }
        
        return deck;
    }
}