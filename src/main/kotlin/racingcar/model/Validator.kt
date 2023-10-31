package racingcar.model

internal inline fun <T> T.alsoCatching(block: T.() -> Unit): Result<T> =
    runCatching {
        block.invoke(this)
        this
    }

internal fun List<String>.validateNoDuplicates(): Result<List<String>> =
    alsoCatching {
        require(this.hasNoDuplicated()) { Error.DuplicatedCarName }
    }

internal fun String.validateCarName(): Result<String> =
    alsoCatching {
        require(this.isNotBlank() && this.length <= 5) { Error.InvalidCarName }
    }

internal fun String.validateNumber(containsDigit: Boolean = true): Result<String> =
    alsoCatching {
        require(this.isInt(containsDigit)) { Error.NotNumber }
    }

internal enum class Error(private val message: String) {
    InvalidCarName("이름이 올바르지 않습니다. 이름은 5자 이하로 입력해주세요."),
    DuplicatedCarName("이미 등록된 자동차예요. 다른 이름으로 입력해주세요."),
    NotNumber("문자는 입력할 수 없습니다.");

    override fun toString() = message
}

fun String.isInt(containsDigit: Boolean): Boolean {
    if (isBlank()) return false
    if (this[0] in listOf('-', '+') && !containsDigit) return false
    return toIntOrNull() != null
}

fun <T> List<T>.hasNoDuplicated(): Boolean = this.toSet().size == this.size