package racingcar
import camp.nextstep.edu.missionutils.Randoms
class Racing {
    fun playRacing(tryCount: Int, cars: MutableList<Car>) {
        for (count in 1..tryCount) {
            forwardOver4(cars)
        }
    }

    private fun random09(): Int {

        return Randoms.pickNumberInRange(0, 9)

    }

    private fun forwardOver4(cars: MutableList<Car>) {

        for (car in cars) {
            val forward = random09()
            printHyphen(car.name, forward)
            if (forward >= 4) {
                car.distance += 1
            }
        }
        println()
    }
    private fun printHyphen(carName: String, forward: Int) {
        println("$carName : ${"-".repeat(forward)}")
    }
}