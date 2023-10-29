package racingcar

class RacerName(private val racerCrew: String = "") {
    fun verifyRacerName(): MutableList<String> {
        val getVerifyRacerNames: MutableList<String> = blendRacerName()
        exceptionRacerName(getVerifyRacerNames)
        return getVerifyRacerNames
    }

    private fun blendRacerName(): MutableList<String>{
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
            if (name.length > 5) throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 있습니다.")
        }
        return true
    }

    private fun checkRacerNameBlank(getVerifyRacerNames: MutableList<String>): Boolean {
        for (name in getVerifyRacerNames) {
            if (name.isBlank()) throw IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.")
        }
        return true
    }

    private fun checkRacerTotalRange(getVerifyRacerNames: MutableList<String>): Boolean {
        if(getVerifyRacerNames.size !in 1..10) throw IllegalArgumentException("자동차 이름은 1개부터 10개까지 입력할 수 있습니다.")
        return true
    }
}