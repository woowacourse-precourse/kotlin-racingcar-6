package racingcar

class Result {
    fun printResult(go: Int) {
        for (i in 0 until go)
            print("-")
        println()
    }

    fun printWinner(carList: Array<Cars?>) {
        var max = 0
        var idx = 0
        var cnt = 0

        for (i in carList.indices) {
            if (carList[i]!!.go > max)
                max = carList[i]!!.go
        }
        for (i in carList.indices) {
            if (carList[i]!!.go == max) {
                cnt++
                print(carList[i]!!.name)
                if (cnt <= 1 && i != carList.size - 1)
                    print(", ")
            }
        }
    }
}