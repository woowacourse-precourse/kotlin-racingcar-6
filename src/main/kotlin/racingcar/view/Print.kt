package racingcar.view

import racingcar.domain.Car

class Print {
    fun printWinner(winnerList: List<String>) {
        print("최종 우승자 : ")
        val winner = winnerList.joinToString(", ")
        println(winner)
    }

    fun printDistance(playerList: List<Car>, distanceList: List<String>) {
        repeat(playerList.size) {index ->
            println("${playerList[index].name} : ${distanceList[index]}")
        }
        println()
    }
}