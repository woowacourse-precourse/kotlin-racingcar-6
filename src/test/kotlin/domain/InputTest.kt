package domain

import domain.Constant.WRONG_NAME_LENGTH_EXCEPTION
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InputTest {
    @Test
    fun car입력값5자이하() {
        val input = "baehyun,jin"
        val result = input.split(",")
        for (index in result.indices) {
        }
    }

    @Test
    fun 쉼표로구분() {
        val input = "bae.hyun/jin%bae*hyun^jin"
        val result = input.split(",")
        assertThat(result).contains("bae.hyun/jin%bae*hyun^jin")
    }
}