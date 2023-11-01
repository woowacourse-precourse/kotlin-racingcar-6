package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

class Input {

    fun inputCarName(): List<Car> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return readLine().split(",").map { Car(it) }
    }
}