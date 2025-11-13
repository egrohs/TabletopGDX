package aplicacao;

import ttgdx.model.GameState;
import ttgdx.rules.turn.TurnManager;

public class MyTurnManager extends TurnManager {
    @Override
    public boolean validateMove(GameState state) {
        // String msg = super.validaMove(origens, destino);
        // if (msg == null) {
        //     int soma = 0;
        //     boolean so1Mao = false;
        //     if (isMoveu()) {
        //         return "Voce j� jogou nesta rodada!";
        //     }
        //     if (destino.getZonaPrimeiraOrdem().getName().equals("Mesa")) {
        //         if (!(origens.get(0) instanceof CartaBaralho)) {
        //             return "Origem deve ser uma carta.";
        //         }
        //         if (origens.size() != 1) {
        //             return "S� pode por uma carta na mesa.";
        //         }
        //     } else {
        //         for (Zona origem : origens) {
        //             if (origem instanceof CartaBaralho) {
        //                 CartaBaralho carta = (CartaBaralho) origem;
        //                 soma += getUltimoMemento().getValores().get(carta.getValor());
        //                 if (carta.getParent().getName().startsWith("Mao")) {
        //                     if (so1Mao == true) {
        //                         return "S� vale usar uma carta da m�o";
        //                     }
        //                     so1Mao = true;
        //                 }
        //             } else {
        //                 return "Origem " + origem.getName() + "n�o � uma carta";
        //             }
        //         }
        //         if (soma != 15) {
        //             return "Esta jogada n�o soma 15";
        //         }
        //     }
        // }
        // return msg;
        return true;
    }

    @Override
    public void turnOrder(GameState state) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'turnOrder'");
    }

    @Override
    public void cleanUp(GameState state) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'cleanUp'");
    }

    @Override
    public boolean triggerEndGame(GameState state) {
        return false;
    }
}