package racingcar

class RacingGame {
    private var playerList= mutableListOf<String>()
    private var carList = mutableListOf<Car>()
    private var winnerList= mutableListOf<String>()
    private var racingGameCount = 0
    private var inputManager = InputManager()

    fun playGame() {
        prepareRace()
        setRacingPlayer()
        racingProcess()
        printRacingResult()
    }

    private fun racingProcess() {
        while(racingGameCount != 0) {
            for(x in 0 until playerList.size) {
                playerOperation(carList[x])
            }
            --racingGameCount
            println()
        }
        selectWinner()
    }

    private fun selectWinner() {
        var MAX = 0

        for(x in 0 until playerList.size) {
            if(carList[x].getLocation() > MAX) {
                winnerList.clear()
                winnerList.add(carList[x].getName())
                MAX = carList[x].getLocation()
            }
            else if(carList[x].getLocation() == MAX) {
                winnerList.add(carList[x].getName())
            }
        }
    }

    private fun playerOperation(car: Car) {
        car.setNewRandomNumber()
        if(car.compareRandom()) {
            car.moveForward()
        }
        car.printLocation()
    }

    private fun prepareRace() {
        playerList = inputManager.getCarName()
        racingGameCount = inputManager.getTryTime()

        setRacingPlayer()
    }

    private fun setRacingPlayer() {
        for(x in 0 until playerList.size) {
            if (playerList[x].length > 5) {
                throw IllegalArgumentException("")
            }
            val initCar = Car(playerList[x])
            carList.add(initCar)
        }
    }

    private fun printRacingResult() {
        print("최종 우승자 : ${winnerList.joinToString(", ")}")
    }

    fun getPlayCount() = racingGameCount
    fun getPlayerList() = playerList
}