package Tictactoe.models;

import Tictactoe.Winningstrategies.WinningStrategy;
import Tictactoe.exception.DuplicateSymbolException;
import Tictactoe.exception.MoreThanOneException;
import Tictactoe.exception.PlayersCountMisMatchException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private List<Player> players;
    private Board board;
    private List<Move> move;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    public Game(int dimension,List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder() {
        return new Builder();

    }

    public void printBoard() {
        board.printBoard();
    }

    public static class Builder {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        private Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }

        public Game build() throws MoreThanOneException, DuplicateSymbolException, PlayersCountMisMatchException {

            validateBotCount();
            validateUniqueSymbolForPlayers();
            validateDimensionsAndPlayerCount();

            return new Game(dimension, players, winningStrategies);
        }

        private void validateDimensionsAndPlayerCount() throws PlayersCountMisMatchException {
            if(players.size() != (dimension-1)) {
                throw new PlayersCountMisMatchException();
            }
        }

        private void validateUniqueSymbolForPlayers() throws DuplicateSymbolException {
            Set<Character> symbols = new HashSet<>();
            for(Player player :players) {
                if(symbols.contains(player.getSymbol())) {
                    throw new DuplicateSymbolException();
                } else {
                    symbols.add(player.getSymbol());
                }
            }
        }

        private void validateBotCount() throws MoreThanOneException {
            int botCount = 0;

            for(Player player :players) {
                if(player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
            }

            if(botCount < 1) {
                throw new MoreThanOneException();
            }
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
    }



    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMove() {
        return move;
    }

    public void setMove(List<Move> move) {
        this.move = move;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }
}
