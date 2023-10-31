package caroption

import car.CarConfiguration.START_FLAG

class Engine {
    fun start(forwardFlag: Int) = forwardFlag >= START_FLAG
}
