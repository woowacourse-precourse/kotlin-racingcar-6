import MessageManager.RACING_FINAL_WINNER_MESSAGE
import MessageManager.RACING_RESULT_MESSAGE
import MessageManager.WINNER_SEPARATOR
import java.math.BigInteger

object Racing {

    private var winnerLength = BigInteger.ZERO

    fun racingSetting(carList: List<Car>, round: BigInteger) {
        var roundCount = BigInteger.ZERO
        println(RACING_RESULT_MESSAGE)
        while (roundCount < round) {
            racingStart(carList)
            roundCount++
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
        print(RACING_FINAL_WINNER_MESSAGE)
        result.forEachIndexed { index, s ->
            print(s)
            if (index != result.lastIndex) print(WINNER_SEPARATOR)
        }
    }
}
