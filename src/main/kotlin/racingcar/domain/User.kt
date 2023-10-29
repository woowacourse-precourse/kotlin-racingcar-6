package racingcar.domain

import racingcar.domain.car.Car
import racingcar.domain.car.Cars


class User {
    fun askCarName(input: String, cars: Cars): Cars {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNameList = input.split(",")
        for (carName in carNameList) {
            if (carName.length > 5) throw IllegalArgumentException("String index out of range: 5")
            cars.addCar(Car(carName))
        }
        return cars
    }

    fun askNumber(count: String): Int {
        println("시도할 횟수는 몇 회인가요?")
        return count.toIntOrNull() ?: throw IllegalArgumentException("Input is not Int")
    }
}