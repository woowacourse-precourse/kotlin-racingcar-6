package racingcar

class GameManager {
    fun startGame() {
        val userInputReader = UserInputReader()
        val carNameList = userInputReader.getCarName()
        val roundCnt = userInputReader.getRoundCount()
    }
}