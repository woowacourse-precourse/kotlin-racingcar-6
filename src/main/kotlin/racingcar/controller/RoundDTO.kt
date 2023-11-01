package racingcar.controller

class RoundDTO(val count: String) {

    init {
        require(count.toUIntOrNull() != null)
    }

    fun convertRoundCount() = count.toInt()

}