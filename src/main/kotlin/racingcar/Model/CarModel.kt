package racingcar.Model

class CarModel {
    fun carNameLimit(carNameInput: List<String>) {
        for (car in carNameInput) {
            if (car.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
            }
        }
    }
}