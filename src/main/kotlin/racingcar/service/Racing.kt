package racingcar.service

import racingcar.domain.Car
import racingcar.exception.Exception

class Racing {
    fun startRace() {
        startRacing(Input(Exception()), Winner(), Distance())
    }

    private fun startRacing(input: Input, winner: Winner, distance: Distance) {
        val playerList = choicePlayer(input)
        val cycle = input.inputCycle()
        val distanceList = MutableList(playerList.size) { "" }
        print("\n실행결과\n")

        while (COUNT < cycle) {
            repeat(playerList.size) { index ->
                val move = distance.decideDistance(playerList[index])
                distance.saveDistance(move, distanceList, index)
            }
            distance.printDistance(playerList, distanceList)
            COUNT++
        }
        val winnerList = winner.decideWinner(playerList, distanceList)
        winner.printWinner(winnerList)
    }

    private fun choicePlayer(input: Input): List<Car> {
        val nameList: List<String> = input.inputName()

        return nameList.map { name -> Car(name) }
    }

    companion object {
        private var COUNT = 0
    }
}