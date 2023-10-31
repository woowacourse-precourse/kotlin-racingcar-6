package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Try {
    fun goOrStop(tryNumber: Int, carList: Array<Cars?>) {
        for (j in 0 until tryNumber) {
            for (i in carList.indices) {
                if (Randoms.pickNumberInRange(0, 9) >= 4)
                    (carList[i]!!.go)++
                print("${carList[i]!!.name} : ")
                val result = Result()
                result.printResult(carList[i]!!.go)
            }
            println()
        }
    }
}