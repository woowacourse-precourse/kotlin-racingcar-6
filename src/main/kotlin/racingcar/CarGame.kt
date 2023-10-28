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

fun moveCar() {
    TODO("주사위의 결과에 따라 차를 이동")
}

fun printMoveStatus() {
    TODO("각 시도 당 실행결과 출력")
}
