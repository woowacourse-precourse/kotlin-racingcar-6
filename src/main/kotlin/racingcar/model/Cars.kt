package racingcar.model

class Cars(val cars: List<Car>) {
    fun validate(cars: List<Car>): Boolean {
        return true
    }
    private fun validateDuplicate(cars: List<Car>): Boolean {
        return true
    }

}