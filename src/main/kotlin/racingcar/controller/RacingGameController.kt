package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.view.RacingGameView
import racingcar.model.RacingGameModel
import racingcar.utils.ErrorMessage
import racingcar.utils.Values

class RacingGameController(private val view: RacingGameView, private val model: RacingGameModel) {
    lateinit var carList: List<String>
    fun run() {
        view.requestCarNameInput()
        if (isAnyCarNameLengthExceeded(carList = getCarList())) {
            throw IllegalArgumentException("${ErrorMessage.ERRORMESSAGE_CAR_NAME_LENGTH_EXCEEDED} ${Values.MAXIMUM_CAR_NAME_LENGTH}")
        }

    }
    private fun getCarList(): List<String> {
        return listOf(*Console.readLine().split(",").toTypedArray<String>())
    }

    private fun isAnyCarNameLengthExceeded(carList: List<String>): Boolean {
        for (i in carList) {
            if (i.length > Values.MAXIMUM_CAR_NAME_LENGTH) {
                return false
            }
        }
        return true
    }
}