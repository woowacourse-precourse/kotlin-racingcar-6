package racingcar
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {


    // TODO: feat: input
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val names = readLine().split(',')

    println("시도할 횟수는 몇 회인가요?")
    val chance = readLine().toInt()

    println("\n실행 결과")

    repeat(chance){

        // TODO : feat: race
        println("race function call")
        println()
    }


    // TODO : feat: output
    println("최종 우승자")



}
