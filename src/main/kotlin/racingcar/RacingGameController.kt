package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingGameController {
    private val view = ConsoleView()

    fun startGame() {
        val cars = getCars()
        val tryNum = getTryNum()
        runRace(tryNum, cars)
    }

    private fun getCars(): List<Car> {
        val carNames = view.promptUser("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
            .split(',')
        carNamesValidator(carNames)
        return createCars(carNames)
    }

    private fun getTryNum(): Int {
        val tryNum = view.promptUser("시도할 횟수는 몇 회인가요?").toInt()
        tryNumValidator(tryNum)
        return tryNum
    }

    private fun runRace(tryNum: Int, cars: List<Car>) {
        for (i in 1..tryNum) {
            tryOne(cars)
            view.displayCarProgress(cars)
        }

        val winners = getCarWithMaxDistance(cars)
        view.displayFinalWinner(winners)
    }

    private fun createCars(carNames: List<String>): List<Car> {
        val cars = mutableListOf<Car>()
        for (name in carNames) {
            val car = Car(name)
            cars.add(car)
        }
        return cars
    }

    private fun tryOne(cars: List<Car>) { // 하나의 라운드만 돌기
        for (car in cars) {
            val randomNum = generateNum()
            if (randomNum >= 4) car.moveForward()
        }
    }

    private fun generateNum(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    private fun carNamesValidator(carNames: List<String>) {
        for (car in carNames) {
            if (car.length > 5 || car.isEmpty()) throw IllegalArgumentException("이름은 5자 이하만 가능합니다")
        }
    }

    private fun tryNumValidator(tryNum: Int) {
        if (tryNum <= 0) throw IllegalArgumentException("시도 횟수는 자연수만 가능합니다")
    }

    private fun getCarWithMaxDistance(cars: List<Car>): List<Car> {
        val maxDistance = cars.maxOf { it.distance }
        return cars.filter { it.distance == maxDistance }
    }
}
