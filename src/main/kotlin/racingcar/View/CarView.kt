package racingcar.View

class CarView {
    fun printCarNamesMessage() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }
    fun printTryCountMessage() {
        println("시도할 횟수는 몇 회인가요?")
    }
    fun printMoveCar(carName: String, distance: Int) {
        println("$carName : ${"-".repeat(distance)}")
    }

    fun printWinnersMessage(winners: String) {
        println("\n최종 우승자 : $winners")
    }
}