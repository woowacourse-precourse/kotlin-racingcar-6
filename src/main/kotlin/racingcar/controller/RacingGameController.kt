package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.view.RacingGameView
import racingcar.model.RacingGameModel
import racingcar.utils.ErrorMessage
import racingcar.utils.Values
import java.lang.NumberFormatException

class RacingGameController(private val view: RacingGameView, private val model: RacingGameModel) {
    fun run() {
        val carList: MutableList<Pair<String, Int>> = mutableListOf()
        val playCount: Int
        view.requestCarNameInputMessage()
        val carNameList: List<String> = setCarList()
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
        view.informShowProgressMessage(carList, playCount)
        val highScore: Int = setHighScore(carList)
        val winnerList: List<String> = setWinnerList(carList, highScore)
        view.showFinalResultMessage(winnerList)
    }
    private fun setCarList(): List<String> {
        return listOf(*Console.readLine().split(",").toTypedArray<String>())
    }
    private fun setPlayCount(): String {
        return Console.readLine()
    }
    private fun setHighScore(carList: MutableList<Pair<String, Int>>): Int {
        var highScore = 0
        for(i in 0 until carList.count()) {
            highScore = getMaxValue(Pair(highScore, carList[i].second))
        }
        return highScore
    }
    private fun setWinnerList(carList: List<Pair<String, Int>>, highScore: Int): List<String> {
        var winnerList: List<String> = listOf()
        for(i in 0 until carList.count()) {
            if(carList[i].second == highScore) {
                winnerList = winnerList.plus(carList[i].first)
            }
        }
        return winnerList
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