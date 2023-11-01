package racingcar

import org.junit.jupiter.api.Test

class OutputManagerTest {
    @Test
    fun `정상 리스트일때 printWinner 테스트` (){
        val list = listOf("a","b","c").map {Car(it)}
        OutputManager.printWinners(list)
    }
}