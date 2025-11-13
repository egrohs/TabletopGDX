package ttgdx.rules;

import ttgdx.model.GameState;

public abstract class EndGameManager {
    public abstract void scoring(GameState state);
    public abstract void tiebreaker(GameState state);
}