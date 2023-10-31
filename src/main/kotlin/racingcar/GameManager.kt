package racingcar

import javax.swing.text.Caret

class GameManager {

    private val gameConsole = GameConsole()
    private lateinit var racingGame: Race

    fun runGame() {
        val userInputReader = UserInputReader()
        val carList = initializeCarList(userInputReader.getCarName())
        val roundCnt = userInputReader.getRoundCount()

        racingGame = Race(carList)
        startRace(roundCnt)
        setWinner()
    }

    private fun initializeCarList(carNameList: List<String>): List<Car> {
        return carNameList.map { carName ->
            Car(carName)
        }.toList()
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