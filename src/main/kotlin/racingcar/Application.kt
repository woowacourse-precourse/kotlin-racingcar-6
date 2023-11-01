package racingcar
import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

fun inputException(inputs: List<String>): List<String> {

    val names = inputs.distinct().toMutableList()
    names.removeAll{it.trim().isEmpty()}

    if (names.size < 2)
        throw IllegalArgumentException()

    for (name in names){
        if (name.length > 5)
            throw IllegalArgumentException()
    }

    return names

}


fun carRace(score: MutableMap<String, String>){

    for ((key, _ ) in score) {
        if (Randoms.pickNumberInRange(0, 9) >= 4 ) {
            score[key] +="-"
        }

        println("$key : ${score[key]}")

    }
    println()

}

fun displayOutput(score: Map<String, String>) {
    val maxCount = score.values.map { it.length }.max()
    val winners = score.filterValues { it.length == maxCount }.keys

    println("최종 우승자 : ${winners.joinToString(separator = ", ")}")
}

fun main() {


    // TODO: feat: input
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val inputs = readLine().split(',')
    val names = inputException(inputs)

    println("시도할 횟수는 몇 회인가요?")
    val chance = readLine().toInt()
    val score = names.associate { it to "" }.toMutableMap()


    println("\n실행 결과")

    repeat(chance){

        // TODO : feat: race
        carRace(score)

    }

    // TODO : feat: output
    displayOutput(score)


}
