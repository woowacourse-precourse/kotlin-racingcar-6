package racingcar.model

object RacingCarService {
    fun createRacingCars(carNameList: List<String>): List<RacingCar> {
        require(MINIMUM_CAR_NUMBER <= carNameList.size) { MESSAGE_CAR_MINIMUM_REQUIRED }
        require(carNameList.toSet().size == carNameList.size) { MESSAGE_DUPLICATE_CAR_NAME }
        return carNameList.map { RacingCar(it, moveStrategy = RandomMoveStrategy()) }
    }

    fun moveAllCars(carList: List<RacingCar>) {
        carList.forEach { it.moveForward() }
    }

    fun getMaxPosition(carList: List<RacingCar>) = carList.maxBy { it.position }.position

    fun getWinnerNames(carList: List<RacingCar>, maxPosition: Int): List<String> {
        val winnerList = carList.filter { it.position == maxPosition }
        return winnerList.map { it.name }
    }

    private const val MINIMUM_CAR_NUMBER = 2
    private const val MESSAGE_CAR_MINIMUM_REQUIRED = "2대 이상의 자동차가 필요합니다."
    private const val MESSAGE_DUPLICATE_CAR_NAME = "자동차 이름은 서로 중복될 수 없습니다."
}