package ttgdx.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * DTO para representar a estrutura de um ObjectState do JSON do Tabletop Simulator.
 * Esta classe principal contém outras classes aninhadas para representar a estrutura completa.
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TTSObjectStateDto {
    @JsonProperty("GUID")
    private String guid;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Transform")
    private TransformDto transform;

    @JsonProperty("Nickname")
    private String nickname;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("GMNotes")
    private String gmNotes;

    // @JsonProperty("AltLookAngle")
    // private Vector3Dto altLookAngle;

    // @JsonProperty("ColorDiffuse")
    // private ColorDto colorDiffuse;

    @JsonProperty("LayoutGroupSortIndex")
    private int layoutGroupSortIndex;

    @JsonProperty("Value")
    private int value;

    @JsonProperty("Locked")
    private boolean locked;

    @JsonProperty("Grid")
    private boolean grid;

    @JsonProperty("Snap")
    private boolean snap;

    @JsonProperty("IgnoreFoW")
    private boolean ignoreFoW;

    @JsonProperty("MeasureMovement")
    private boolean measureMovement;

    @JsonProperty("DragSelectable")
    private boolean dragSelectable;

    @JsonProperty("Autoraise")
    private boolean autoraise;

    @JsonProperty("Sticky")
    private boolean sticky;

    @JsonProperty("Tooltip")
    private boolean tooltip;

    @JsonProperty("GridProjection")
    private boolean gridProjection;

    @JsonProperty("HideWhenFaceDown")
    private boolean hideWhenFaceDown;

    @JsonProperty("Hands")
    private boolean hands;

    @JsonProperty("MaterialIndex")
    private int materialIndex;

    @JsonProperty("MeshIndex")
    private int meshIndex;

    // @JsonProperty("CustomMesh")
    // private CustomMeshDto customMesh;

    @JsonProperty("LuaScript")
    private String luaScript;

    @JsonProperty("LuaScriptState")
    private String luaScriptState;

    @JsonProperty("XmlUI")
    private String xmlUI;

    @JsonProperty("ContainedObjects")
    private List<TTSObjectStateDto> containedObjects;

    // TODO estou na duvida de manter esse zoneconfig aqui ou na raiz?!
    @JsonProperty("ZoneConfig")
    private ZoneConfigDto zoneConfig;

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TransformDto {
        private float posX;
        private float posY;
        private float posZ;
        private float rotX;
        private float rotY;
        private float rotZ;
        private float scaleX;
        private float scaleY;
        private float scaleZ;
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ZoneConfigDto {
        @JsonProperty("Layout")
        private String layout; // "GRID", "HORIZONTAL", "VERTICAL", "FREE"

        @JsonProperty("Rows")
        private int rows;

        @JsonProperty("Cols")
        private int cols;
    }

    // @Data
    // @NoArgsConstructor
    // public static class Vector3Dto {
    //     private float x;
    //     private float y;
    //     private float z;
    // }

    // @Data
    // @NoArgsConstructor
    // public static class ColorDto {
    //     private float r;
    //     private float g;
    //     private float b;
    //     private float a;
    // }

    // @Data
    // @NoArgsConstructor
    // public static class CustomMeshDto {
    //     @JsonProperty("MeshURL") private String meshURL;
    //     @JsonProperty("DiffuseURL") private String diffuseURL;
    //     @JsonProperty("NormalURL") private String normalURL;
    //     @JsonProperty("ColliderURL") private String colliderURL;
    //     @JsonProperty("Convex") private boolean convex;
    //     @JsonProperty("MaterialIndex") private int materialIndex;
    //     @JsonProperty("TypeIndex") private int typeIndex;
    //     @JsonProperty("CastShadows") private boolean castShadows;
    // }
}