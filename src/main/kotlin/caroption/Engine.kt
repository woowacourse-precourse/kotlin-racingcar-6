package caroption

import CarConfiguration.START_FLAG

class Engine {
    fun start(forwardFlag: Int) = forwardFlag >= START_FLAG
}