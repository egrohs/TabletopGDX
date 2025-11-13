package ttgdx.libgdx.components;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;

import ttgdx.model.Card;

public class StandartDeck extends VerticalGroup {
    public StandartDeck(/* List<Card> cards */) {
        super();
        for (int i = 1; i <= 52; i++) {
            // Exemplo simples: criar cartas numeradas de 1 a 52
            // Card card = new Card("Suit" + ((i - 1) / 13 + 1), String.valueOf((i - 1) % 13 + 1), new Image("C:\\Users\\Pc\\workspace\\TabletopGDX\\assets\\baralhos\\card_back.png"));
            // this.addActor(card);
        }
        // Configurações específicas do deck padrão podem ser adicionadas aqui
        this.space(5).pad(10).fill().wrap();// .columnAlign(VerticalGroup.ALIGN_CENTER);
    }
}