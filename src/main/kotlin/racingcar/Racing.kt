package racingcar

class RacingGame {
    private var playerList= mutableListOf<String>()
    private var carList = mutableListOf<Car>()
    private var winnerList= mutableListOf<String>()
    private var N = 0
    private var inputManager = InputManager()

    fun playGame() {
        prepareRace()
        setGamePlayCount()
    }

    fun prepareRace() {
        playerList = inputManager.getCarName()

        // carList.add()
        inputManager.getTryTime()
    }

    fun printRacingResult() {

    }

    fun setGamePlayCount() {
        N = inputManager.getTryTime()
    }

    fun getPlayCount() = N
    fun getPlayerList() = playerList
}