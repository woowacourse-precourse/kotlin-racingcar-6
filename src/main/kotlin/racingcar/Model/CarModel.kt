package racingcar.Model

import racingcar.View.CarView

class CarModel {
    fun carNameLimit(carNameInput: List<String>) {
        for (car in carNameInput) {
            if (car.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
            }
        }
    }
    fun moveCar(carNameInput: List<String>, carMove: MutableMap<String,Int>,view: CarView){
        for (car in carNameInput) {
            if ((0..9).random() >= 4) {
                carMove[car] = (carMove[car] ?: 0) + 1
            }
        }
        for (car in carNameInput) {
            val distance = carMove[car] ?: 0
            view.printMoveCar(car,distance)
        }
    }
}