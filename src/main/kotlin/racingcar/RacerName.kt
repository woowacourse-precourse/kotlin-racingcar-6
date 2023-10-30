package racingcar

class RacerName(private val racerCrew: String = "") {
    fun verifyRacerName(): MutableList<String> {
        val getVerifyRacerNames: MutableList<String> = blendRacerName()
        exceptionRacerName(getVerifyRacerNames)
        return getVerifyRacerNames
    }

    private fun blendRacerName(): MutableList<String> {
        val personalRacerName = racerCrew.split(",").map { it.trim() }
        return personalRacerName.toMutableList()
    }

    private fun exceptionRacerName(racerNames: MutableList<String>) {
        checkRacerNameLength(racerNames)
        checkRacerNameBlank(racerNames)
        checkRacerTotalRange(racerNames)
    }

    private fun checkRacerNameLength(getVerifyRacerNames: MutableList<String>): Boolean {
        for (name in getVerifyRacerNames) {
            compareNameLength(name)
        }
        return true
    }

    private fun checkRacerNameBlank(getVerifyRacerNames: MutableList<String>): Boolean {
        for (name in getVerifyRacerNames) {
            existNameBlank(name)
        }
        return true
    }

    private fun checkRacerTotalRange(getVerifyRacerNames: MutableList<String>): Boolean {
        if (getVerifyRacerNames.size !in RACER_MINIMUM..RACER_MAXIMUM)
            throw IllegalArgumentException(Message.RacerNameRangeError.messageText)
        return true
    }

    private fun compareNameLength(name: String){
        if (RACER_NAME_LENGTH_MAXIMUM < name.length)
            throw IllegalArgumentException(Message.RacerNameLengthError.messageText)
    }

    private fun existNameBlank(name: String) {
        if (name.isBlank())
            throw IllegalArgumentException(Message.RacerNameBlankError.messageText)
    }
}