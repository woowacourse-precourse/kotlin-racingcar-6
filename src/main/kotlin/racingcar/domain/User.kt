package racingcar.domain

import racingcar.domain.car.Car
import racingcar.domain.car.Cars

class User {
    fun askCarName(input: String, cars: Cars): Cars {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNameList = input.split(",")
        val validNameRegex = "^[0-9A-Za-z가-힣]{1,5}".toRegex()
        for (carName in carNameList) {
            if (carName.length > 5) {
                throw IllegalArgumentException("차의 이름 길이가 5 이하 이어야 합니다.")
            }
            if (carName.isBlank()) {
                throw IllegalArgumentException("차의 이름이 공백일 수 없습니다.")
            }
            if (!carName.matches(validNameRegex)) {
                throw IllegalArgumentException("차의 이름은 특수 문자를 포함할 수 없습니다.")
            }
            cars.addCar(Car(carName))
        }
        return cars
    }

    fun askNumber(count: String): Int {
        println("시도할 횟수는 몇 회인가요?")
        if (count.isBlank()) {
            throw IllegalArgumentException("시도할 횟수가 공백일 수 없습니다.")
        }
        if (count.toIntOrNull() == null) {
            throw IllegalArgumentException("시도할 횟수는 정수 이어야 합니다.")
        }
        if (count.toIntOrNull()!! < 0) {
            throw IllegalArgumentException("시도할 횟수는 0 이상 이어야 합니다.")
        }
        return count.toIntOrNull()!!
    }
}