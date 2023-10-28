package racingcar.model

class RacingBoard(racerList: List<Car>) {

    companion object {
        private const val RACER_LIST_EMPTY_MESSAGE = "참가자가 한명도 없습니다."
    }

    private val racerList: List<Car>

    init {
        validateRacerList(racerList)
        this.racerList = racerList
    }

    private fun validateRacerList(racerList: List<Car>) {
        require(racerList.isNotEmpty()) { RACER_LIST_EMPTY_MESSAGE }
    }


    fun play() {
        racerList.forEach { car: Car -> car.move() }
    }

    fun getResult(): List<Car> {
        val maxPos = racerList.maxByOrNull { car: Car -> car.pos }?.pos
        return racerList.filter { it.pos == maxPos }
    }

    override fun toString(): String {
        return racerList.joinToString("\n")
    }
}