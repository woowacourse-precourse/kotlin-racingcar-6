package racingcar

import racingcar.controller.Controller
import racingcar.randomnumbergenerator.RandomNumberGeneratorImpl
import racingcar.validator.ValidatorImpl

fun main() {
    Controller(ValidatorImpl(), RandomNumberGeneratorImpl()).startGame()
}
