package racingcar.controller

import racingcar.model.Car
import racingcar.view.RacingCarView

class RacingCarController {
    var racingCarView = RacingCarView()
    private var carList = mutableListOf<Car>()
    var forwardCount: Int = 0
    fun run(){
        var inputForCarName  = racingCarView.getUserInputForCarName()
        // 예외 처리
        var carList: List<String> = inputForCarName.split(",")
        initializeCars(carList)
        var inputForForwardCount = racingCarView.getUserInputForForwardCount()
        racingCarView.printResultMessage()
        for (i in 0 until forwardCount){

            //racingCarView.printGameResult()
        }
    }

    private fun initializeCars(carNames: List<String>){
        for(carName in carNames){
            var car = Car(carName)
            carList.add(car)
        }
    }

    private fun validateCarNames(carNames: String): List<String>{
        val carNamesRegex = "^[0-9a-zA-Z][0-9a-zA-Z,]*[0-9a-zA-Z]\$".toRegex()
        val carNameRegex = "^[0-9a-zA-Z]{1,5}$".toRegex()
        if (!carNamesRegex.matches(carNames)){
            throw IllegalArgumentException()
        }

        var carNameList: List<String> = carNames.split(",")

        for (carName in carNameList){
            if (carNameRegex.matches(carName)){
                throw IllegalArgumentException("")

            }
        }
        return carNameList
    }
}