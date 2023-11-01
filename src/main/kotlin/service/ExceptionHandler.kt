package service

object ExceptionHandler {
    fun checkNames(names: String) : Boolean {
        try {
            for (i in names) {
                require(i in 'A'..'Z'|| i in 'a'..'z' || i == ',') { Message.ERROR.toString() }
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return false
        }
        return true
    }

    fun checkNameLength(name: String) {
        try {
            require(name.length <= 5) { Message.ERROR.toString() }
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    fun checkValidCount(count: String): Boolean {
        try {
            requireNotNull(count.toIntOrNull()) { Message.ERROR.toString() }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return false
        }
        return true
    }
}