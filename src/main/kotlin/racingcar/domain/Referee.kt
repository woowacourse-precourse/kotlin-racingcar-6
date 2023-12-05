package racingcar.domain

import racingcar.controller.Cars

typealias _CarsScore = MutableMap<Car, Int>
typealias CarsScore = Map<Car, Int>

class Referee(
    private val cars: Cars,
) {
    init {
        require(cars.isNotEmpty()) { "[ERROR] 유효한 Cars가 아닙니다." }
    }

    private val carsScore: _CarsScore = cars.associateWithTo(mutableMapOf()) { 0 }

    fun judgeEachRound(): CarsScore {
        carsScore.forEach { (car, score) ->
            val condition = MoveConditionGenerator.generate()
            if (car.move(condition)) carsScore[car] = score + 1
        }
        return carsScore
    }

    fun judgeWinner(): CarsScore {
        val maxScore = carsScore.values.maxOrNull()
        return carsScore.filterValues { it == maxScore }
    }
}