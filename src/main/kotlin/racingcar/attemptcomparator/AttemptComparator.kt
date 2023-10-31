package racingcar.attemptcomparator

fun interface AttemptComparator {

    fun compareAttemptAndCarPosition(attempts: Int, carPosition: String): Boolean
}
