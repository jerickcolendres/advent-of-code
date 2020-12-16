import java.io.File

fun main() {
    val lines = File("src/main/resources/input-day1.txt").readLines()
    outerLoop@ for (x in lines) {
        for (y in lines) {
            val num1 = x.toInt()
            val num2 = y.toInt()
            if ((num1 != num2) && (num1 + num2 == 2020)) {
                println("$num1 * $num2 = " + num1 * num2)
                break@outerLoop
            }
        }
    }
}
