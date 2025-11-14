package ttgdx.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import lombok.Getter;
import ttgdx.model.dto.TTSObjectStateDto;

/**
 * Representa um objeto do Tabletop Simulator (TTS) como um Ator no palco do LibGDX.
 * <p>
 * Esta classe estende {@link Group} para que possa conter outros atores (como uma imagem de fundo
 * ou os atores de objetos contidos). Ela também armazena os dados originais do DTO do TTS.
 */
@Getter
public class TTSActor extends Group {

    /**
     * Contém todos os dados originais do objeto carregado do JSON do TTS.
     */
    private final TTSObjectStateDto ttsData;

    /**
     * A representação visual principal deste ator, como um token ou uma carta.
     * Pode ser nulo se o ator for apenas um container lógico (como um 'HandTrigger').
     */
    private Image visual;

    /**
     * Construtor que cria um TTSActor a partir de um DTO.
     *
     * @param dto O objeto de transferência de dados carregado do JSON do TTS.
     */
    public TTSActor(TTSObjectStateDto dto) {
        this.ttsData = dto;
        updateTransform();

        // Se o DTO tiver objetos contidos, cria atores para eles também.
        if (dto.getContainedObjects() != null) {
            for (TTSObjectStateDto childDto : dto.getContainedObjects()) {
                TTSActor childActor = new TTSActor(childDto);
                this.addActor(childActor);
            }
        }
    }

    /**
     * Aplica as transformações (posição, rotação, escala) do DTO para este Ator.
     */
    private void updateTransform() {
        if (ttsData.getTransform() != null) {
            TTSObjectStateDto.TransformDto transform = ttsData.getTransform();
            this.setPosition(transform.getPosX(), transform.getPosZ()); // Usando X e Z para um plano 2D
            this.setRotation(transform.getRotY()); // Usando a rotação Y para a rotação 2D
            this.setScale(transform.getScaleX(), transform.getScaleZ());
        }
    }

    /**
     * Define a representação visual deste ator.
     *
     * @param texture A textura a ser usada para a imagem.
     */
    public void setVisual(Texture texture) {
        if (this.visual != null) {
            this.removeActor(this.visual);
        }
        this.visual = new Image(texture);
        this.addActor(this.visual);
        this.setSize(this.visual.getWidth(), this.visual.getHeight());
    }

    /**
     * Adiciona um ator filho. Se o ator principal tiver um visual, garante que o
     * ator filho seja adicionado "em cima" do visual.
     */
    @Override
    public void addActor(Actor actor) {
        super.addActor(actor);
        if (visual != null) {
            visual.toBack(); // Garante que a imagem de fundo fique sempre atrás.
        }
    }
}