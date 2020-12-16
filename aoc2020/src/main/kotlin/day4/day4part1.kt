import java.io.File

fun main() {
    val lines = File("src/main/resources/input-day4.txt").readLines()
    var it = lines.iterator()
    var validPassportCount = 0;
    var passport = ""
    while (it.hasNext()) {
        val line = it.next()
        // Build passport string
        passport += "$line "
        if (line.isBlank() || !it.hasNext()) {
            passport = passport.trim()
            println("$passport\n")
            // Mandatory fields
            val hasByr = passport.contains("byr:")
            val hasEyr = passport.contains("eyr:")
            val hasIyr = passport.contains("iyr:")
            val hasHgt = passport.contains("hgt:")
            val hasHcl = passport.contains("hcl:")
            val hasEcl = passport.contains("ecl:")
            val hasPid = passport.contains("pid:")
            if (hasByr && hasIyr && hasEyr && hasHgt && hasHcl && hasEcl && hasPid) {
                validPassportCount++
            }
            passport = ""
        }
    }
    println("Total number of valid passport is $validPassportCount")
}
