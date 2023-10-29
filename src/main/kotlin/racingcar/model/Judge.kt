package racingcar.model

import racingcar.RandomGenerator

class Judge(private val carGroup: CarGroup) {

    // todo 리턴 타입을 매핑하는게 가독성에 더 좋을 것 같은데.. 오히려 더 복잡해 보이는 것 같기도 하고..
    fun play(): CarGroup {
        carGroup.cars.forEach(::calculate)
        return carGroup
    }

    fun getWinner(): List<Car> = carGroup.getCarsWithLongestDistance()

    private fun calculate(car: Car) {
        // todo 이 랜덤 값을 어떻게 테스트하면 좋을지...
        val score = RandomGenerator.pickNumber(RANDOM_START_NUMBER, RANDOM_END_NUMBER)
        if (score >= MOVING_POINT) {
            car.moveForward()
        }
    }

    companion object {
        private const val RANDOM_START_NUMBER = 0
        private const val RANDOM_END_NUMBER = 0
        private const val MOVING_POINT = 4
    }
}