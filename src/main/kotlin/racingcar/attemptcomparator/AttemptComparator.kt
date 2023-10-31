package racingcar.attemptcomparator

import racingcar.attempts.Attempts
import racingcar.car.Car

fun interface AttemptComparator {

    fun compareAttemptAndCarPosition(attempts: Attempts, car: Car): Boolean
}
