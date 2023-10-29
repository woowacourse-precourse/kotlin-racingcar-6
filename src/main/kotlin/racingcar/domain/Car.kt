package racingcar.domain

class Car(
    attemptCount: Int,
    private val carNames: List<String>,
    private val carRace: CarRace = CarRace(attemptCount)
) {
    fun race() {
        carRace.executeRace(carNames)
    }
}