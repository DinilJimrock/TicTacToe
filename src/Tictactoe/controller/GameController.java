package Tictactoe.controller;

import Tictactoe.Winningstrategies.WinningStrategy;
import Tictactoe.exception.DuplicateSymbolException;
import Tictactoe.exception.MoreThanOneException;
import Tictactoe.exception.PlayersCountMisMatchException;
import Tictactoe.models.Game;
import Tictactoe.models.Player;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategies) throws PlayersCountMisMatchException, DuplicateSymbolException, MoreThanOneException {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(playerList)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }
}
