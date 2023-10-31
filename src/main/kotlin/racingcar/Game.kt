package racingcar

import camp.nextstep.edu.missionutils.Console

class Game {
    private val error = Error()
    private var cars: ArrayList<Car> = ArrayList()

    companion object {
        private const val INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val INPUT_REPEAT = "시도할 횟수는 몇 회인가요?"
    }

    fun gameStart() {
        input()
        processGame(inputRepeat())
        winner()
    }

    private fun input() {
        println(INPUT_NAME)
        val carname = Console.readLine()
        val names = carname.split(',')
        error.checkName(names)
        for (name in names) {
            cars?.add(Car(name.trim()))
        }
    }

    private fun processGame(repeat: Int) {
        var rep = repeat
        println("\n실행 결과")
        while (rep > 0) {
            for (car in cars!!) {
                car.play()
            }
            println()
            rep--
        }
    }

    private fun inputRepeat(): Int {
        println(INPUT_REPEAT)
        val repeat = Console.readLine()
        error.checkNum(repeat)
        return repeat.toInt()
    }

    private fun winner() {
        val winners: MutableList<String> = ArrayList()
        val maxPosition = findMaxPos()
        for (car in cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName())
            }
        }
        print("최종 우승자 : " + winners.joinToString(", "))
    }

    private fun findMaxPos(): Int {
        var max = 0
        for (car in cars) {
            if (car.getPosition() > max) {
                max = car.getPosition()
            }
        }
        return max
    }

}
