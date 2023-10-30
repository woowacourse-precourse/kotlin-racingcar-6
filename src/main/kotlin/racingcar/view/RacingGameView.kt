package racingcar.view

import racingcar.utils.ConsoleMessage
import racingcar.model.RacingGameModel
class RacingGameView {
    val model = RacingGameModel()
    fun requestCarNameInputMessage() {
        println(ConsoleMessage.REQUEST_CAR_NAME_INPUT)
    }
    fun requestPlayCountInputMessage() {
        println(ConsoleMessage.REQUEST_PLAY_COUNT_INPUT)
    }
    fun informShowProgressMessage(carList: MutableList<Pair<String, Int>>, playCount: Int) {
        println(ConsoleMessage.SHOW_PROGRESS)
        repeat(playCount) {
            showCarProgress(model.raceTrial(carList))
            println()
        }
    }
    fun showCarProgress(carList: List<Pair<String, Int>>) {
        for(i in 0 until carList.count()) {
            println("${carList[i].first} : ${visualCarMovedDistance(carList[i].second)}")
        }
    }
    fun showFinalResultMessage(winnerList: List<String>) {
        print("${ConsoleMessage.SHOW_WINNER}${winnerList.joinToString(", ")}")
    }
    private fun visualCarMovedDistance(distance: Int): String {
        var visualDistance = ""
        repeat(distance) {
            visualDistance += "-"
        }
        return visualDistance
    }
}