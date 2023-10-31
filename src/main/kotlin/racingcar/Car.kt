package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    private var position = 0


    fun move() {
        val random = Randoms.pickNumberInRange(0, 9)
        if (random >= 4) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }

    //한 차수 실행 결과 출력
    fun printStatus() {
        println("$name : ${"-".repeat(position)}")
    }
    fun getCarName(): String {
        return name
    }

}