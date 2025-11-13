package aplicacao;

import ttgdx.TabletopGDX;
import ttgdx.rules.EndGameManager;
import ttgdx.rules.SetupManager;
import ttgdx.rules.turn.TurnManager;

public class Escova extends TabletopGDX {
    public static void main(String[] args) {
        // Métodos do framework podem ser chamados conforme necessário
        new Escova();
    }

    public Escova() {
        super();
        // Use os métodos do BoardGameFramework para configurar o jogo
        // Exemplo:
        //this.board = BoardFactory.createBoard(boardConfig);
        // this.turnManager.initialize(jogadores, turnConfig.getType(), turnConfig.getParameters());
        // ...outros setups...
    }

    @Override
    protected SetupManager defineSetupManager() {
        return new MySetupManager();
    }

    @Override
    protected TurnManager defineTurnManager() {
        return new MyTurnManager();
    }

    @Override
    protected EndGameManager defineEndGameManager() {
        return new MyEndGameManager();
    }
}