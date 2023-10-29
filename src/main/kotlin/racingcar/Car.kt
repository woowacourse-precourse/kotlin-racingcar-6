package racingcar
import camp.nextstep.edu.missionutils.Randoms
class Car(name:CarName) {
    var name : CarName
    var location: Int
    init {
        this.name=name
        this.location=0
    }
    fun moveCar(){
        val randNum=Randoms.pickNumberInRange(0,9)
        if(randNum>=4){
            location++
        }else if(randNum<3){

        }
    }

}