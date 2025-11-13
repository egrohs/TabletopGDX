package ttgdx.rules;

import ttgdx.model.GameState;

public interface GameAction {
    void execute(GameState state);
}