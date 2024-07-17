package Tictactoe.BotPlayingStrategy;

import Tictactoe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {


        return new EasyBotPlayingStrategy();
    }
}
