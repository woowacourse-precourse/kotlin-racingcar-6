package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Host {

    fun printRequestEnterCarName() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printQuestionNumberOfAttempt() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printCurrentRaceSituation(cars: List<Car>): List<Int> {
        val playerPosition = mutableListOf<Int>()
        cars.forEach {
            val currentPosition = it.move(Randoms.pickNumberInRange(0, 9))
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

        return "최종 우승자 : ${winners.joinToString(", ")}"
    }

    fun printWinners(winners: String) {
        println(winners)
    }

}