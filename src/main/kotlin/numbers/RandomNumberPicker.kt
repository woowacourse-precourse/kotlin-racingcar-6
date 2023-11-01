package numbers

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberPicker(
    private val startInclusive: Int = 1,
    private val endInclusive: Int = 9,
) : NumberPicker {
    override fun pick() = Randoms.pickNumberInRange(startInclusive, endInclusive)
}