package racingcar.model

class CarModel(val name: String, var position: Int = 0) {
    fun move() {
        if(Generator.numberGenerator() >= 4) position++
    }
}