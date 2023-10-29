package racingcar.view

import racingcar.utils.ConsoleMessage

class RacingGameView {
    fun requestCarNameInputMessage() {
        println(ConsoleMessage.REQUEST_CAR_NAME_INPUT)
    }
    fun requestPlayCountInputMessage() {
        println(ConsoleMessage.REQUEST_PLAY_COUNT_INPUT)
    }
    fun informShowProgressMessage() {
        println(ConsoleMessage.SHOW_PROGRESS)
    }
    fun showCarProgress(carList: List<Pair<String, Int>>) {
        for(i in 0 until carList.count()) {
            println("${carList[i].first} : ${visualCarMovedDistance(carList[i].second)}")
        }
    }
    private fun visualCarMovedDistance(distance: Int): String {
        var visualDistance = "-"
        repeat(distance) {
            visualDistance += "-"
        }
        return visualDistance
    }
}