package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame {
    private val userClient = UserClient()
    private lateinit var carList :List<Car>
    fun gameStart(){
        carList = userClient.inputCarNames()
        val countRound = userClient.inputRoundCount()
        userClient.printResultMessage()
        runCars(countRound)
        userClient.printResult(carList)
    }

    private fun runCars(countRound: Int) {
        repeat(countRound){
            startOneRound()
            userClient.printCarStatus(carList)
        }
    }

    private fun startOneRound() {
        carList.forEach { car->
            runOrStop(car)
        }
    }

    private fun runOrStop(car: Car) {
        val randomNumber = Randoms.pickNumberInRange(0,9)
        if(randomNumber>=4){
            car.runOneTime()
        }
    }
}