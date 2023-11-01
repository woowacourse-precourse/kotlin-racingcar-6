package racingcar
import camp.nextstep.edu.missionutils.Randoms

fun repeatMove(trial: Int, carsList: List<String>) {
    // 자동차의 위치를 나타낼 바뀔수 있는 List인 carsLocation 생성
    var carsLocation = MutableList(carsList.size) {0}

    // trial만큼 자동차 이동 반복
    repeat(trial) {
        carsLocation = moveCar(carsList, carsLocation)
    }
    showWinners(carsList, carsLocation)
}

fun checkAdvance(): Boolean {
    // 0에서 9까지의 정수 중 무작위 값 추출
    val randomNumber = Randoms.pickNumberInRange(0,9)

    // 무작위 값이 4이상 일 경우 true 반환
    if (randomNumber >= 4)
        return true

    // 무작위 값이 4보다 작을 경우 false 반환
    else
        return false
}

fun moveCar(carsList: List<String>, carsLocation: MutableList<Int>): MutableList<Int> {
    // 전체 carsLocation을 살펴보고
    repeat(carsLocation.size) {
        // checkAdvance를 통과하면 한 칸 전진
        if (checkAdvance() == true)
            carsLocation[it] += 1
    }

    // 현재 위치 표시
    printMoveStatus(carsList, carsLocation)

    return carsLocation
}

fun printMoveStatus(carsList: List<String>, carsLocation: List<Int>) {
    // 모든 차를 출력
    repeat(carsList.size) {
        // '차 이름 : '
        print(carsList[it] + " : ")
        repeat(carsLocation[it]) {
            print("-")  // 이동 거리 출력
        }
        println()   // 줄바꿈
    }
}
