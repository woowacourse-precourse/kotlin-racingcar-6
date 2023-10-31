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

        for (i in carList.indices) {  // 최대 전진 횟수 세기
            if (carList[i]!!.go > max)
                max = carList[i]!!.go
        }
        for (i in carList.indices) {  // 동점자 세기
            if (carList[i]!!.go == max) 
                cnt++
        }

        var winnerArray = Array(cnt) { "" }  // 우승자 배열 생성
        for (i in carList.indices) {
            if (carList[i]!!.go == max)
                winnerArray[idx++] = carList[i]!!.name  // 우승자 배열에 추가
        }

        for (i in winnerArray.indices) {
            print(winnerArray[i])
            if (i != winnerArray.size - 1)
                print(", ")
        }
    }
}