package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Game {
    private val error = Error()
    private val cars = mutableListOf<Car>()
    private val winners = mutableListOf<String>()
    private var MAX = 0

    companion object {
        private const val INPUT_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val INPUT_REPEAT = "시도할 횟수는 몇 회인가요?"
    }

    fun gameStart() {
        println(INPUT_NAME)
        input()
        processGame(inputRepeat())
        for (car in cars){
            findMaxPos(car)
        }
        for (car in cars){
            winner(car)
        }
        printWinner(winners)
    }

    private fun input() {
        val carname = Console.readLine()
        val names = carname.split(',')
        for (name in names) {
            error.checkName(name)
            cars.add(Car(name))
        }
    }

    private fun processGame(repeat: Int) {
        println()
        println("실행 결과")
        for (i in 0 until repeat) {
            for (car in cars) {
                val random = Randoms.pickNumberInRange(0, 9)
                result(car,random)
            }
            println()
        }
    }
    private fun result(car: Car, random: Int){
        if (random>=4) {
            car.goPos()
        }
        var step = ""
        for(i in 0..<car.position){
            step+="-"
        }
        println("${car.name} : $step")
    }

    private fun inputRepeat(): Int {
        println(INPUT_REPEAT)
        val repeat = Console.readLine()
        error.checkNum(repeat)
        Console.close()
        return repeat.toInt()
    }

    private fun winner(car: Car) {
        if (car.position == MAX) {
            winners.add(car.name)
        }
    }

    private fun findMaxPos(car: Car): Int {
        if(car.position >= MAX){
            MAX = car.position
        }
        return MAX
    }
    private fun printWinner(winners: MutableList<String>) {
        print("최종 우승자 : ${winners.joinToString(", ")}")
    }

}
