package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.util.Constants

class RacingGameView(private val racingGameViewModel: RacingGameViewModel) {
    fun startGame() {
        println(Constants.ASK_PLAYERS)
        racingGameViewModel.savePlayers(Console.readLine(), ',')

        println(Constants.ASK_ROUND)
        racingGameViewModel.saveRound(Console.readLine())

        println(Constants.GAME_RESULT_HEADER)
        repeat(racingGameViewModel.round) {
            racingGameViewModel.playRound()
            println(racingGameViewModel.getRoundResult())
        }
        println("${Constants.GAME_WINNER_SUFFIX}${racingGameViewModel.getWinners()}")
    }

}