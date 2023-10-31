package racingcar

fun main() {

    val machine = InputMachine()
    val racing = Racing()
    val referee = Referee()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carsList: List<String> = machine.makeCars()
    if (!machine.checkCarNameUnder5(carsList)) {
        throw IllegalArgumentException("자동차 이름이 5자를 초과합니다.")
    }
    val carsClass: MutableList<Car> = mutableListOf()

    // car 선언
    for (car in carsList) {
        carsClass.add(Car(car))
    }

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = machine.tryMove()
    if (tryCount == -1) {
        throw IllegalArgumentException("숫자를 입력하세요")
    } else if (tryCount == -2) {
        throw IllegalArgumentException("양의 정수를 입력하세요")
    }

    println("실행 결과")
    racing.playRacing(tryCount, carsClass)

    val winCarsList: List<String> = referee.notifyWhoWin(carsClass)
    println("최종 우승자 : ${winCarsList.joinToString(",")}")


}
