package ttgdx.libgdx.components;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;

import ttgdx.model.Card;

public class CardTextures {
    private Map<String, Texture> textures;
    
    public CardTextures() {
        textures = new HashMap<>();
        loadTextures();
    }
    
    private void loadTextures() {
        // Texturas das faces (exemplo: "hearts_ace", "spades_king")
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                String key = getTextureKey(suit, rank);
                textures.put(key, new Texture("cards/" + key + ".gif"));
            }
        }
        
        // Textura do verso
        textures.put("back", new Texture("cards/back.gif"));
    }
    
    public Texture getCardTexture(Card.Suit suit, Card.Rank rank) {
        return textures.get(getTextureKey(suit, rank));
    }
    
    public Texture getBackTexture() {
        return textures.get("back");
    }
    
    private String getTextureKey(Card.Suit suit, Card.Rank rank) {
        //return suit.name().toLowerCase() + "_" + rank.name().toLowerCase();
        return "d1.gif";
    }
}