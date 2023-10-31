package racingcar.attemptcomparator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class AttemptComparatorTest {

    private lateinit var attemptComparator: AttemptComparator

    @BeforeEach
    fun setUp() {
        attemptComparator = AttemptComparatorImpl()
    }

    @ParameterizedTest
    @CsvSource("5,-----,true", "4,---,false", "2,--,true", "4,--,false")
    fun `시도횟수와 자동차 위치 비교해서 적절한 값 반환`(attempt: Int, position: String, output: Boolean) {
        val result = attemptComparator.compareAttemptAndCarPosition(attempt, position)

        assertThat(output).isEqualTo(result)
    }
}
