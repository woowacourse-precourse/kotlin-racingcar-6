package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constants.*

class Host {

    fun printRequestEnterCarName() {
        println(REQUEST_ENTER_CAR_NAME)
    }

    fun printQuestionNumberOfAttempt() {
        println(QUESTION_NUMBER_OF_ATTEMPT)
    }

    fun printCurrentRaceSituation(
        cars: List<Car>,
        randomNumberGenerator: () -> Int = { Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) }
    ): List<Int> {
        val playerPosition = mutableListOf<Int>()

        cars.forEach {
            val currentPosition = it.move(randomNumberGenerator())
            println()
            playerPosition.add(currentPosition)
        }

        return playerPosition
    }

    fun determineWinners(playersFinalPosition: List<Int>, cars: List<Car>): String {
        val winners = mutableListOf<String>()
        val winnersPosition = playersFinalPosition.max()

        playersFinalPosition.forEachIndexed { index, value ->
            if (value == winnersPosition) {
                winners.add(cars[index].name)
            }
        }

        return "$FINAL_WINNER${winners.joinToString(COMMA_AND_SPACE)}"
    }

    fun printWinners(winners: String) {
        println(winners)
    }

}