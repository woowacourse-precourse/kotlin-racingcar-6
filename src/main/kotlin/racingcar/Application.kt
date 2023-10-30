package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carRacingGame = CarRacingGame()
    carRacingGame.gameStart()
}

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
            val newCar = Car(name, 0)
            listOfCar.add(newCar)
        }
    }
}

const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val INPUT_TRIAL_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?"
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
        //startRace(listOfCarName, countOfTrial)
    }

    fun checkValidName(stringOfNames: String): List<String> {
        val listOfCarName = stringOfNames.split(",")
        for (name in listOfCarName) {
            if (name.length > 5)
                throw IllegalArgumentException("5자 이상인 이름 입력 발생")
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

