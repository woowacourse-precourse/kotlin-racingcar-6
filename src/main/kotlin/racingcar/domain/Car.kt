package racingcar.domain

typealias CarName = String

data class Car(
    private val name: CarName,
) {
    // 자동차는 자기가 몇칸 이동했는지 알고 있을 필요가 없다.
    // 그저 이름을 부여받고, 앞으로 갈지 멈출지만 판단하면 된다.
    init {
        // 자동차 객체 유효성 검증 로직
        require(name.isNotBlank()) { "[ERROR] 이름이 비어있거나 공백이면 안돼용" }
        require(name.length <= 5) { "[ERROR] 차이름 다섯글자 넘어용" }
    }

    fun move(randomValue: Int): Boolean =
        when (randomValue) {
            in 4..9 -> forward()
            in 0..3 -> stop()
            else -> throw IllegalArgumentException("[ERROR] 랜덤값이 0~9범위를 벗어났다.")
        }

    private fun forward() = true

    private fun stop() = false
}
