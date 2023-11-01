package racingcar

import racingcar.Result

fun main() {
    // TODO: 프로그램 구현
    val car: Car = Car()
    val racing = Racing()
    val result = Result()
    val carNames = car.createCar()

    car.validateCarNameLength(carNames)
    car.validateDuplicateName(carNames)
    car.validateBlankName(carNames)
    var carProgressList = car.createCarProgressList(carNames)

    val moveCount = racing.enterMoveCount()

    println("실행 결과")
    for (i in 0..<moveCount) {
        carProgressList = racing.determineProgress(carProgressList)
        result.printProgress(carNames,carProgressList)
    }

    val winnerList=result.printWinner(carNames,carProgressList)
    print("최종 우승자 : "+winnerList)
}
