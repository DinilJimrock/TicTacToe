package Tictactoe.Winningstrategies;

import Tictactoe.models.Board;
import Tictactoe.models.Move;

public interface WinningStrategy {

    boolean checkWinner(Board board, Move move);

}
