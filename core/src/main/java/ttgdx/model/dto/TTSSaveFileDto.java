package ttgdx.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO para representar a estrutura completa de um arquivo de save do Tabletop Simulator.
 * Contém os metadados do cabeçalho e a lista de todos os objetos no jogo.
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignora campos do JSON que não estão mapeados aqui
public class TTSSaveFileDto {
    @JsonProperty("SaveName")
    private String saveName;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("GameMode")
    private String gameMode;

    @JsonProperty("GameType")
    private String gameType;

    @JsonProperty("GameComplexity")
    private String gameComplexity;

    @JsonProperty("VersionNumber")
    private String versionNumber;

    @JsonProperty("Date")
    private String date;

    @JsonProperty("EpochTime")
    private long epochTime;

    @JsonProperty("PlayingTime")
    private List<Integer> playingTime;

    @JsonProperty("PlayerCounts")
    private List<Integer> playerCounts;

    @JsonProperty("Tags")
    private List<String> tags;

    @JsonProperty("ObjectStates")
    private List<TTSObjectStateDto> objectStates;
}