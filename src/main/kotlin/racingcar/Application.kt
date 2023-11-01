package racingcar

import racingcar.play.RacingGameManager

fun main() {
    RacingGameManager.registerCarNames()
        .getAttemptCount()
        .startRace()
        .announceWinner()
}
