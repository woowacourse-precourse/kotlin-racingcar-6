package racingcar.app

import racingcar.controller.GameController
import racingcar.view.ScreenView

class Racing {
    private val view = ScreenView()
    private val controller = GameController(view = view)
    fun run() {
        val raceCars = controller.inputCars() // Cars 객체
        val racingCount = view.inputGameCount() // Int

        println("실행 결과")
        for (i: Int in 1..racingCount) {
            raceCars.cars.forEach{
                controller.goOrNot(it)
            }
            view.printTrace(raceCars.cars)
        }

        val winners = controller.getWinners(raceCars.cars)
        if (winners != null) {
            view.printWinners(winners)
        }
    }
}