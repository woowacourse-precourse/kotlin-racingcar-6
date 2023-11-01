package racingcar

import kotlin.math.max

class GameManager(
    val nameList: List<String>,
    val tryCount: Int,
    var carsList: MutableList<Car>
) {
    constructor(nameList: List<String>, tryCount: Int) : this(nameList, tryCount, mutableListOf()) {
        createCarList(nameList)
    }

    private fun createCarList(nameList: List<String>) {
        for (name in nameList) {
            this.carsList.add(Car(name, ""))
        }
    }

    fun raceStart() {
        println("실행 결과")
        for (round in 0 until tryCount) {
            oneRoundResult()
        }
        // 최종 우승 차량을 출력
        // printWinners()
    }

    private fun oneRoundResult() {
        for (car in this.carsList) {
            car.chooseGoOrStop()
            car.howFarHaveGone()
        }
        println()
    }

    private fun printWinners() {
        val winners: String = findWinners()
        println("최종 우승자 : ${winners}")
    }

    private fun findWinners(): String {
        var maxDistance: Int = findMaxDistance()
        var winnerList: MutableList<String> = mutableListOf()
        carsList.forEach { car ->
            if (car.movingDistance.length == maxDistance){
                winnerList.add(car.name)
            }
        }
        var winners: String = winnerList.joinToString()
        return winners
    }

    private fun findMaxDistance(): Int {
        var maxDistance: Int = 0
        for (car in this.carsList) {
            maxDistance = max(maxDistance, car.movingDistance.length)
        }
        return maxDistance
    }
}