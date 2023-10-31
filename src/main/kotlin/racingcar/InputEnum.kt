package racingcar

enum class InputEnum(val exceptionChecker: ExceptionCheckerInterface) {
    CAR_NAME(CarNameExceptionChecker()), LOOP_COUNT(LoopCountExceptionChecker())
}