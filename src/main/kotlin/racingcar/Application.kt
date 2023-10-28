package racingcar

val carNames = mutableListOf<String>()

fun checkInputIsNull(input: String?){
    if (input.isNullOrEmpty()){
        throw IllegalArgumentException("입력값이 없거나 공백입니다.")
    }
}

fun main() {
    print("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)\n")
    val input = readLine()

    checkInputIsNull(input)

    input?.let { nonNullInput ->
        carNames.addAll(nonNullInput.split(",").map { it.trim() })
    }

    val invalidCarNames = carNames.filter { it.length > 5 }
    if (invalidCarNames.isNotEmpty()){
        throw IllegalArgumentException("자동차의 입력값의 길이는 5 이하로 입력해주세요.")
    }

    print("시도할 횟수는 몇 회인가요?\n")
    val playTime = readLine()

    checkInputIsNull(playTime)




}
