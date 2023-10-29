import racingcar.model.car.Car
import racingcar.model.car.CarFactory
import racingcar.model.car.CarName
import racingcar.model.car.RandomEngine

class CarFactoryImpl : CarFactory {
    override fun create(name: CarName): Car = Car(name, RandomEngine())
}