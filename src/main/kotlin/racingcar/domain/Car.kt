package racingcar.domain

class Car(
    attemptCount: Int,
    carNames: List<String>,
    private val carRace: CarRace = CarRace(
        attemptNumber = attemptCount,
        carNames = carNames
    )
) {
    fun race() {
        carRace.executeRacingAllRound()
    }
}