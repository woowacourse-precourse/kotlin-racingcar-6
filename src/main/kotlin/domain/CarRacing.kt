package domain

import camp.nextstep.edu.missionutils.Randoms

class CarRacing {
    fun startRacingPlay(cars: List<Car>, racing: Int) {
        println()
        println(Constant.RESULT_TEXT)
        for (playNum in 0..<racing) {
            racingPlay(cars)
            println()
        }
        winnerJudge(cars)
    }

    private fun racingPlay(car: List<Car>) {
        car.forEach { name -> moveForwardOrStop(name) }
    }

    private fun moveForwardOrStop(name: Car) {
        val moveCount = createPlayRandomNum()
        if (moveCount >= Constant.FORWARD_CONDITION_STANDARD) {
            moveForward(name)
        } else {
            moveStop(name)
        }
    }

    private fun createPlayRandomNum(): Int =
        Randoms.pickNumberInRange(Constant.FORWARD_CONDITION_MIN, Constant.FORWARD_CONDITION_MAX)

    private fun moveForward(name: Car) {
        val moveCount = name.moveForward()
        val named = name.toString()
        println("$named : ${move(moveCount)}")
    }

    private fun moveStop(name: Car) {
        val moveCount = name.moveStop()
        println("$name : ${move(moveCount)}")
    }

    private fun move(moveCount: Int): String = Constant.FORWARD_NOTATION.repeat(moveCount)

    private fun winnerJudge(cars: List<Car>) {
        var moveCountMap: MutableMap<String, Int> = mutableMapOf()
        cars.forEach { car -> moveCountMap[car.toString()] = car.moveCount }
        val map = moveCountMap.toList().sortedByDescending { it.second }.toMap() as MutableMap
        val max = map.values.max()
        val maxKey: MutableList<String> = mutableListOf()
        for ((key, value) in map) {
            if (value == max) {
                maxKey.add(key)
            }
        }
        outputWinner(maxKey.joinToString(", "))
    }

    private fun outputWinner(max: String) {
        println("${Constant.FINAL_WINNER}${max}")
    }
}