package racingcar.service

import racingcar.domain.Car

class Winner {
    fun decideWinner(playerList: List<Car>, distanceList: List<String>): List<String> {
        val playerMap = changeListToMap(playerList, distanceList)
        val longDistance = distanceList.sorted().reversed()[0]

        return playerMap.filterValues { it == longDistance }.keys.toList()
    }

    fun printWinner(winnerList: List<String>) {
        print("최종 우승자 : ")
        val winner = winnerList.joinToString(", ")
        println(winner)
    }

    private fun changeListToMap(playerList: List<Car>, distanceList: List<String>) : Map<String, String> {
        val playerMap = mutableMapOf<String, String>()
        repeat(playerList.size) {
            playerMap[playerList[it].name] = distanceList[it]
        }
        return playerMap
    }
}