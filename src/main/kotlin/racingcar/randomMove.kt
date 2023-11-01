package racingcar
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import racingcar.inputNames
class randomMove {
fun raceCars(names: List<String>, numberOfAttempts: Int) {
    val carPositions = mutableMapOf<String, Int>()

    for (name in names) {
        carPositions[name] = 0
    }

    for (attempt in 1..numberOfAttempts) {
        println("시도 $attempt 결과:")
        for (name in names) {
            val randomValue = pickNumberInRange(0, 9)
            if (randomValue >= 4) {
            carPositions[name] = carPositions[name]!! + 1
            }
            val dashes = "-".repeat(carPositions[name]!!)
            println("$name: $dashes")
        }
        println()
        }
    }}
