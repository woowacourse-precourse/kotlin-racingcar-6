package service

object ExceptionHandler {
    fun checkNames(names: String) {
        try {
            for (i in names) {
                require(i in 'A'..'Z' || i in 'a'..'z' || i == ',') {
                    Message.ERROR.toString()
                }
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    fun checkNameLength(name: String) {
        try {
            require(name.length <= 5) {
                Message.ERROR.toString()
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}