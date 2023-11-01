package racingcar.io

import racingcar.io.checker.CarNameExceptionChecker
import racingcar.io.checker.ExceptionCheckerInterface
import racingcar.io.checker.LoopCountExceptionChecker

enum class InputEnum(val exceptionChecker: ExceptionCheckerInterface) {
    CAR_NAME(CarNameExceptionChecker()), LOOP_COUNT(LoopCountExceptionChecker())
}