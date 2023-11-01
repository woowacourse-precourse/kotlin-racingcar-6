package service

import domain.CarManager
import view.View

class Controller {
    private val carManager = CarManager()

    fun play() {
        carManager.getNamesAndMakeCars()
        carManager.getTryCnt()
    }
}