package racingcar

import camp.nextstep.edu.missionutils.Console

class CarRacingGame {
    private val gameStatus = GameStatus()

    fun gameStart() {
        println(INPUT_CAR_NAME_MESSAGE)
        val inputNames = Console.readLine()
        val listOfCarName = checkValidName(inputNames)

        println(INPUT_TRIAL_NUMBER_MESSAGE)
        val inputCount = Console.readLine()
        val validCount = checkValidNumber(inputCount)
        println()

        gameStatus.initStatus(listOfCarName, validCount)
        startRacing()
        endRacing()
    }
    private fun startRacing() {
        println(RACING_START_MESSAGE)
        val count = gameStatus.getCountOfTrial()
        for (i in 0 until count) {
            gameStatus.raceAllCarInList()
            gameStatus.printCurrentCarMovement()
        }
    }
    private fun endRacing() {
        print(PRINT_RACING_RESULT_MESSAGE)
        gameStatus.printBeatPlayer()
    }
    private fun checkValidName(stringOfNames: String): List<String> {
        val listOfCarName = stringOfNames.split(",")
        for (name in listOfCarName) {
            if (name.length > 5)
                throw IllegalArgumentException("5자 초과인 이름 입력 발생")
        }
        return listOfCarName
    }
    private fun checkValidNumber(countString: String): Int {
        if (countString.toIntOrNull() == null) {
            throw IllegalArgumentException("숫자가 아닌 입력 발생")
        }
        return countString.toInt()
    }
}