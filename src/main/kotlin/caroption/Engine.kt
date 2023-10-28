package caroption

import CarConfiguration.START_FLAG

class Engine {
    fun start(forwardFlag: Int) : Boolean {
        return forwardFlag >= START_FLAG
    }
}