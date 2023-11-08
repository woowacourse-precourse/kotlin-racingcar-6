package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.util.Constants

class Racing(private val cars: List<Car>) {
    val winner: String
        get() = _winner

    private var _winner = ""


    private fun makeRandomNumber() = Randoms.pickNumberInRange(0, 9)

    private fun determineMoveOrStop(randomNumber: Int) = randomNumber >= Constants.BASE_NUMBER

    fun runRaceOnce() {
        cars.forEach { car ->
            val randomNumber = makeRandomNumber()
            if (determineMoveOrStop(randomNumber)) car.distance++
            println(car.distance)
        }
    }

    fun getWinner() {
        val maxDistance = cars.maxOfOrNull { it.distance }
        val winnerList = cars.filter { it.distance == maxDistance }
        _winner = winnerList.joinToString { it.name }
    }
}