package ttgdx.libgdx.components;

import java.util.List;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
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
    public enum Visibility {
        PRIVATE, PROTECTED, PUBLIC
    }

    public enum Layout {
        FREE, GRID, VERTICAL, HORIZONTAL
    }

    // O 'layoutManager' é o ator que organiza os filhos dentro desta Zona.
    // Pode ser um Table, VerticalGroup, etc. A própria Zone (this) atua como o container principal.
    private Actor layoutManager;
    protected Visibility visibility;
    protected List<String> owners;

    /**
     * Construtor principal para criar uma Zona com um layout específico.
     * @param name Nome da zona para identificação.
     * @param layout O estilo de organização dos componentes (GRID, VERTICAL, etc.).
     * @param visibility Quem pode ver o conteúdo desta zona.
     * @param owners Lista de jogadores que "possuem" esta zona.
     */
    public Zone(String name, Layout layout, Visibility visibility, List<String> owners) {
        super();
        this.setName(name);
        this.visibility = visibility;
        this.owners = owners;

        // O layoutManager é adicionado como um filho da Zone.
        // Os componentes do jogo (peças, cartas) serão adicionados ao layoutManager.
        switch (layout) {
            case FREE:
                // Para layout livre, os próprios atores filhos serão adicionados diretamente à Zona.
                // Não precisamos de um layoutManager específico.
                this.layoutManager = this;
                break;
            case GRID:
                Table table = new Table();
                this.layoutManager = table;
                this.addActor(table); // Adiciona a Table como filha da Zone
                break;
            case VERTICAL:
                VerticalGroup vGroup = new VerticalGroup().space(5).pad(10).fill();
                this.layoutManager = vGroup;
                this.addActor(vGroup);
                break;
            case HORIZONTAL:
                HorizontalGroup hGroup = new HorizontalGroup().space(5).pad(10).fill();
                this.layoutManager = hGroup;
                this.addActor(hGroup);
                break;
        }
    }

    public Zone(String name, float x, float y, float width, float height) {
        this(name, Layout.FREE, Visibility.PUBLIC, null);
        setBounds(x, y, width, height);
    }

    /**
     * Adiciona um ator (peça, carta, etc.) à zona, delegando-o ao gerenciador de layout correto.
     */
    @Override
    public void addActor(Actor actor) {
        if (layoutManager != null && layoutManager instanceof Group && layoutManager != this) {
            ((Group) layoutManager).addActor(actor);
        } else {
            super.addActor(actor);
        }
    }
}