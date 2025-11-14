package ttgdx.creators;

import java.io.IOException;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.fasterxml.jackson.databind.ObjectMapper;

import ttgdx.libgdx.components.Board;
import ttgdx.libgdx.components.Tile;
import ttgdx.libgdx.components.Zone;
import ttgdx.model.TTSActor;
import ttgdx.model.dto.TTSObjectStateDto;
import ttgdx.model.dto.TTSSaveFileDto;

// BoardFactory.java - Fábrica para criar tabuleiros a partir de configuração
public class BoardFactory {
    public static GameScene createFromSaveFile(String jsonPath) {
        GameScene scene = new GameScene();
        try {
            String jsonString = Gdx.files.internal(jsonPath).readString();
            ObjectMapper mapper = new ObjectMapper();
            TTSSaveFileDto saveFile = mapper.readValue(jsonString, TTSSaveFileDto.class);

            if (saveFile.getObjectStates() == null) {
                Gdx.app.error("BoardFactory", "JSON file does not contain 'ObjectStates'.");
                return scene;
            }

            //TODO 2 tratar tb os ContainedObjects
            
            // Passo 1: Criar todos os TTSActors
            for (TTSObjectStateDto dto : saveFile.getObjectStates()) {
                TTSActor actor = new TTSActor(dto);

                // Passo 2: Identificar e "promover" atores que são Zonas
                //TODO talvez seja melhor definir as zonas na raiz (o layout) de usar o GUID dos objetos no json pra dizer em qual zona vai.
                if (dto.getZoneConfig() != null) {
                    Zone zone = createZoneFromActor(actor);
                    scene.getZones().add(zone);

                    // Adiciona os filhos do DTO (meeples, etc.) à zona recém-criada
                    for(Actor child : actor.getChildren().toArray()) {
                        zone.addActor(child);
                    }

                } else {
                    // Se não for uma zona, é um ator raiz (como um saco de peças, etc.)
                    scene.getRootActors().add(actor);
                }
            }
        } catch (IOException e) {
            Gdx.app.error("BoardFactory", "Failed to load or parse JSON file: " + jsonPath, e);
        }
        return scene;
    }

    private static Zone createZoneFromActor(TTSActor actor) {
        TTSObjectStateDto dto = actor.getTtsData();
        TTSObjectStateDto.ZoneConfigDto zoneConfig = dto.getZoneConfig();

        // Converte o layout de String para Enum de forma segura
        Zone.Layout layout = Zone.Layout.FREE;
        try {
            layout = Zone.Layout.valueOf(zoneConfig.getLayout().toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            Gdx.app.error("BoardFactory", "Invalid or null layout in ZoneConfig: " + zoneConfig.getLayout());
        }

        Zone zone = new Zone(dto.getNickname(), layout, Zone.Visibility.PUBLIC, null);

        // Aplica a transformação do ator à zona
        zone.setPosition(actor.getX(), actor.getY());
        zone.setSize(actor.getWidth(), actor.getHeight());
        zone.setRotation(actor.getRotation());
        zone.setScale(actor.getScaleX(), actor.getScaleY());

        // TODO: Configurar propriedades da grade (rows, cols) se o layout for GRID

        return zone;
    }

    public static Board createBoard(BoardConfig config) {
        Board board = new Board(config.getRows(), config.getCols(), config.getTileSize());
        
        for (BoardConfig.TileConfig tileConfig : config.getTiles()) {
            Tile tile = board.getTileAt(tileConfig.getRow(), tileConfig.getCol());
            
            // Configurar o tile baseado na configuração
            if (tile != null) {
                tile.setType(tileConfig.getType());
                tile.setTexture(new Texture(tileConfig.getTexturePath()));
                
                // Aplicar propriedades adicionais
                for (Map.Entry<String, Object> property : tileConfig.getProperties().entrySet()) {
                    tile.setProperty(property.getKey(), property.getValue());
                }
            }
        }
        
        return board;
    }
}