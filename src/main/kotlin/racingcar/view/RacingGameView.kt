package racingcar.view

import racingcar.utils.ConsoleMessage

class RacingGameView {
    fun requestCarNameInputMessage() {
        println(ConsoleMessage.REQUEST_CAR_NAME_INPUT)
    }
    fun requestPlayCountInputMessage() {
        println(ConsoleMessage.REQUEST_PLAY_COUNT_INPUT)
    }
    fun showProgressMessage() {
        println(ConsoleMessage.SHOW_PROGRESS)
    }
}