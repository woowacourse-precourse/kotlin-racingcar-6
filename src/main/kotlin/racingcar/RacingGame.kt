package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGame {
    private val userClient = UserClient()
    private lateinit var carList :List<Car>
    fun gameStart(){
        carList = userClient.inputCarNames()
        val countMove = userClient.inputCountMove()
        runCars(countMove)
    }

    private fun runCars(countMove: Int) {
        repeat(countMove){
            startOneRound()
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