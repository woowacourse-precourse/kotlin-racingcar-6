package racingcar

import camp.nextstep.edu.missionutils.Randoms

class MoveCars(private val carList: List<String>, private val tryNumber: Int) {

    private val number = MutableList(carList.size) { 0 }
    fun randomNumber() {
        for (i in carList.indices) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                number[i]++
            }
            println("${carList[i]} : "+"-".repeat(number[i]))
        }
        println()
    }




}