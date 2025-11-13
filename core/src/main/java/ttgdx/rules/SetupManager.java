package ttgdx.rules;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import ttgdx.libgdx.components.Zone;
import ttgdx.model.GameState;

@Slf4j
public abstract class SetupManager {
    protected SetupManager() {
        log.info("SetupManager initialized");
    }
    
    // Implementar configuração inicial do jogo
    public abstract void setup(GameState state);

    public abstract List<Zone> defineZones();
}