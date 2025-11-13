package ttgdx.rules;

import java.util.ArrayList;
import java.util.List;

import ttgdx.libgdx.PieceMoveEvent;
import ttgdx.libgdx.components.Piece;
import ttgdx.libgdx.components.Tile;
import ttgdx.model.GameState;

// RuleManager.java - Gerenciador de regras modular
//TODO seria aqui o manager principal de todos ou turnmanager? Com o fluxo dos turnos e rodadas abaixo?
public class RuleManager {
    // Setup["<b>Configuração (Setup)</b><br>Distribuir componentes<br>Posicionar peças iniciais<br>Determinar ordem inicial"]
    // PlayerTurn["<b>Turno de um Jogador</b><br>Realizar Ações Permitidas<br>Resolver Efeitos Imediatos"]
    // GlobalEvent["<b>Evento Global /<br>Manutenção da Rodada</b><br>Atualizar o tabuleiro<br>Verificar condições de fim de jogo"]
    // EndGame["<b>Fim de Jogo</b><br>Desencadeado por:<br>- Condição de Vitória<br>- Número de rodadas<br>- Eliminação"]
    // Scoring["<b>Pontuação Final</b><br>Calcular Pontos de Vitória (VPs)<br>Desempate<br>Declarar Vencedor(es)"]

    // %% Transitions
    // Setup --> PlayerTurn
    // PlayerTurn -->|"Jogador conclui turno"| NextPlayerCheck{Próximo Jogador?}
    
    // NextPlayerCheck -->|"Ainda na mesma rodada"| PlayerTurn
    // NextPlayerCheck -->|"Último jogador da rodada"| GlobalEvent
    
    // GlobalEvent -->|"Condição de Fim de Jogo<br>NÃO atingida"| NextRound[Próxima Rodada]
    // GlobalEvent -->|"Condição de Fim de Jogo<br>ATINGIDA"| EndGame
    
    // NextRound --> PlayerTurn
    
    // EndGame --> Scoring
    // Scoring -->|"Jogo Terminado"| Stop([Fim])

    private List<GameRule> rules;
    
    public RuleManager() {
        rules = new ArrayList<>();
    }
    
    public void addRule(GameRule rule) {
        rules.add(rule);
    }
    
    public boolean validateAction(GameAction action, GameState state) {
        for (GameRule rule : rules) {
            if (!rule.validate(action, state)) {
                return false;
            }
        }
        return true;
    }
    
    public void applyAction(GameAction action, GameState state) {
        if (validateAction(action, state)) {
            action.execute(state);
        }
    }

    public static List<Tile> getValidMoves(Piece piece) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValidMoves'");
    }

    public boolean validateMove(PieceMoveEvent event) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateMove'");
    }


}