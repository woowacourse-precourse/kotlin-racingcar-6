package view

import constants.Strings

class OutputView {
    fun outputCarList() {
        println(Strings.INPUT_CAR_NAME)
    }

    fun outputTryNum() {
        println(Strings.INPUT_TRY_NUM)
    }

    fun outputTryResult() {
        println("\n" + Strings.TURN_RESULT)
    }
}