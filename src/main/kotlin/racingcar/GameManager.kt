package racingcar

class GameManager {

    private val gameConsole = GameConsole()
    private lateinit var racingGame: Race

    fun runGame() {
        val userInputReader = UserInputReader()
        val carNameList = userInputReader.getCarName()
        val roundCnt = userInputReader.getRoundCount()
        val carList = carNameList.map { carName ->
            Car(carName)
        }.toList()

        racingGame = Race(carList)
        startRace(roundCnt)
        setWinner()
    }

    private fun startRace(roundCnt: Int) {
        gameConsole.printRoundResultTitle()
        for (cnt in 1..roundCnt) {
            gameConsole.printRoundResult(racingGame.startRound())
        }
    }

    private fun setWinner() {
        val winnerList = racingGame.findWinner()
        gameConsole.printWinner(winnerList)
    }
}