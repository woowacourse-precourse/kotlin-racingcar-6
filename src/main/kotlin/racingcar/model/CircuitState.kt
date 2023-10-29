package racingcar.model


sealed class CircuitState{
    data object Start : CircuitState()
    data object Racing : CircuitState()
    data object End : CircuitState()
}