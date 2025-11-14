package ttgdx;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import ttgdx.creators.GameScene;
import ttgdx.controlers.GameEventBus;
import ttgdx.controlers.NetworkManager;
import ttgdx.controlers.PlayerManager;
import ttgdx.libgdx.BoardInputHandler;
import ttgdx.libgdx.PieceMoveEvent;
import ttgdx.libgdx.components.Board;
import ttgdx.libgdx.components.CardActor;
import ttgdx.libgdx.components.DebugOverlay;
import ttgdx.model.Card;
import ttgdx.model.Card.Suit;
import ttgdx.model.GameState;
import ttgdx.rules.EndGameManager;
import ttgdx.rules.RuleManager;
import ttgdx.rules.SetupManager;
import ttgdx.rules.turn.TurnManager;
import ttgdx.rules.turn.TurnStrategyType;

// TabletopGDX.java - Classe principal do framework
// Abstract da erro de não achar o Game
public abstract class TabletopGDX extends Game {
    private Stage stage;
    protected Board board;
    protected TurnManager turnManager;
    protected RuleManager ruleManager;
    private NetworkManager networkManager;
    private DebugOverlay debugOverlay;
    protected PlayerManager playerManager;
    protected GameState gameState;
    protected SetupManager setupManager;
    protected EndGameManager endGameManager;

    protected TabletopGDX() {
        super();
    }

    protected abstract EndGameManager defineEndGameManager();
    protected abstract TurnManager defineTurnManager();
    protected abstract SetupManager defineSetupManager();

    private void layoutCards() {
        float startX = 50;
        float startY = 50;
        float spacing = 20;
        
        for (int i = 0; i < 5; i++) { // Mostrar 5 cartas
            CardActor card = deck.get(i);
            card.setPosition(startX + i * (card.getWidth() + spacing), startY);
            
            // Adicionar listener para clique
            card.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    CardActor clickedCard = (CardActor) event.getListenerActor();
                    clickedCard.getCard().setFaceUp(!clickedCard.getCard().isFaceUp());
                    //clickedCard.setSelected(!clickedCard.isSelected());
                }
            });
            
            stage.addActor(card);
        }
    }
List<CardActor> deck;
    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        // --- LÓGICA DE INICIALIZAÇÃO MOVIDA PARA CÁ ---
        // O gameState deve ser inicializado aqui
        this.gameState = new GameState(); // Ou carregado de algum lugar

        setupManager = defineSetupManager();
        GameScene scene = setupManager.setup(gameState);
        // Adiciona todos os atores da cena (zonas, peças, etc.) ao palco para serem renderizados.
        scene.addAllToStage(stage);

        turnManager = defineTurnManager();
        // As chamadas abaixo provavelmente devem ocorrer em outros pontos do fluxo do jogo, não todas na inicialização
        // turnManager.validateMove(gameState);
        // turnManager.turnOrder(gameState);

        endGameManager = defineEndGameManager();
        // --- FIM DA LÓGICA MOVIDA ---

// CardFactory cardFactory = new CardFactory();
// deck = cardFactory.createDeck();
// // Embaralhar as cartas
// Collections.shuffle(deck);
// // Posicionar cartas na tela
// layoutCards();
//Card c = new Card(Suit.CLUBS, Card.Rank.ACE);
//stage.addActor(c.getImage());

        // Inicializar gerenciadores
        ruleManager = new RuleManager();
//TODO turnManager = new TurnManager(createPlayers());
        // TODO networkManager = new NetworkManager(NetworkManager.NetworkMode.LOCAL);

        // Configurar estratégia de turnos a partir de arquivo de configuração
        // TODO String turnConfigFile =
        // Gdx.files.internal("config/turn_config.json").readString();
        // TurnConfig config = TurnConfig.fromJson(turnConfigFile);
        // turnManager.initialize(playerManager.getPlayers(), config.getType(),
        // config.getParameters());

        // Carregar tabuleiro a partir de configuração
        // TODO BoardConfig boardconfig = BoardConfig.loadFromJson("board_config.json");
        // board = BoardFactory.createBoard(boardconfig);
        // stage.addActor(board);

        // Configurar input handling
        // BoardInputHandler inputHandler = new BoardInputHandler(board);
        // Gdx.input.setInputProcessor(new InputMultiplexer(stage, inputHandler));

        // Inicializar overlay de debug
        debugOverlay = new DebugOverlay();

        // Registrar listeners de eventos
        GameEventBus.getInstance().subscribe(PieceMoveEvent.class, this::onPieceMoved);

        // TODO Adicionar regras do jogo
        // ruleManager.addRule(new MovementRule());
        // ruleManager.addRule(new PlacementRule());
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        debugOverlay.act();
        debugOverlay.draw();
    }

    private void onPieceMoved(PieceMoveEvent event) {
        // Validar e processar movimento
        if (ruleManager.validateMove(event)) {
            // Executar movimento
            event.getPiece().moveTo(event.getToTile());

            // Avançar turno se aplicável
            turnManager.nextPhase();
        }
    }

    private List<Player> createPlayers() {
        // Criar jogadores baseado na configuração
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1", Color.RED));
        players.add(new Player("Player 2", Color.BLUE));
        return players;
    }

    // Outros métodos do framework...
    public void nextTurn() {
        turnManager.nextTurn();

        // Atualizar UI com informações do turno
        updateTurnUI();
    }

    private void updateTurnUI() {
        Player currentPlayer = turnManager.getCurrentPlayer();
        int turnNumber = turnManager.getTurnCount();

        // Atualizar elementos de UI com informações do turno atual
    }

    // Método para mudar dinamicamente a estratégia de turnos durante o jogo
    public void changeTurnStrategy(TurnStrategyType newStrategy) {
        turnManager.setTurnStrategy(newStrategy);
    }
}