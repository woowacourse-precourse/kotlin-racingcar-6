package racingcar.model


sealed class CircuitState {
    object Start : CircuitState()
    object Racing :CircuitState()
    object End : CircuitState()
    object Exit : CircuitState()
}