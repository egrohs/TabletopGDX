package aplicacao;

import ttgdx.model.GameState;
import ttgdx.rules.EndGameManager;

public class MyEndGameManager extends EndGameManager {
    @Override
    public void scoring(GameState state) {
        System.out.println("Custom scoring");
    }

    @Override
    public void tiebreaker(GameState state) {
        System.out.println("Custom tiebreaker");
    }
}