package ttgdx.libgdx.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

import ttgdx.model.Card;

public class CardActor extends Actor {
    private Card card;
    private Texture frontTexture;
    private Texture backTexture;
    private boolean selected;
    private ShapeRenderer shapeRenderer;

    public CardActor(Card card, Texture frontTexture, Texture backTexture) {
        this.card = card;
        this.frontTexture = frontTexture;
        this.backTexture = backTexture;
        this.selected = false;
        this.shapeRenderer = new ShapeRenderer();
        setSize(80, 120); // Tamanho padrão para cartas
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        // Primeiro desenha a carta
        Texture texture = card.isFaceUp() ? frontTexture : backTexture;
        
        // Desenha a carta
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        
        // Efeito de seleção (contorno)
        if (selected) {
            //batch.setColor(Color.GOLD);
            //batch.draw(shapeTexture, getX() - 2, getY() - 2, getWidth() + 4, getHeight() + 4);
            //batch.setColor(Color.WHITE);

        batch.end(); // Precisa finalizar o batch para usar ShapeRenderer
            
            shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(Color.GOLD);
            shapeRenderer.rect(getX() - 2, getY() - 2, getWidth() + 4, getHeight() + 4);
            shapeRenderer.end();
            
            batch.begin(); // Volta a usar o batch

        }
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public Card getCard() {
        return card;
    }
}