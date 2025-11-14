package aplicacao;

import com.badlogic.gdx.utils.Array;

import ttgdx.Player;
import ttgdx.model.GameState;
import ttgdx.rules.turn.TurnStrategy;

// Exemplo de estratégia personalizada
public class CustomTurnStrategy implements TurnStrategy {
    // Implementação de uma estratégia específica para um jogo
    
    @Override
    public void initialize(Array<Player> players) {
        // Lógica de inicialização personalizada
    }
    
    @Override
    public Player getNextPlayer() {
        // Lógica personalizada para determinar o próximo jogador
        return null;
    }
    
    @Override
    public void nextTurn() {
        // Lógica personalizada para avançar o turno
    }
    
    @Override
    public Array<Player> getTurnOrder() {
        // Retorna a ordem atual personalizada
        return null;
    }
    
    // @Override
    // public TurnStrategyType getType() {
    //     return TurnStrategyType.CUSTOM;
    // }

    @Override
    public boolean validateMove(GameState state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateMove'");
    }

    @Override
    public void cleanUp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cleanUp'");
    }

    @Override
    public boolean endGameTrigger() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'endGameTrigger'");
    }
}