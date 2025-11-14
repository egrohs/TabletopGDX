package aplicacao;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

/**
 * Ponto de entrada para a aplicação desktop (LWJGL3).
 */
public class DesktopLauncher {
	public static void main(String[] args) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("Five Tribes");
		config.setWindowedMode(1280, 720);
		config.useVsync(true);
		config.setForegroundFPS(60);
		// Inicia a aplicação LibGDX, passando uma instância da implementação do jogo (FiveTribes).
		new Lwjgl3Application(new FiveTribes(), config);
	}
}