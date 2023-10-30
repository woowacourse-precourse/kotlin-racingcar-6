package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.car.Cars
import racingcar.domain.Controller
import racingcar.domain.NumberGenerator
import racingcar.domain.User

val user = User()
val controller = Controller()
var cars = Cars()
val numberGenerator = NumberGenerator()
fun main() {
    cars = user.askCarName(Console.readLine(), cars)
    val count = user.askNumber(Console.readLine())
    for (i in 1..count) {
        cars = controller.playRound(cars,numberGenerator.createRandomNumber())
    }
    controller.printWinner(cars)
}