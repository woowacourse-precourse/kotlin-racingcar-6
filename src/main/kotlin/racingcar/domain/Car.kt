package racingcar.domain

class Car(private val name: String) {
    init {
        require(name.trim().isNotEmpty()) { "자동차 이름은 비어 있을 수 없습니다." }
        require(name.length <= 5) { "자동차 이름은 5자 이하만 가능합니다." }
    }

    fun getName(): String {
        return name
    }

    private var position = 0

    fun move(randomValue: Int) {
        if (randomValue >= 4) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }
}
