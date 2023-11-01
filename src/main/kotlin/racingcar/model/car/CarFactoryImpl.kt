import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.car.Car
import racingcar.model.car.CarFactory
import racingcar.model.car.CarName

class CarFactoryImpl : CarFactory {
    override fun create(name: CarName): Car = Car(
        name = name,
        randomNumberGenerator = Randoms::pickNumberInRange
    )
}