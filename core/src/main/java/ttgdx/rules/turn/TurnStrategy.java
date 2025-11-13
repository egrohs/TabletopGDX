package ttgdx.rules.turn;

import com.badlogic.gdx.utils.Array;

import ttgdx.Player;
import ttgdx.model.GameState;

// TurnStrategy.java - Interface para estratégias de ordenação de turnos
public interface TurnStrategy {
    /**
     * Inicializa ou reinicia a estratégia com a lista de jogadores
     */
    void initialize(Array<Player> players);
    
    /**
     * Retorna o próximo jogador da sequência
     */
    Player getNextPlayer();
    
    /**
     * Avança para o próximo turno
     */
    void nextTurn();
    
    /**
     * Retorna a lista completa de jogadores na ordem atual
     */
    Array<Player> getTurnOrder();
    
    /**
     * Retorna o tipo da estratégia
     */
    //TurnStrategyType getType();

    
    boolean validateMove(/*PieceMoveEvent event,*/ GameState state);
    void cleanUp();
    boolean endGameTrigger();
}