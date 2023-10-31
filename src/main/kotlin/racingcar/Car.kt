package racingcar

import camp.nextstep.edu.missionutils.Randoms

private const val MOVE = "-"
class Car(name: String) {
    private var name: String
    private var position = 0

    init {
        this.name = name
    }

    fun getName(): String {
        return this.name
    }

    fun play() {
        makeRandom()
        printResult()
    }

    fun getPosition(): Int {
        return this.position
    }

    private fun printResult() {
        print("$name : ")
        for (i in 0..<position) {
            print(MOVE)
        }
        println()
    }

    private fun makeRandom() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }
}