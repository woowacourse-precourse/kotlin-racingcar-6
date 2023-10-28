package racingcar
import camp.nextstep.edu.missionutils.Console

fun main() {
    // 자동차 이름 입력 메시지
    println("경주할 자동차 이름을 입력하세오.(이름은 쉼표(,) 기준으로 구분)")
    // 자동차의 이름을 String으로 받는 carsNameInput
    val carsNameInput = Console.readLine()
    // ,로 구분된 자동차 리스트를 carsList에 저장
    val carsList: MutableList<String> = presetCars(carsNameInput)

    // 시도 횟수 입력 메시지
    println("시도할 횟수는 몇 회인가요?")
    // 시도 입력을 받을 String형 trialInput
    val trialInput = Console.readLine()
    // 제대로 된 입력인지 체크하여 맞다면 trial에 저장
    val trial = checkValidInput(trialInput)
}
