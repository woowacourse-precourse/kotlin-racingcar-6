package racingcar.domain

class Winners(cars: List<RacingCar>) {
    private val winningList: List<CarName>

    init {
        val maxPosition = cars.maxOf { it.getPosition() }
        winningList = cars.filter { it.getPosition() == maxPosition }.map { it.getName() }
    }

    override fun toString(): String = "최종 우승자 : ${winningList.joinToString(", ")}"
}