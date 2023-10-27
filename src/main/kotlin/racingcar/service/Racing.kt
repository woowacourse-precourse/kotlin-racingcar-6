package racingcar.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car

class Racing {
    init {
        startRacing(Input(), Winner(), Distance())
    }

    private fun startRacing(input: Input, winner: Winner, distance: Distance) {
        val playerList = choicePlayer()
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

    private fun choicePlayer(): List<Car> {
        val nameList: List<String> = Input().inputName()

        return nameList.map { name -> Car(name) }
    }

    companion object {
        var COUNT = 0
    }
}