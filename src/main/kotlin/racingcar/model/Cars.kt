package racingcar.model

class Cars(private val cars: List<Car>) {

    init {
        require(cars.size == cars.toSet().size) { "중복된 이름이 존재합니다!" }
    }
}