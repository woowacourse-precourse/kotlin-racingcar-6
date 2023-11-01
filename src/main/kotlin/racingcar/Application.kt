package racingcar

fun main() {

    val machine = InputMachine()
    val racing = Racing()
    val referee = Referee()

    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    val carsList: List<String> = machine.makeCars()
    val carsClass: MutableList<Car> = mutableListOf()

    // car 선언
    for (car in carsList) {

        carsClass.add(Car(car))

    }

    println("시도할 횟수는 몇 회인가요?")
    val tryCount = machine.tryMove()

    println("실행 결과")
    racing.playRacing(tryCount, carsClass)

    println(referee.checkMaxForward(carsClass))

}