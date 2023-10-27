package race

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.IllegalArgumentException

class Race {
    public val garage = mutableMapOf<String, Int>()

    companion object {
        fun run() {
            val race = Race()
            race.inputCar()
        }
    }
    fun inputCar() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분")
        val carString = Console.readLine()
        checkCar(carString)
    }

    private fun checkCar(carString:String) {
        if (carString.isEmpty()) {
            throw IllegalArgumentException("자동차 이름을 입력해주세요.")
        } else if (carString.contains(",,") || carString.startsWith(',') || carString.endsWith(',')) {
            throw IllegalArgumentException("올바른 자동차 이름을 입력해 주세요.")
        }
        val cars = carString.split(',')
        for (car in cars) {
            if (car.trim().isEmpty() || car.contains(" ")) {
                throw IllegalArgumentException("잘못된 입력 형식 입니다.")
            } else if (car.length > 5) {
                throw IllegalArgumentException("자동차 이름의 길이는 1에서 5사이여야 합니다.")
            } else {
                garage[car] = 0
            }
        }
    }
}