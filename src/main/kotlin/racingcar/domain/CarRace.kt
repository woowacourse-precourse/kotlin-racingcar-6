package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.CarRaceConstants

class CarRace {
    private fun generateNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun startFlag() {
        println()
        println(CarRaceConstants.EXECUTION_RESULT)
    }

    fun runRound(carScore: MutableList<Pair<String, Int>>) {
        carScore.forEachIndexed { index, (carName, score) ->
            if (generateNumber() >= CarRaceConstants.SCORE_CUT_LINE) {
                carScore[index] = Pair(carName, score + CarRaceConstants.SCORE_ONE_POINT)
            }
        }
    }

    fun printRound(carScore: MutableList<Pair<String, Int>>) {
        carScore.forEach { (carName, score) ->
            val scoreStick = List(score) { CarRaceConstants.SCORE_STICK }
            println("$carName : ${scoreStick.joinToString(CarRaceConstants.SEPARATOR)}")
        }
        println()
    }
}