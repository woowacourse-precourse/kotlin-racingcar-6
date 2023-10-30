package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    setUpAndStartRace()
}

fun setUpAndStartRace(){
    val raceManager = RaceManager()

    val carNames = getUserInputCarNames()
    carNames.forEach { carName ->
        raceManager.addCarToRace(Car(carName))
    }

    val movementAttemptInput = getUserInputMovementAttempt()
    raceManager.setMovementAttemptCount(movementAttemptInput)

    raceManager.startRace()
}

fun getUserInputCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carsInput = Console.readLine()
    return carsInput.split(",")
}

fun getUserInputMovementAttempt(): String {
    println("시도할 횟수는 몇 회인가요?")
    val movementAttemptInput = Console.readLine()
    return movementAttemptInput
}