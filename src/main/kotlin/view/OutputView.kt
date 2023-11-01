package view

import service.Message

class OutputView {
    fun requireCarNames(){
        println(Message.REQUIRE_CAR_NAME.toString())
    }

    fun requireTry(){
        println(Message.REQUIRE_TRY.toString())
    }
}