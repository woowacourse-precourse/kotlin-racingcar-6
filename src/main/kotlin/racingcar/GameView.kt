package racingcar
import camp.nextstep.edu.missionutils.Console
import racingcar.model.CarModel

class GameView(private val validate: InputValidate) {
    companion object {
        const val INPUT_CAR_NAME_MESSAGE = "경주할 자동차의 이름들을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val INPUT_ATTEMPT_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?"
    }
    fun getCarNames(): List<String> {
        println(INPUT_CAR_NAME_MESSAGE)
        val cars = Console.readLine().split(",")
        validate.validateCarNames(cars)
        return cars
    }

    fun getAttempts(): Int {
        println(INPUT_ATTEMPT_NUMBER_MESSAGE)
        val attempts = Console.readLine()
        return validate.validateAttempts(attempts)
    }
    fun raceStatus(cars: List<CarModel>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printWinner(winners: List<CarModel>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("최종 우승자 : $winnerNames")
    }
}