package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(name: String) {
    private var name: String = name
    private var position: Int = 0

    companion object {
        private const val MOVE = "-"
    }

    fun getName(): String {
        return name
    }

    fun play() {
        makeRandom()
        printResult()
    }

    fun getPosition(): Int {
        return position
    }

    private fun printResult() {
        var go = ""
        for(i in 0..<position){
            go+= MOVE
        }
        println("$name : $go")
    }

    private fun makeRandom() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }
}