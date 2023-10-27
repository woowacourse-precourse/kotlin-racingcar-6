package race

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.IllegalArgumentException

class Race {
    private val garage = mutableMapOf<String, Int>()

    companion object {
        fun run() {
            val race = Race()
            race.inputCar()
        }
    }
    fun inputCar() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼포(,) 기준으로 구분")
        val cars = Console.readLine().split(',')
        for (car in cars) {
            val trimmedCar = car.trim()
            garage[trimmedCar] = 0
        }
    }
}