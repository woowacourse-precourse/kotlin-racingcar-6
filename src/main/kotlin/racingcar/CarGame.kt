package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun repeatMove(trial: Int) {
    TODO("trial만큼 게임을 반복")
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

fun moveCar(trial: Int, carsList: List<String>) {
    // 자동차의 위치를 나타낼 바뀔수 있는 List인 carsLocation 생성
    val carsLocation: MutableList<Int> = mutableListOf(0 * carsList.size)

    // 전체 carsLocation을 살펴보고
    repeat(carsLocation.size) {
        // checkAdvance를 통과하면 한 칸 전진
        if (checkAdvance() == true)
            carsLocation[it] += 1
    }

    // 현재 위치 표시
    printMoveStatus(carsLocation)
}

fun printMoveStatus() {
    TODO("각 시도 당 실행결과 출력")
}
