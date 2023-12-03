package racingcar.domain

typealias CarName = String

data class Car(
    val name: CarName,
) {
    init {
        require(name.isNotBlank()) { "[ERROR] 이름이 비어있거나 공백이면 안돼용" }
        require(name.length <= 5) { "[ERROR] 차이름 다섯글자 넘어용" }
    }

    fun move(randomValue: Int) =
        when (randomValue) {
            in 4..9 -> go()
            in 0..3 -> stop()
            else -> throw IllegalArgumentException("[ERROR] 랜덤 값이 유효하지 않습니다.")
        }

    private fun go() = true

    private fun stop() = false
}