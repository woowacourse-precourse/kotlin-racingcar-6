package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.view.RacingGameView
import racingcar.model.RacingGameModel
import racingcar.utils.ErrorMessage
import racingcar.utils.Values
import java.lang.NumberFormatException

class RacingGameController(private val view: RacingGameView, private val model: RacingGameModel) {
    private var carList: MutableList<Pair<String, Int>> = mutableListOf()
    private lateinit var carNameList: List<String>
    private var playCount = 5
    fun run() {
        view.requestCarNameInputMessage()
        carNameList = setCarList()
        if (isAnyCarNameLengthExceeded(carNameList)) {
            throw IllegalArgumentException("${ErrorMessage.ERRORMESSAGE_CAR_NAME_LENGTH_EXCEEDED} ${Values.MAXIMUM_CAR_NAME_LENGTH}")
        }
        carList.addAll(carNameList.map { carName -> carName to 0 })
        view.requestPlayCountInputMessage()
        try {
            playCount = setPlayCount().toInt()
            checkPlayCountNatural(playCount)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.ERRORMESSAGE_PLAY_COUNT_NOT_NATURAL)
        }
        view.informShowProgressMessage()
        repeat(playCount) {
            view.showCarProgress(model.raceTrial(carList))
            println()
        }
    }

    @JvmName("callFromString")
    private fun setCarList(): List<String> {
        return listOf(*Console.readLine().split(",").toTypedArray<String>())
    }

    private fun setPlayCount(): String {
        return Console.readLine()
    }

    private fun isAnyCarNameLengthExceeded(carNameList: List<String>): Boolean {
        for (i in carNameList) {
            if (i.length > Values.MAXIMUM_CAR_NAME_LENGTH) {
                return true
            }
        }
        return false
    }

    private fun checkPlayCountNatural(playCount: Int) {
        if (playCount < 1) {
            throw IllegalArgumentException(ErrorMessage.ERRORMESSAGE_PLAY_COUNT_NOT_NATURAL)
        }
    }
}