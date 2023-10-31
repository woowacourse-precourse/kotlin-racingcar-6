package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun main(arge: Array<String>) {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val car = Console.readLine()!!.split(",")
    val cars = car.map { Car(it) }

    println("시도할 횟수는 몇 회인가요?")
    val rounds = Console.readLine()!!.toInt()

    val race = Race(cars, rounds)
    race.run()

    val winners = race.winners()
    println("최종 우승자 : ${winners.joinToString { it.name }}")
}


    class Car(val name: String, var position: Int = 0) {
        init {
            checkName(name)
        }

        private fun checkName(name: String) {
            if (name.length > 5 || name.contains(",") || name.isBlank()) {
                throw IllegalArgumentException()
            }
        }

        fun move(raceNums: Int) {
            if (raceNums >= 4) {
                position++
            }
        }

        override fun toString(): String {
            return "$name : ${"-".repeat(position)}"
        }
    }

    class Race(val cars: List<Car>, val rounds: Int) {
        fun run() {
            for (track in 0 until rounds) {
                cars.forEach {
                    it.move(Randoms.pickNumberInRange(0, 9))
                    result()
                }
            }
        }

        private fun result() {
            cars.forEach { println(it) }
            println()
        }

        fun winners(): List<Car> {
            val maxPosition = cars.maxOf { it.position }
            return cars.filter { it.position == maxPosition }
        }
    }