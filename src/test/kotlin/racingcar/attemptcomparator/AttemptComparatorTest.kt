package racingcar.attemptcomparator

import org.junit.jupiter.api.BeforeEach

class AttemptComparatorTest {

    private lateinit var attemptComparator: AttemptComparator

    @BeforeEach
    fun setUp() {
        attemptComparator = AttemptComparatorImpl()
    }
}
