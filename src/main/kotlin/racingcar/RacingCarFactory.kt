package racingcar

class RacingCarFactory {
     fun createCars(names: List<String>) : List<RacingCar> {
         val cars = mutableListOf<RacingCar>()
         for(name in names) {
             cars.add(RacingCar(name, 0))
         }
         return cars.toList()
     }
}