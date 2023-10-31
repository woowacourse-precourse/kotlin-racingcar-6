package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carRacingGame = CarRacingGame()
    carRacingGame.gameStart()
}

const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val INPUT_TRIAL_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?"
const val INITIAL_CAR_MOVEMENT_COUNT = 0
const val RACING_START_MESSAGE = "실행 결과"
const val PRINT_RACING_RESULT_MESSAGE = "최종 우승자 : "

data class Car (
    var name: String,
    var movementCount: Int
)

class GameStatus {
    var listOfCar = mutableListOf<Car>()
    var countOfTrial: Int = 0

    fun initStatus(listOfNames: List<String>, count: Int) {
        addListOfCar(listOfNames)
        countOfTrial = count
    }
    fun addListOfCar(listOfNames: List<String>) {
        for (name in listOfNames) {
            val newCar = Car(name, INITIAL_CAR_MOVEMENT_COUNT)
            listOfCar.add(newCar)
        }
    }
    fun raceAllCarInList() {
        for (i in 0 until listOfCar.size) {
            forwardCar(i)
        }
    }
   private fun forwardCar(idx: Int) {
        val randomNumber = Randoms.pickNumberInRange(0,9)
        if (randomNumber >= 4) {
            listOfCar[idx].movementCount += 1
        }
    }
    fun printCurrentCarMovement() {
        for (i in 0 until listOfCar.size) {
            val currentCar = listOfCar[i]
            print("${currentCar.name} : ")
            println("-".repeat(currentCar.movementCount))
        }
        println()
    }
    fun printBeatPlayer() {
        val bestPlayers = chooseBestPlayer()
        var playerNameList = mutableListOf<String>()
        for (player in bestPlayers)
            playerNameList.add(player.name)
        println(playerNameList.joinToString())
    }
    private fun chooseBestPlayer(): List<Car> {
        val sortedList = listOfCar.sortedByDescending { it.movementCount }
        val maximumOfMovement = sortedList[0].movementCount
        return sortedList.filter { it.movementCount == maximumOfMovement }
    }
}


class CarRacingGame {
    private val gameStatus = GameStatus()

    fun gameStart() {
        println(INPUT_CAR_NAME_MESSAGE)
        val inputNames = Console.readLine()
        val listOfCarName = checkValidName(inputNames)

        println(INPUT_TRIAL_NUMBER_MESSAGE)
        val inputCount = Console.readLine()
        val validCount = checkValidNumber(inputCount)

        gameStatus.initStatus(listOfCarName, validCount)
        startRacing()
        endRacing()
    }
    fun startRacing() {
        println(RACING_START_MESSAGE)
        val count = gameStatus.countOfTrial
        for (i in 0 until count) {
            gameStatus.raceAllCarInList()
            gameStatus.printCurrentCarMovement()
        }
    }
    fun endRacing() {
        print(PRINT_RACING_RESULT_MESSAGE)
        gameStatus.printBeatPlayer()
    }
    fun checkValidName(stringOfNames: String): List<String> {
        val listOfCarName = stringOfNames.split(",")
        for (name in listOfCarName) {
            if (name.length > 5)
                throw IllegalArgumentException("5자 초과인 이름 입력 발생")
        }
        return listOfCarName
    }
    fun checkValidNumber(countString: String): Int {
        if (countString.toIntOrNull() == null) {
            throw IllegalArgumentException("숫자가 아닌 입력 발생")
        }
        return countString.toInt()
    }
}

