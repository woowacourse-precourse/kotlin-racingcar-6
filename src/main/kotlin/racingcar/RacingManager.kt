package racingcar

import Cars

class RacingManager {
    private val cars = Cars().makeCar()
    fun startGame() {
        val ranNum = RandomNumCreator()
        val inputManager = InputManager()

        for (index in 1..inputManager.readRepeatNum()) {
            for (car in cars) {
                car.move(ranNum.creator()) // 0부터 9까지의 무작위 숫자 전달
            }
            println()
        }
    }

    fun findWinner() {
        val winner = mutableListOf<String>()
        val carNameList = mutableListOf<String>()
        val moveCountList = mutableListOf<Int>()

        for (car in cars) {
            moveCountList.add(car.moveCount)
            carNameList.add(car.carName)
        }

        val bestScore = moveCountList.maxOrNull()
        val indices = moveCountList.indices.filter { moveCountList[it] == bestScore }

        for (num in indices) {
            winner.add(carNameList[num])
        }
        val result = winner.joinToString(", ") // 리스트를 문자열로 변환하고 쉼표와 공백으로 구분
        println("최종 우승자 : $result") // 출력: pobi, jun
    }
}