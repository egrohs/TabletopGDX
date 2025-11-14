package ttgdx.creators;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import lombok.Getter;
import ttgdx.libgdx.components.Zone;

/**
 * Um contêiner para os elementos de uma cena de jogo, separando as Zonas lógicas
 * de outros atores.
 */
@Getter
public class GameScene {
    private final Array<Zone> zones = new Array<>();
    private final Array<Actor> rootActors = new Array<>();

    public void addAllToStage(com.badlogic.gdx.scenes.scene2d.Stage stage) {
        for (Actor actor : rootActors) stage.addActor(actor);
        for (Actor zone : zones) stage.addActor(zone);
    }
}