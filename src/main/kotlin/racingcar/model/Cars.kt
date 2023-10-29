package racingcar.model

class Cars(val cars: List<Car>) {
    fun validate() {
        validateDuplicate()
        cars.forEach(Car::validateCar)
    }
    private fun validateDuplicate() {
        val set = cars.map(Car::name).toSet()
        if (cars.size > set.size) {
            throw IllegalArgumentException("차에 중복된 이름이 있습니다.")
        }
    }

}