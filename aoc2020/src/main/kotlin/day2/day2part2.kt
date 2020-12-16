import java.io.File

fun main() {
    var validPasswordCount = 0
    val lines = File("src/main/resources/input-day2.txt").readLines()
    for (line in lines) {
        val regex = "(\\d+)-(\\d+) (\\w): (\\w+)*".toRegex()
        val match = regex.find(line)
        if (match != null) {
            val (min, max, letter, password) = match.destructured
            if ((password[min.toInt() - 1] == letter[0]) xor ( password[max.toInt() - 1] == letter[0]))
                validPasswordCount++
        }
    }
    println("Total valid password is $validPasswordCount")
}
