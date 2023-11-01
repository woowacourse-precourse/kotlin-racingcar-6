package test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.EXCEPTION_MESSAGE_BLANK_NAME
import racingcar.EXCEPTION_MESSAGE_UNVALID_NAME_LENGTH
import racingcar.model.Name


class NameTest {
    @Test
    fun `이름 길이 유효성 체크 테스트`() {
        val exception = assertThrows<IllegalArgumentException> {
            val name = Name("aaaaaaa")

            name.checkValidateName()
        }
        assertEquals(EXCEPTION_MESSAGE_UNVALID_NAME_LENGTH, exception.message)
    }

    @Test
    fun `이름 공백 체크 테스트`() {
        val exception = assertThrows<IllegalArgumentException> {
            val name = Name("")

            name.checkValidateName()
        }
        assertEquals(EXCEPTION_MESSAGE_BLANK_NAME, exception.message)
    }

    @Test
    fun `getNameString 체크 테스트`() {
        val name = Name("hello")
        val result = name.getNameString()
        assertThat(result).contains("hello")
    }
}