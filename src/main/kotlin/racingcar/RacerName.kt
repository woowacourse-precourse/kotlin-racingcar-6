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
            if (RACER_NAME_LENGTH_MAXIMUM < name.length)
                throw IllegalArgumentException(Message.RacerNameLengthError.messageText)
        }
        return true
    }

    private fun checkRacerNameBlank(getVerifyRacerNames: MutableList<String>): Boolean {
        for (name in getVerifyRacerNames) {
            if (name.isBlank())
                throw IllegalArgumentException(Message.RacerNameBlankError.messageText)
        }
        return true
    }

    private fun checkRacerTotalRange(getVerifyRacerNames: MutableList<String>): Boolean {
        if (getVerifyRacerNames.size !in RACER_MINIMUM..RACER_MAXIMUM)
            throw IllegalArgumentException(Message.RacerNameRangeError.messageText)
        return true
    }
}