package racingcar

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UnitTest {
    var racing=Racing()
    var carCollection = CarCollection()

    @Test
    fun `경주할 n대의 자동차의 이름을 입력 받음`() {
        val registerCarNames="pobi,woni"
        val registerCarNamesList=registerCarNames.split(",")
        for (name in registerCarNamesList){
            val carName=CarName(name)
            val car = Car(carName)
            carCollection.putCar(car)
        }
        val result= mutableListOf<String>()
        for(car in carCollection.carList){
            result.add(car.name.amount())
        }
        Assertions.assertThat(result).contains("pobi","woni")
    }
    @Test
    fun `이름이 6글자 이상인 경우`() {
        val registerCarNames="pobiro"
        val registerCarNamesList=registerCarNames.split(",")
        for (name in registerCarNamesList){
            assertThrows<IllegalArgumentException> { CarName(name) }
        }
    }

    @Test
    fun `이동을 시도할 횟수를 입력 받음`(){
        val getRacingNum="5"
        val racingNum=RacingNum(getRacingNum.toInt())
        Assertions.assertThat(racingNum.amount()).isEqualTo(5)
    }

    @Test
    fun `0에서 9 사이에서 무작위 값을 구해서 해당 값이 4 이상인 경우 해당 자동차 전진`(){
        var location=0
        var randNum= 4
        if(randNum>=4){
            location++
        }else if(randNum<3){

        }
        Assertions.assertThat(location).isEqualTo(1)
    }

    @Test
    fun `4이상이 아닌 경우 이동 안함`(){
        var location=0
        var randNum= 3
        if(randNum>=4){
            location++
        }else if(randNum<3){

        }
        Assertions.assertThat(location).isEqualTo(0)
    }

    @Test
    fun `우승자가 한명일때 가장 멀리간 차 출력`(){
        val registerCarNames="pobi,woni,runi"
        val registerCarNamesList=registerCarNames.split(",")
        for (name in registerCarNamesList){
            val carName=CarName(name)
            val car = Car(carName)
            carCollection.putCar(car)
        }
        carCollection.carList[0].location=5
        carCollection.carList[1].location=7
        carCollection.carList[2].location=9
        val winner=carCollection.getWinner()
        val result= mutableListOf<String>()
        for(car in winner){
            result.add(car.name.amount())
        }
        Assertions.assertThat(result).contains("runi")
    }
    @Test
    fun `우승자가 여러명일때 가장 멀리간 차 출력`(){
        val registerCarNames="pobi,woni,runi"
        val registerCarNamesList=registerCarNames.split(",")
        for (name in registerCarNamesList){
            val carName=CarName(name)
            val car = Car(carName)
            carCollection.putCar(car)
        }
        carCollection.carList[0].location=5
        carCollection.carList[1].location=9
        carCollection.carList[2].location=9
        val winner=carCollection.getWinner()
        val result= mutableListOf<String>()
        for(car in winner){
            result.add(car.name.amount())
        }
        Assertions.assertThat(result).contains("woni","runi")
    }
}