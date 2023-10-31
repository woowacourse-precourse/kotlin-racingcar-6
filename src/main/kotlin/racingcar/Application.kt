package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun make_frame(): List<String>{
    val sentence = Console.readLine().split(",")
    for (car in sentence){
        if (car.length > 3 || car.isEmpty()){
            throw IllegalArgumentException()
        }
    }
    return sentence
}

fun main() {
    val cars = make_frame()

}
