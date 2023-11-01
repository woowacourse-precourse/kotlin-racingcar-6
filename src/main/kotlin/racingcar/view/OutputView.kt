package racingcar.view

import racingcar.model.Cars

class OutputView {
    fun showStartGuide() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun showTryCountGuide() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun showResultGuide() {
        println("실행 결과")
    }

    fun showRace(cars: Cars) {
        cars.cars.forEach {
            println(it.name + " : " + "-".repeat(it.position))
        }
        println()
    }

    fun showResult(cars: List<String>) {
        print("최종 우승자 : ${cars.joinToString(", ")}")
    }

}