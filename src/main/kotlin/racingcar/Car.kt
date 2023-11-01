package racingcar

class Car (private val name: String, private var position: Int){
    init {
        checkingValidName()
    }

    private fun checkingValidName() {
        if (name.length > NAME_MAXIMUM_LENGTH) {
            throw IllegalArgumentException(GameMessage.InvalidName)
        }
    }

    fun move() {
        position += STEP
    }

    fun getName(): String {
        return name
    }

    fun getPosition(): Int {
        return position
    }

    companion object {
        const val STEP = 1
        const val NAME_MAXIMUM_LENGTH = 5
    }
}