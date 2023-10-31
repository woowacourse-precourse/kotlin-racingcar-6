package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Game {

    private val cars = mutableListOf<Car>()
    private val error = Error()
    companion object {
        const val INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val INPUT_REPEAT = "시도할 횟수는 몇 회인가요?"
        const val MOVE = "-"
    }

    fun gameStart() {
        println(INPUT_NAME)
        input()
        processGame(inputRepeat())
        winner()
    }

    private fun input(){
        val carname = Console.readLine()
        val names = carname.split(',')
        error.checkName(names)
        for (name in names) {
            cars.add(Car(name))
        }
    }
    private fun inputRepeat(): Int {
        println(INPUT_REPEAT)
        val repeat = Console.readLine()
        error.checkNum(repeat)
        Console.close()
        return repeat.toInt()
    }

    private fun processGame(repeat: Int) {
        println()
        println("실행 결과")
        for(i in 0 until repeat){
            for(car in cars){
                step(Randoms.pickNumberInRange(0, 9),car)
            }
            println()
        }
    }
    private fun step(random: Int, car: Car) {
        if(random >= 4){
            car.plus()
        }
        println("${car.name} : ${MOVE.repeat(car.position)}")
    }
    private fun findMaxPos() : Int{
        var max = 0
        for (car in cars) {
            if (car.position >= max) {
                max = car.position
            }
        }
        return max
    }

    private fun winner() {
        val winners = mutableListOf<String>()
        val maxPos = findMaxPos()
        for (car in cars) {
            if (car.position == maxPos) {
                winners.add(car.name)
            }
        }
        printWinner(winners)
    }
    private fun printWinner(winners: MutableList<String>) {
        print("최종 우승자 : ${winners.joinToString(", ")}")
    }
}