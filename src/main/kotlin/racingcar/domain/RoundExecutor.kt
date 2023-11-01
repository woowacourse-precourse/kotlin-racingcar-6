package racingcar.domain

import racingcar.view.RaceView

class RoundExecutor() {
    fun executeRounds(carNames: ArrayList<String>, carStatus: MutableMap<String, String>, attemptCount: Int) {
        val numberGenerator = NumberGenerator()
        val carStatusUpdater = CarStatusUpdater()
        val raceView = RaceView()

        carStatus.clear()
        carStatus.putAll(carNames.associateWith { "" })

        var currentCount = 0
        var randomNumber: Int
        while (currentCount < attemptCount) {
            for (car in carStatus) {
                randomNumber = numberGenerator.createRandomNumber()
                carStatusUpdater.moveCarForward(carStatus, car.key, randomNumber)
            }
            raceView.printCarProgress(carStatus)
            currentCount++
        }
    }
}
