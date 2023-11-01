package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Test

class InputTest {
    @Test
    fun car입력값5자이하() {
        val exception = Exception()
        val result = "hyunjin"
        assertThrows<IllegalArgumentException>{
            exception.nameLengthException(result)
        }
    }

    @Test
    fun 쉼표로구분() {
        val input = "bae.hyun/jin%bae*hyun^jin"
        val result = input.split(",")
        assertThat(result).contains("bae.hyun/jin%bae*hyun^jin")
    }
}