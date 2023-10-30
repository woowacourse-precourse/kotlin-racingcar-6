package racingcar.controller

import racingcar.model.Car
import racingcar.view.RacingCarView

class RacingCarController {
    var racingCarView = RacingCarView()
    private var carList = mutableListOf<Car>()
    var forwardCount: Int = 0
    fun run() {
        var inputForCarName = racingCarView.getUserInputForCarName()
        if (!InputValidator.validateCarNameString(inputForCarName)) {
            throw IllegalArgumentException("이름은 쉼표(,)로 구분되어야 합니다.")
        }

        val carNameList: List<String> = inputForCarName.split(",")
        if (!InputValidator.validateCarName(carNameList)) {
            throw IllegalArgumentException("자동차 이름은 숫자, 영문으로 이루어져 있어야 하며 5글자 이내로 제한됩니다.")
        }

        var inputForForwardCount = racingCarView.getUserInputForForwardCount()
        if (!InputValidator.validateNumber(inputForForwardCount)) {
            throw IllegalArgumentException("시도 횟수는 양의 정수민 입력 가능합니다.")
        }

        racingCarView.printResultMessage()
        initializeCars(carNameList)
        for (i in 0 until forwardCount) {

            racingCarView.printGameResult(carList)
        }
    }

    private fun initializeCars(carNames: List<String>) {
        for (carName in carNames) {
            var car = Car(carName)
            carList.add(car)
        }
    }
}