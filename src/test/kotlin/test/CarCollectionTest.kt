package test

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.command.CommandInvoker
import racingcar.command.DoRaceCommand
import racingcar.model.Car
import racingcar.model.CarCollection
import racingcar.model.Name
import racingcar.model.Position

class CarCollectionTest {
    @Test
    fun `생성자 테스트`() {
        val cars = CarCollection("hello,world,im,코드,에요")

        assertThat(cars[0]!!.getCarNameString()).isEqualTo("hello")
        assertThat(cars[1]!!.getCarNameString()).isEqualTo("world")
        assertThat(cars[2]!!.getCarNameString()).isEqualTo("im")
        assertThat(cars[3]!!.getCarNameString()).isEqualTo("코드")
        assertThat(cars[4]!!.getCarNameString()).isEqualTo("에요")
    }



        /*
    @Test
    fun `승자 찾기 테스트`() {
        val cars = CarCollection("hello,world,im,코드,에요")

        assertRandomNumberInRangeTest(
            {
                CommandInvoker.executeCommands()
                CommandInvoker.executeCommands()
                val winnerList = cars.getWinners()
                assertThat(winnerList[0].getPositionNumber()).isEqualTo(1)
                assertThat(winnerList[0].getCarNameString()).isEqualTo("hello")

                CommandInvoker.clearCommands()
            }, 1, 1, 1, 1, 5, 5, 1, 1, 1, 1,
        )
    }

         */
}