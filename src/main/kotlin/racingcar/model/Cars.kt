package racingcar.model

data class Cars(private val inputCars: List<Car>) {
    private var _carList: List<Car>
    val carList: List<Car> get() = _carList

    init {
        checkDuplicateName()
        _carList = inputCars
    }

    // TODO: 매직 스트링 제거, 디버깅 출력문 제거
    private fun checkDuplicateName() {
        require(inputCars.size == inputCars.distinct().size) { "자동차 이름 : 중복된 이름이 있습니다." }
    }
}