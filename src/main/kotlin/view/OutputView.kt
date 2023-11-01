package view

import service.Message

class OutputView {
    fun printRequireCarNames(){
        println(Message.REQUIRE_CAR_NAME.toString())
    }

    fun printRequireTry(){
        println(Message.REQUIRE_TRY.toString())
    }
}