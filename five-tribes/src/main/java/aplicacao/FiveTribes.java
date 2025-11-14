package aplicacao;

import ttgdx.TabletopGDX;
import ttgdx.rules.EndGameManager;
import ttgdx.rules.SetupManager;
import ttgdx.rules.turn.TurnManager;

public class FiveTribes extends TabletopGDX {
    public FiveTribes() {
        super();
    }

    // @Override
    // protected void inicializarJogo() {
        // Use os métodos do BoardGameFramework para configurar o jogo
        // Exemplo:
        //this.board = BoardFactory.createBoard(boardConfig);
        // this.turnManager.initialize(jogadores, turnConfig.getType(), turnConfig.getParameters());
        // ...outros setups...
    //}

    public static void main(String[] args) {
        // O usuário implementa uma subclasse concreta de Escova e instancia aqui
        //Escova jogo = new Escova();
        // Métodos do framework podem ser chamados conforme necessário
        new FiveTribes();
    }

    @Override
    protected EndGameManager defineEndGameManager() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defineEndGameManager'");
    }

    @Override
    protected TurnManager defineTurnManager() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defineTurnManager'");
    }

    @Override
    protected SetupManager defineSetupManager() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defineSetupManager'");
    }
}