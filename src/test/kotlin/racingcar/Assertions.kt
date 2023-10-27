package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows

/**
 * [executable]을 실행 후 발생한 Exception의 타입을 비교하고,
 * Exception의 메세지와 전달받은 [errorMessage]와 동일한 지 확인함
 * */
internal inline fun <reified T : Throwable> assertEqualsThrowsMessage(
    errorMessage: String,
    executable: () -> Unit
): T = assertThrows<T>(executable).also { throwable ->
    assertEquals(throwable.message, errorMessage)
}

internal inline fun <reified T : Throwable> assertEqualsThrowsMessage(
    errorType: Enum<*>,
    executable: () -> Unit
): T = assertEqualsThrowsMessage(errorType.toString(), executable)