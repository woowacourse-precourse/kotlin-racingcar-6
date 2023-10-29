package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.view.RacingGameView
import racingcar.model.RacingGameModel
import racingcar.utils.ErrorMessage
import racingcar.utils.Values
import java.lang.NumberFormatException
import kotlin.properties.Delegates

class RacingGameController(private val view: RacingGameView, private val model: RacingGameModel) {
    private lateinit var carList: List<String>
    private var playCount by Delegates.notNull<Int>()
    fun run() {
        view.requestCarNameInput()
        if (isAnyCarNameLengthExceeded(carList = setCarList())) {
            throw IllegalArgumentException("${ErrorMessage.ERRORMESSAGE_CAR_NAME_LENGTH_EXCEEDED} ${Values.MAXIMUM_CAR_NAME_LENGTH}")
        }
        view.requestPlayCountInput()
        try {
            checkPlayCountNatural(playCount = setPlayCount().toInt())
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.ERRORMESSAGE_PLAY_COUNT_NOT_NATURAL)
        }
    }
    @JvmName("callFromString")
    private fun setCarList(): List<String> {
        return listOf(*Console.readLine().split(",").toTypedArray<String>())
    }
    private fun setPlayCount(): String {
        return Console.readLine()
    }
    private fun isAnyCarNameLengthExceeded(carList: List<String>): Boolean {
        for (i in carList) {
            if (i.length > Values.MAXIMUM_CAR_NAME_LENGTH) {
                return true
            }
        }
        return false
    }
    private fun checkPlayCountNatural(playCount: Int) {
        if(playCount > 0) {
            throw IllegalArgumentException(ErrorMessage.ERRORMESSAGE_PLAY_COUNT_NOT_NATURAL)
        }
    }
}