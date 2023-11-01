package test

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.command.CommandInvoker
import racingcar.command.DoRaceCommand
import racingcar.model.Car
import racingcar.model.CarCollection
import racingcar.model.Name
import racingcar.model.Position

class CommandTest {
    @Test
    fun `Command 일괄 실행 테스트`() {

        val carCollection = CarCollection("hello,world,Im세상,에요")

        assertRandomNumberInRangeTest(
            {
                CommandInvoker.executeCommands()

                assertThat(carCollection[0]!!.getPositionNumber())
                    .isEqualTo(0)
                assertThat(carCollection[1]!!.getPositionNumber())
                    .isEqualTo(0)
                assertThat(carCollection[2]!!.getPositionNumber())
                    .isEqualTo(0)
                assertThat(carCollection[3]!!.getPositionNumber())
                    .isEqualTo(0)
            }, 1, 1, 1, 1
        )
        CommandInvoker.clearCommands()
    }
}