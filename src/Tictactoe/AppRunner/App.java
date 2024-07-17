package Tictactoe.AppRunner;

import Tictactoe.Winningstrategies.ColWinningStrategy;
import Tictactoe.Winningstrategies.DiagonalWinningStrategy;
import Tictactoe.Winningstrategies.RowWinningStrategy;
import Tictactoe.Winningstrategies.WinningStrategy;
import Tictactoe.controller.GameController;
import Tictactoe.exception.DuplicateSymbolException;
import Tictactoe.exception.MoreThanOneException;
import Tictactoe.exception.PlayersCountMisMatchException;
import Tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws PlayersCountMisMatchException, DuplicateSymbolException, MoreThanOneException {
        GameController gameController = new GameController();
        int dimension = 3;
        List<Player> playerList = new ArrayList<>();
        List<WinningStrategy> winningStrategies = new ArrayList<>();

        playerList.add(new Player('X', "Dinil Jimrock", 1, PlayerType.HUMAN));
        playerList.add(new Bot('O', "BOT", 2, PlayerType.BOT, BotDifficultyLevel.EASY));

        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.startGame(dimension, playerList, winningStrategies);
        game.printBoard();
    }
}
