package service

import domain.CarManager
import view.View

class Controller {
    private val carManager = CarManager()
    private val view = View()

    fun play() {
        val carNames = view.requireCarNames()
        val tryCnt = view.requireTryCnt()
        carManager.getNamesAndMakeCars(carNames)
        carManager.getTryCnt(tryCnt)
        do {
            carManager.nextStep()
            view.printStep(carManager.getCars())
        } while (carManager.confirmWinners().isEmpty())
        val winner = carManager.confirmWinners()
        view.printResult(winner)
    }
}