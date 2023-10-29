package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Racing(private val cars: List<Car>) {

    //true 면 move, false면 stop
    private fun determineMoveOrStop(randomNumber: Int) = randomNumber >= BASE_NUMBER
    private fun makeRandomNumber() = Randoms.pickNumberInRange(0, 9)
    fun getRacingDistances(numberAttempts: Int) {
        repeat(numberAttempts) {
            for (j in cars.indices) {
                val randomNumber = makeRandomNumber()
                if (determineMoveOrStop(randomNumber)) cars[j].distance++
            }
            printMatchProgress()
        }
    }

    private fun printMatchProgress() {
        cars.forEach { car -> println("${car.name} : ${"-".repeat(car.distance)}") }
        println()
    }

}