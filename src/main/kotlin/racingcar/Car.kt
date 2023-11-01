package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name:String) {
    var progress: Int = 0

    init {
        validateName(name)
    }

    private fun validateName(name: String) {
        if(name.length > 5) {
            throw IllegalArgumentException("잘못된 이름을 입력하였습니다.")
        }
        if(name.contains(" ")) {
            throw IllegalArgumentException("잘못된 이름을 입력하였습니다.")
        }
    }

    fun move() {
        val threshold = Randoms.pickNumberInRange(0, 9)
        if(threshold > 3) {
            progress++
        }
        getResult()
    }

    private fun getResult() {
        print("${name} : ")
        for(i in 0 until progress) {
            print("-")
        }
        println()
    }
}