package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame {
    private val userClient = UserClient()
    private lateinit var carList :List<Car>
    fun gameStart(){
        carList = userClient.inputCarNames()
        val countMove = userClient.inputCountMove()
        userClient.printResultMessage()
        runCars(countMove)
        userClient.printResult(carList)
    }

    private fun runCars(countMove: Int) {
        repeat(countMove){
            startOneRound()
            userClient.printCarStatus(carList)
        }
    }

    private fun startOneRound() {
        carList.forEach { car->
            runOrStopCar(car)
        }
    }

    private fun runOrStopCar(car: Car) {
        val randomNumber = Randoms.pickNumberInRange(0,9)
        if(randomNumber>=4){
            car.runOneTime()
        }
    }
}