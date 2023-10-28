package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car(name: String) {
    companion object {
        private const val NAME_ERROR_MESSAGE = "이름이 %d 이하가 아닙니다."
        private const val NAME_EMPTY_MESSAGE = "이름이 비어있습니다."
        private const val NAME_MAX_SIZE = 5
        private const val MOVABLE_LEVEL = 4
        private val RANDOM_RANGE = Pair(0, 9)
    }

    val name: String
    var pos: Int = 0

    init {
        validateName(name = name)
        this.name = name
    }

    private fun validateName(name: String) {
        require(name.length <= NAME_MAX_SIZE) { NAME_ERROR_MESSAGE.format(NAME_MAX_SIZE) }
        require(name.isNotEmpty()) { NAME_EMPTY_MESSAGE }
    }

    fun move() {
        if (isMove()) {
            this.pos += 1
        }
    }

    private fun isMove(): Boolean {
        val num = Randoms.pickNumberInRange(RANDOM_RANGE.first, RANDOM_RANGE.second)
        return num >= MOVABLE_LEVEL
    }

    override fun toString(): String {
        val stringPos = "-".repeat(this.pos)
        return "${this.name} : $stringPos"
    }
}