package racingcar.domain

import java.text.BreakIterator

class Validator {

    private val carNameRange = (ALLOWED_MIN_SIZE..ALLOWED_MAX_SIZE)
    private val breakIterator = BreakIterator.getCharacterInstance()

    fun checkCarNameValid(input: String): Boolean = countLengthOfLetter(input) in carNameRange

    private fun countLengthOfLetter(input: String): Int {
        breakIterator.setText(input)

        var count = 0
        while (breakIterator.next() != BreakIterator.DONE) {
            count++
        }
        return count
    }

    companion object {
        private const val ALLOWED_MIN_SIZE = 1
        private const val ALLOWED_MAX_SIZE = 5
    }
}