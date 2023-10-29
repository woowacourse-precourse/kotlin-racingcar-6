package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.view.RacingGameView
import racingcar.model.RacingGameModel
import racingcar.utils.ErrorMessage
import racingcar.utils.Values
import java.lang.NumberFormatException
import kotlin.properties.Delegates

class RacingGameController(private val view: RacingGameView, private val model: RacingGameModel) {
    private lateinit var carNameList: List<String>
    private var playCount by Delegates.notNull<Int>()
    private var carList: MutableList<Pair<String, Int>> = mutableListOf()
    private var winnerList: List<String> = listOf()
    private var bestScore = 0

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
        for(i in 0 until carList.count()) {
            bestScore = getMaxValue(Pair(bestScore, carList[i].second))
        }
        for(i in 0 until carList.count()) {
            if(carList[i].second == bestScore) {
                winnerList = winnerList.plus(carList[i].first)
            }
        }
        view.showFinalResultMessage()
        print(winnerList.joinToString(","))
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
    private fun getMaxValue(compareValues: Pair<Int, Int>): Int {
        return if(compareValues.first > compareValues.second) {
            compareValues.first
        } else {
            compareValues.second
        }
    }
}