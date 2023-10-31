package racingcar
import camp.nextstep.edu.missionutils.Randoms

class Result {
    fun makeCntArray() {

    }
    fun goOrStop(): Int {
        var cnt = 0
        if (Randoms.pickNumberInRange(0, 9) >= 4)
            cnt++
        return cnt
    }
    fun printResult(input: Int, list: List<String>?) {
        println("실행결과")

        for (i in 0 until input) {
            for (j in 0 until list!!.size-1) {
                println("${list[j]} : 1")
            }
            println()
        }
    }
}