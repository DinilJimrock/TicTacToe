package Tictactoe.Winningstrategies;

import Tictactoe.models.Board;
import Tictactoe.models.Move;

public class ColWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
