package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.view.RacingGameView
import racingcar.model.RacingGameModel
import racingcar.utils.ErrorMessage
import racingcar.utils.Values
import java.lang.NumberFormatException

class RacingGameController(private val view: RacingGameView, private val model: RacingGameModel) {
    fun run() {
        view.requestCarNameInputMessage()
        val carNameList: List<String> = setCarNameList()
        checkAnyCarNameIsInvalid(carNameList)
        val carList: MutableList<Pair<String, Int>> = carNameList.map { it to 0 }.toMutableList()
        view.requestPlayCountInputMessage()
        val playCount: Int = checkPlayCountIsNatural()
        view.informShowProgressMessage(carList, playCount)
        val highScore: Int = setHighScore(carList)
        val winnerList: List<String> = setWinnerList(carList, highScore)
        view.showFinalResultMessage(winnerList)
    }
    private fun setCarNameList(): List<String> {
        return listOf(*Console.readLine().split(",").toTypedArray<String>())
    }
    private fun setPlayCount(): String {
        return Console.readLine()
    }
    private fun setHighScore(carList: MutableList<Pair<String, Int>>): Int {
        var highScore = 0
        for (i in 0 until carList.count()) {
            highScore = getMaxValue(Pair(highScore, carList[i].second))
        }
        return highScore
    }
    private fun setWinnerList(carList: List<Pair<String, Int>>, highScore: Int): List<String> {
        var winnerList: List<String> = listOf()
        for (i in 0 until carList.count()) {
            if (carList[i].second == highScore) {
                winnerList = winnerList.plus(carList[i].first)
            }
        }
        return winnerList
    }
    private fun getMaxValue(compareValues: Pair<Int, Int>): Int {
        return if (compareValues.first > compareValues.second) {
            compareValues.first
        } else {
            compareValues.second
        }
    }
    private fun checkAnyCarNameIsInvalid(carNameList: List<String>) {
        for (i in carNameList) {
            if (i.length > Values.MAXIMUM_CAR_NAME_LENGTH) {
                throw IllegalArgumentException("${ErrorMessage.ERRORMESSAGE_CAR_NAME_LENGTH_EXCEEDED} ${Values.MAXIMUM_CAR_NAME_LENGTH}")
            }
        }
    }
    private fun checkPlayCountIsNatural(): Int {
        try {
            val playCount = setPlayCount().toInt()
            checkPlayCountNatural(playCount)
            return playCount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ErrorMessage.ERRORMESSAGE_PLAY_COUNT_NOT_NATURAL)
        }
    }
    private fun checkPlayCountNatural(playCount: Int) {
        if (playCount < 1) {
            throw IllegalArgumentException(ErrorMessage.ERRORMESSAGE_PLAY_COUNT_NOT_NATURAL)
        }
    }
}