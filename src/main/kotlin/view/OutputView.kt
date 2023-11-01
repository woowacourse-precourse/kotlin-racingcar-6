package view

import domain.Car
import service.Message

class OutputView {
    fun printRequireCarNames(){
        println(Message.REQUIRE_CAR_NAME.toString())
    }

    fun printRequireTry(){
        println(Message.REQUIRE_TRY.toString())
    }

    fun printStep(car: Car) {
        print(car.getName() + " : ")
        println("-".repeat(car.getCurrentPosition()))
    }

    fun printResult(winners: List<String>) {
        print(Message.RESULT.toString())
        println(winners.toString().subSequence(1,winners.toString().length-1))
    }
}