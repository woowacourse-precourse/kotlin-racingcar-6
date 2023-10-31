package racingcar

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.max


class RacingGame(var carList: List<String>, var racingTime: Int) {
    var racingGame: LinkedHashMap<String, Int> = LinkedHashMap()
    var winnerPos: Int = 0

    init {
        makeCarPosMap()
    }

    private fun makeCarPosMap() {
        for (car in this.carList) {
            racingGame[car] = 0
        }
    }

    fun isCarMove(): Boolean {
        val dice = Randoms.pickNumberInRange(0, 9)
        return dice >= 4
    }


    fun printRoundResult() {
        for (car in this.racingGame.keys) {
            val sb = StringBuilder()
            sb.append("${car} : ")
            this.racingGame[car]?.let {
                repeat(it) {
                    sb.append("-")
                }
            }
            println(sb.toString())
        }
        println()
    }

    fun onRoundPlay(): Int {
        for (car in this.racingGame.keys) {
            if (isCarMove()) {
                this.racingGame[car] = (this.racingGame[car] ?: 0) + 1
            }
            winnerPos = max(winnerPos, (this.racingGame[car] ?: 0))
        }

        printRoundResult()
        return winnerPos
    }

    private fun getGameWinnerList(winnerPos: Int): String {
        val sb = StringBuilder()

        for (car in carList) {
            if (racingGame[car] == winnerPos) {
                sb.append(car)
                sb.append(", ")
            }
        }
        sb.deleteAt(sb.length - 2)

        print(sb.toString())

        return sb.toString()
    }


    fun runRacingGame(): String {

        var winnerPos = 0


        repeat(racingTime) {
            winnerPos = onRoundPlay()
        }
        val winner = getGameWinnerList(winnerPos)
        println("최종 우승자 : ${winner}")
        return winner.strip()
    }


}

fun userInput(): RacingGame {
    var inputLine: String?
    val carList: List<String>
    val racingTime: Int

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    inputLine = readlnOrNull() ?: throw IllegalArgumentException("이름이 입력되지 않았거나 올바르지 않은 형식입니다.")
    carList = inputLine.split(",")
    if (carList.find { it.length > 5 } != null) {
        throw IllegalArgumentException("5글자를 초과하는 자동차 이름이 있습니다.")
    }

    println("시도할 횟수는 몇 회인가요?")
    inputLine = readlnOrNull() ?: throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
    if (inputLine.all { item -> item.isDigit() }) {
        racingTime = inputLine.toInt()
    } else {
        throw IllegalArgumentException("숫자가 입력되지 않았거나 올바르지 않은 형식입니다.")
    }
    println()
    return RacingGame(carList, racingTime)
}


fun main() {
    val racingGame: RacingGame = userInput()
    racingGame.runRacingGame()
}
