import java.math.BigInteger

object Racing {

    private var winnerLength = BigInteger.ZERO

    fun racingSetting(carList: List<Car>, round: BigInteger) {
        var count = BigInteger.ZERO
        println("실행 결과")
        while (count < round) {
            racingStart(carList)
            count++
        }
        racingResult(carList)
    }

    private fun racingStart(carList: List<Car>) {
        for (car in carList) {
            if (car.isGo()) {
                updateWinnerLength(car.lengthPlus())
            }
            car.printCarInfo()
        }
        println()
    }

    private fun updateWinnerLength(length: BigInteger) {
        val compareResult = length.compareTo(winnerLength)
        if (compareResult > 0) {
            winnerLength = length
        }
    }

    private fun racingResult(carList: List<Car>) {
        val winnerList = mutableListOf<String>()
        carList.forEach {
            if (it.lengthPlus() == ++winnerLength) {
                winnerList.add(it.getCarName())
            }
        }
        printResult(winnerList)
    }

    private fun printResult(result: List<String>) {
        print("최종 우승자 : ")
        result.forEachIndexed { index, s ->
            print(s)
            if (index != result.lastIndex) print(", ")
        }
    }
}
