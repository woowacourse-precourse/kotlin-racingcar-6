package racingcar.model

data class Cars(
    private val inputCars: List<Car>,
) {
    private var _carList: List<Car>
    val carList: List<Car> get() = _carList

    init {
        checkDuplicateName()
        _carList = inputCars
    }

    private fun checkDuplicateName() =
        require(inputCars.size == inputCars.distinct().size) { CAR_NAME_DUPLICATE_ERROR }

    companion object {
        private const val CAR_NAME_DUPLICATE_ERROR = "자동차 이름은 중복될 수 없습니다."

        fun fromNames(names: List<String>): Cars {
            return Cars(names.map {
                Car(it)
            })
        }
    }
}