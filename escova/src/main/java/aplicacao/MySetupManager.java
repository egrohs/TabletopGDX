package aplicacao;

import java.util.ArrayList;
import java.util.List;

import ttgdx.libgdx.components.StandartDeck;
import ttgdx.libgdx.components.Zone;
import ttgdx.model.GameState;
import ttgdx.rules.SetupManager;

//@Slf4j
public class MySetupManager extends SetupManager {
    @Override
    public void setup(GameState state) {
        System.out.println("Custom game setup in MySetupManager");
        // Implementar configuração inicial personalizada para o jogo
        // Exemplo: distribuir peças, definir estado inicial, etc.
        //return ZonaBuilder.buildDeck(1, new Constantes.Valores[] { Valores.OITO, Valores.NOVE, Valores.DEZ, Valores.CORINGA });
        // valores.put(Valores.DAMA, 8);
        // valores.put(Valores.VALETE, 9);
        // valores.put(Valores.REI, 10);
        new StandartDeck();
    }

    @Override
    public List<Zone> defineZones() {
        List<Zone> zonas = new ArrayList<>();
        // for (String playerName : getUltimoMemento().getPlayerNames()) {
        //     zonas.add(ZonaBuilder.buildZona("Mao" + playerName, new String[] { playerName }, getUltimoMemento(), 3,
        //             TipoZona.PRIVADA));
        //     zonas.add(ZonaBuilder.buildZona("Monte" + playerName, new String[] { playerName }, getUltimoMemento(), 0,
        //             TipoZona.PROTEGIDA));
        // }
        // zonas.add(ZonaBuilder.buildZona("Mesa", getUltimoMemento().getPlayerNames(), getUltimoMemento(), 4, TipoZona.PUBLICA));
        // zonas.add(getUltimoMemento().getDeck());
        return zonas;
    }
}