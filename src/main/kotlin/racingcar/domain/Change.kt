package racingcar.domain

import racingcar.domain.Car

class Change {
    internal fun changePlayerListToMap(playerList: List<Car>, distanceList: List<String>) : Map<String, String> {
        val playerMap = mutableMapOf<String, String>()
        repeat(playerList.size) {
            playerMap[playerList[it].name] = distanceList[it]
        }
        return playerMap
    }
}