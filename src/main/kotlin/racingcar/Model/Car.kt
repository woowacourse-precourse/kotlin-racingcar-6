import camp.nextstep.edu.missionutils.Randoms
import racingcar.View.RacingGameView.printCount
import racingcar.View.RacingGameView.printPlayResultText

class RacingGameModel {
    // Car 객체들을 가지고 있는 리스트
    val cars: MutableList<Car> = mutableListOf()
    var playTime: Int = 0

    // RacingGameModel에 Car 객체 추가
    fun addCar(car: Car) {
        cars.add(car)
    }

    fun playGame() {
        printPlayResultText()
        repeat(playTime) {
            cars.forEach { it.moveOrStop() }
            printCount(cars)
        }
    }

    // 가장 큰 count를 가진 Car 객체들의 이름을 반환
    fun findWinnerByCount(): List<String> {
        val maxCount = cars.maxByOrNull { it.count }?.count
        val winners = cars.filter { it.count == maxCount }
        return winners.map { it.name }
    }
}

data class Car(val name: String, var count: Int = 0) {
    fun moveOrStop() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            count++
        }
    }
}

