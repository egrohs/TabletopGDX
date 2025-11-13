package ttgdx.libgdx.components;

import java.util.List;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;

import lombok.Data;

// TODO é um Group ou tem um Group?
// Alguns wrapers de layout:
//1. Table (A mais comum e poderosa) pois oferece máximo controle sobre o layout com sistema de constraints flexível.
//2. Container Wrapper que ajuda no posicionamento de elementos únicos:
//3. VerticalGroup/HorizontalGroup Para layouts simples em linha ou coluna:
//4. GridGroup Para grids uniformes:
@Data
public class Zone extends Group {
    public enum ZoneType {
        PRIVATE, PROTECTED, PUBLIC
    }

    public enum ZoneLayout {
        FREE, GRID, VERTICAL, HORIZONTAL
    }

    private String name;
    private float x, y, width, height;
    private Group gdxGroup;
    protected ZoneType visivelPor;

    protected List<String> donos;

    public Zone(ZoneLayout layout, ZoneType visivelPor, List<String> donos) {
        super();
        this.visivelPor = visivelPor;
        this.donos = donos;
        // Configurar layout conforme o tipo
        switch (layout) {
            case FREE:
                // Layout livre, não é necessário configurar nada
                break;
            case GRID:
                // Configurar layout de grade
                // Exemplo: setLayout(new GridLayout(...));
                break;
            case VERTICAL:
                // Configurar layout vertical
                // Exemplo: setLayout(new VerticalGroup(...));
                gdxGroup = new VerticalGroup().space(5).pad(10).fill().wrap();//.columnAlign(VerticalGroup.ALIGN_CENTER);
                break;
            case HORIZONTAL:
                break;
        }
    }

    public Zone(String name, float x, float y, float width, float height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setBounds(x, y, width, height);
    }

    public String getName() {
        return name;
    }

    public boolean contains(float screenX, float screenY) {
        return screenX >= x && screenX <= x + width && screenY >= y && screenY <= y + height;
    }
    // Outros métodos utilitários...
}