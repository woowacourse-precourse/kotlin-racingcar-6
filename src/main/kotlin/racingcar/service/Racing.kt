package racingcar.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car

var COUNT = 0
const val GO = 1
const val STOP = 0
const val GO_STRING = "-"
const val STOP_STRING = ""

class Racing {
    init {
        startRacing()
    }

    private fun startRacing() {
        val playerList = choicePlayer()
        val cycle = Input().inputCycle()
        val distanceList = MutableList(playerList.size) { "" }

        print("\n실행결과\n")

        while (COUNT < cycle) {
            repeat(playerList.size) {
                saveDistance(decideMove(playerList[it]), distanceList, it)
            }
            printDistance(playerList, distanceList)
            COUNT++
        }
    }

    private fun choicePlayer(): List<Car> {
        val nameList: List<String> = Input().inputName()
        return nameList.map { name -> Car(name) }
    }

    private fun decideMove(player: Car): Int {
        return if (Randoms.pickNumberInRange(0, 9) > 3) {
            player.moveForward()
        } else {
            player.stop()
        }
    }

    private fun saveDistance(move: Int, distance: MutableList<String>, index: Int) {
        when (move) {
            GO -> distance[index] += GO_STRING
            STOP -> distance[index] += STOP_STRING
        }
    }

    private fun printDistance(playerList: List<Car>, distanceList: List<String>) {
        repeat(playerList.size) {
            println("${playerList[it].name} : ${distanceList[it]}")
        }
        println()
    }
}