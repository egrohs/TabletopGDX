package aplicacao;

import ttgdx.TabletopGDX;
import ttgdx.creators.BoardFactory;
import ttgdx.creators.GameScene;
import ttgdx.model.GameState;
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
    // this.board = BoardFactory.createBoard(boardConfig);
    // this.turnManager.initialize(jogadores, turnConfig.getType(),
    // turnConfig.getParameters());
    // ...outros setups...

    @Override
    protected EndGameManager defineEndGameManager() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'defineEndGameManager'");
        return new EndGameManager() {

            @Override
            public void scoring(GameState state) {
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'scoring'");
            }

            @Override
            public void tiebreaker(GameState state) {
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'tiebreaker'");
            }
        };
    }

    @Override
    protected TurnManager defineTurnManager() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'defineTurnManager'");
        return new TurnManager() {

            @Override
            public boolean validateMove(GameState state) {
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'validateMove'");
                return true;
            }

            @Override
            public void turnOrder(GameState state) {
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'turnOrder'");
            }

            @Override
            public void cleanUp(GameState state) {
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'cleanUp'");
            }

            @Override
            public boolean triggerEndGame(GameState state) {
                // TODO Auto-generated method stub
                //throw new UnsupportedOperationException("Unimplemented method 'triggerEndGame'");
                return false;
            }
        };
    }

    @Override
    protected SetupManager defineSetupManager() {
        return new SetupManager() {
            @Override
            public GameScene setup(GameState gameState) {
                // Carrega a cena do jogo a partir do arquivo JSON do Tabletop Simulator
                GameScene scene = BoardFactory.createFromSaveFile("five-tribes.json");
                System.out.println("Scene: " + scene);
                // Outras configurações iniciais do gameState, como jogadores, etc.
                return scene;
            }
        };
    }
}