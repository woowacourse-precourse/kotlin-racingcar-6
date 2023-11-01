package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.car.Car
import racingcar.model.car.CarFactory
import racingcar.model.car.CarName

class TestCarFactory : CarFactory {
    private val carTypeMap: MutableMap<CarName, CarType> = mutableMapOf()

    override fun create(name: CarName): Car {
        val carType = carTypeMap.getOrDefault(key = name, defaultValue = CarType.RANDOM)

        return when (carType) {
            CarType.ALWAYS_GO_FORWARD -> Car(name = name, randomNumberGenerator = alwaysGoForward)
            CarType.NEVER_GO_FORWARD -> Car(name = name, randomNumberGenerator = neverGoForward)
            CarType.RANDOM -> Car(name = name, randomNumberGenerator = random)
        }
    }

    fun setCarTypeOf(vararg entries: Pair<CarName, CarType>) {
        entries.forEach { (key, value) -> carTypeMap[key] = value }
    }

    enum class CarType {
        ALWAYS_GO_FORWARD, NEVER_GO_FORWARD, RANDOM
    }

    companion object {
        private val alwaysGoForward: (Int, Int) -> Int = { _, _ -> 9 }
        private val neverGoForward: (Int, Int) -> Int = { _, _ -> 1 }
        private val random: (Int, Int) -> Int = Randoms::pickNumberInRange
    }
}