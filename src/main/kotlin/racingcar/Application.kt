package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.Controller
import racingcar.domain.NumberGenerator
import racingcar.domain.User
import racingcar.domain.car.Cars

val user = User()
val controller = Controller()
var cars = Cars()
val numberGenerator = NumberGenerator()

fun main() {
    cars = user.askCarName(Console.readLine(), cars)
    val count = user.askNumber(Console.readLine())
    for (i in 1..count) {
        cars.getCars().all {
            controller.playRound(it,numberGenerator.createRandomNumber())
            cars.compareHighScore(it.getDistance())
            true
        }
    }
    println(controller.printWinner(cars))
}