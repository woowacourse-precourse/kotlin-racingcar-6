package test

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.command.CommandInvoker
import racingcar.command.DoRaceCommand
import racingcar.model.Car
import racingcar.model.Name
import racingcar.model.Position

class CommandTest {
    @Test
    fun `Command 일괄 실행 테스트`() {
        val commandInvoker = CommandInvoker()

        val car1 = Car(name = Name("hello"), position = Position())
        val car2 = Car(name = Name("hello"), position = Position())
        val car3 = Car(name = Name("hello"), position = Position())
        val car4 = Car(name = Name("hello"), position = Position())

        assertRandomNumberInRangeTest(
            {
                commandInvoker.addCommand(DoRaceCommand(car1))
                commandInvoker.addCommand(DoRaceCommand(car2))
                commandInvoker.addCommand(DoRaceCommand(car3))
                commandInvoker.addCommand(DoRaceCommand(car4))
                commandInvoker.executeCommands()


                assertThat(car1.getPositionNumber())
                    .isEqualTo(0)
                assertThat(car2.getPositionNumber())
                    .isEqualTo(1)
                assertThat(car3.getPositionNumber())
                    .isEqualTo(0)
                assertThat(car4.getPositionNumber())
                    .isEqualTo(1)
            }, 1, 5, 1, 5
        )
    }
}