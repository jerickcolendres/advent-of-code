import java.io.File

fun main() {
    val lines = File("src/main/resources/input-day13.txt").readLines()
    val busList = lines[1].split(",")
    var timeStamp = 0L
    var step = 0L
    for ((index, bus) in busList.withIndex()) {
        if (bus != "x") {
            val busNumber = bus.toLong()
            // Set initial step to the first bus
            if (step == 0L) {
                step = busNumber
                continue
            }
            while ((timeStamp + index) % busNumber != 0L) {
                timeStamp += step
            }
            step *= busNumber
        }
    }
    println("Earliest time is $timeStamp")
}
