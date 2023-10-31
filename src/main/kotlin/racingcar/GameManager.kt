package racingcar

class GameManager {
    fun startGame() {
        val userInputReader = UserInputReader()
        val carNameList = userInputReader.getCarName()
        val roundCnt = userInputReader.getRoundCount()
        val carList = carNameList.map { carName ->
            Car(carName)
        }.toList()

        val racingGame = Race(carList, roundCnt)
        racingGame.startRace()
    }
}