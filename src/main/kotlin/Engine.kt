import CarConfiguration.MIN_START_FLAG

class Engine {
    fun start(forwardFlag: Int) : Boolean {
        return forwardFlag >= MIN_START_FLAG
    }
}