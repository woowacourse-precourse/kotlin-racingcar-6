package racingcar.attemptcomparator

class AttemptComparatorImpl : AttemptComparator {

    override fun compareAttemptAndCarPosition(attempts: Int, carPosition: String): Boolean {
        return attempts == carPosition.length
    }
}
