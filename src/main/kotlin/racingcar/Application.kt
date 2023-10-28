package racingcar
import camp.nextstep.edu.missionutils.Console

fun main() {
    // 시도 입력을 받을 String형 trialInput
    val trialInput = Console.readLine()

    // 시도를 받을 정수형 trial
    val trial: Int

    // 정수형이 안되면 오류 반환
    if (trialInput.toIntOrNull() == null)
        throw IllegalArgumentException()

    // 정수형이 된다면 Int로 변환
    else
        trial = trialInput.toInt()

    // 이동 횟수가 1 이상의 정수가 아니라면 오류 반환
    if (trial < 0)
        throw  IllegalArgumentException()

    // 자동차의 이름을 String으로 받는 carsNameInput
    val carsNameInput = Console.readLine()
}
