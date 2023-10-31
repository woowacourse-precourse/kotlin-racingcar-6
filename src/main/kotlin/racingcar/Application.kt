package racingcar

import racingcar.raceModel.Car
import racingcar.raceModel.Race

fun main() {
    val view = RaceView()

    val carNames = view.input("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)").split(",")
    val cars = carNames.map { Car(it) }

    val raceTime = view.input("시도할 횟수는 몇 회인가요?").toIntOrNull() ?: throw IllegalArgumentException()

    val race = Race(cars)
    val controller = RaceController(race, view)

    controller.startRace(raceTime)
}
