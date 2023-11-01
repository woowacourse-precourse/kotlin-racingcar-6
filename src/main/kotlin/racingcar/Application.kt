package racingcar

import racingcar.util.RandomNumberGenerator

fun main() {
    // TODO: 프로그램 구현
    RacingGameView(RacingGameViewModel(RandomNumberGenerator())).startGame()
}
