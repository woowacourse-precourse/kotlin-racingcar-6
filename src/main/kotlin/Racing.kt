import java.math.BigInteger

object Racing {

    private var maxLength = 0

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
                maxLength = Math.max(car.lengthPlus(), maxLength)
            }
            car.printCarInfo()
        }
        println()
    }

    private fun racingResult(carList: List<Car>) {
        val winnerList = mutableListOf<String>()
        carList.forEach {
            if (it.lengthPlus() == maxLength + 1) {
                winnerList.add(it.getName())
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
