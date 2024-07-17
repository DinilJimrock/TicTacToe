package Tictactoe.BotPlayingStrategy;

import Tictactoe.models.Board;
import Tictactoe.models.Cell;

public interface BotPlayingStrategy {

    Cell makeMove(Board board);
}
