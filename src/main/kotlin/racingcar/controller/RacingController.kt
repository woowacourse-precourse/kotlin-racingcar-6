package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Car
import racingcar.domain.Decision
import racingcar.domain.Save
import racingcar.view.Input
import racingcar.view.Print

class RacingController {
    fun startRace() {
        startRacing(Input(), Save(), Decision(), Print())
    }

    private fun startRacing(input: Input, save: Save, decision: Decision, print: Print) {
        val playerList = choicePlayer(input)
        val cycle = input.inputCycle()
        val distanceList = MutableList(playerList.size) { "" }
        print("\n실행결과\n")

        while (COUNT < cycle) {
            repeat(playerList.size) { index ->
                val move = decision.decideMovement(playerList[index])
                save.saveDistance(move, distanceList, index)
            }
            print.printDistance(playerList, distanceList)
            COUNT++
        }
        val winnerList = decision.decideWinner(playerList, distanceList)
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