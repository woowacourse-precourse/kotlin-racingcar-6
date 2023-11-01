package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class CarRace {
    private fun generateNumber(): Int {
        return Randoms.pickNumberInRange(CarRaceConstants.RANDOM_NUMBER_MIN, CarRaceConstants.RANDOM_NUMBER_MAX)
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