package Tictactoe.Winningstrategies;

import Tictactoe.models.Board;
import Tictactoe.models.Move;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
