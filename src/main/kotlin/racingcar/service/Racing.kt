package racingcar.service

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car

class Racing {
    init {
        startRacing(Input())
    }

    private fun startRacing(input: Input) {
        val playerList = choicePlayer()
        val cycle = input.inputCycle()
        val distanceList = MutableList(playerList.size) { "" }

        print("\n실행결과\n")

        while (COUNT < cycle) {
            repeat(playerList.size) { index ->
                saveDistance(decideMove(playerList[index]), distanceList, index)
            }
            printDistance(playerList, distanceList)
            COUNT++
        }
        val winner = decideWinner(playerList, distanceList)
        printWinner(winner)
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
        repeat(playerList.size) {index ->
            println("${playerList[index].name} : ${distanceList[index]}")
        }
        println()
    }

    private fun decideWinner(playerList: List<Car>, distanceList: List<String>): List<String> {
        val playerMap = changeListToMap(playerList, distanceList)
        val longDistance = distanceList.sorted().reversed()[0]

        return playerMap.filterValues { it == longDistance }.keys.toList()
    }

    private fun changeListToMap(playerList: List<Car>, distanceList: List<String>) : Map<String, String> {
        val playerMap = mutableMapOf<String, String>()
        repeat(playerList.size) {
            playerMap[playerList[it].name] = distanceList[it]
        }
        return playerMap
    }

    private fun printWinner(winnerList: List<String>) {
        print("최종 우승자 : ")
        val winner = winnerList.joinToString(", ")
        println(winner)
    }

    companion object {
        var COUNT = 0
        private const val GO = 1
        private const val STOP = 0
        private const val GO_STRING = "-"
        private const val STOP_STRING = ""
    }
}