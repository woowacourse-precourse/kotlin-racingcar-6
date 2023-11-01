package racingcar

class RacingGame {
    private var playerList= mutableListOf<String>()
    private var carList = mutableListOf<Car>()
    private var winnerList= mutableListOf<String>()
    private var N = 0
    private var inputManager = InputManager()

    fun playGame() {
        prepareRace()
        setRacingPlayer()

        printRacingResult()
    }

    private fun prepareRace() {
        playerList = inputManager.getCarName()
        N = inputManager.getTryTime()

        setRacingPlayer()
    }

    private fun setRacingPlayer() {
        for(x in 0 until playerList.size) {
            val initCar = Car(playerList[x])
            carList.add(initCar)
        }
    }

    private fun printRacingResult() {
        print("최종 우승자 : ${winnerList.joinToString(", ")}")
    }

    fun getPlayCount() = N
    fun getPlayerList() = playerList
}