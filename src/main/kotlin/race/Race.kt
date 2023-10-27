package race

import camp.nextstep.edu.missionutils.Console
import kotlin.IllegalArgumentException

class Race {
    public val garage = mutableMapOf<String, Int>()

    companion object {
        fun run() {
            val race = Race()
            race.inputCar()
            val moveNum = race.inputMoveNum()
            race.carMove(moveNum)
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
    fun inputMoveNum() : Int {
        println("시도할 횟수는 몇 회인가요?")
        val moveNumber = Console.readLine()
        if (isInteger(moveNumber)) {
            return moveNumber.toInt()
        }
        else {
            throw IllegalArgumentException("정수를 입력하세요.")
        }
    }

    private fun isInteger(checkString:String) : Boolean {
        return try {
            checkString.toInt()
            true
        } catch (e:NumberFormatException) {
            println("정수를 입력하세요.")
            false
        }
    }

    fun carMove(moveNum:Int) {
        println("실행 결과")
        for (i in 0..<moveNum) {
            for ((car,moveCount) in garage.entries) {
                if (checkMove()) {
                    garage[car] = moveCount + 1
                    printMove(car,moveCount + 1)
                }
                else {
                    printMove(car,moveCount)
                }
            }
            println()
        }
    }

    fun checkMove() :Boolean {
        TODO()
    }

    fun printMove(car:String,count:Int) {
        TODO()
    }
}