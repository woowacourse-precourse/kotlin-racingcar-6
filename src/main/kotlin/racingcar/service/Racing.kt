package racingcar.service

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Car
import racingcar.view.Print

class Racing {
    fun startRace() {
        startRacing(Input(), Winner(), Distance(), Print())
    }

    private fun startRacing(input: Input, winner: Winner, distance: Distance, print: Print) {
        val playerList = choicePlayer(input)
        val cycle = input.inputCycle()
        val distanceList = MutableList(playerList.size) { "" }
        print("\n실행결과\n")

        while (COUNT < cycle) {
            repeat(playerList.size) { index ->
                val move = distance.decideDistance(playerList[index])
                distance.saveDistance(move, distanceList, index)
            }
            print.printDistance(playerList, distanceList)
            COUNT++
        }
        val winnerList = winner.decideWinner(playerList, distanceList)
        print.printWinner(winnerList)
        Console.close()
    }

    private fun choicePlayer(input: Input): List<Car> {
        val nameList: List<String> = input.inputName()

        return nameList.map { name -> Car(name) }
    }

    companion object {
        private var COUNT = 0
    }
}