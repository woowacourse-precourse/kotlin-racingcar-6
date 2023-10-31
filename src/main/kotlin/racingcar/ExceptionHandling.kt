package racingcar

fun handleExceptions(carNames: List<String>, moveCountResult: Result<Int>) {
    if (carNames is IllegalArgumentException) {
        println("${(carNames as IllegalArgumentException).message} 애플리케이션을 종료합니다.")
        return
    }

    moveCountResult.onFailure { e ->
        println("오류: ${e.message}\n프로그램을 종료합니다.")
    }
}
