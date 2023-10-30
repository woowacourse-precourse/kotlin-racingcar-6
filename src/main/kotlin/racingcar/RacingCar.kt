package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingCar(_name: String) {
    var name: String = _name
    private var randomNum = 10
    private var moveCnt = 0

    fun getRandomNum() {
        this.randomNum = Randoms.pickNumberInRange(1, 9)
    }

    private fun isMove(): Boolean{
        return this.randomNum>=4
    }

    fun updateMoveCnt() {
        if (isMove()){
            moveCnt += 1
        }
    }

    fun printResult() {
        println("${this.name} : "+"-".repeat(moveCnt))
    }
}