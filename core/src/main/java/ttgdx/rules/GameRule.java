package ttgdx.rules;

import ttgdx.model.GameState;

public interface GameRule {
    boolean validate(GameAction action, GameState state);
}