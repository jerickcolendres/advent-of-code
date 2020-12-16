import java.io.File

fun main() {
    val lines = File("src/main/resources/input-day4.txt").readLines()
    var iterator = lines.iterator()
    var validPassportCount = 0;
    var passport = ""
    while (iterator.hasNext()) {
        val line = iterator.next()
        // Build passport string
        passport += "$line "
        if (line.isBlank() || !iterator.hasNext()) {
            // Trim spaces
            passport = passport.trim()
            val passportFields: MutableMap<String, String> = mutableMapOf()
            passport.split(" ").forEach {
                val fieldMatch = Regex("(\\w{3}):(.*)").find(it)
                if (fieldMatch != null) {
                    val (key, value) = fieldMatch.destructured;
                    passportFields[key] = value
                }
            }
            var hasValidByr = false
            var hasValidIyr = false
            var hasValidEyr = false
            var hasValidHgt = false
            val byrMatch = passportFields["byr"]?.let { Regex("(^\\d{4})$").find(it) }
            if (byrMatch != null) {
                val (year) = byrMatch.destructured
                hasValidByr = year.toInt() in 1920..2002
            }
            val eyrMatch = passportFields["eyr"]?.let { Regex("(^\\d{4})$").find(it) }
            if (eyrMatch != null) {
                val (year) = eyrMatch.destructured
                hasValidEyr = year.toInt() in 2020..2030
            }
            val iyrMatch = passportFields["iyr"]?.let { Regex("^(\\d{4})$").find(it) }
            if (iyrMatch != null) {
                val (year) = iyrMatch.destructured
                hasValidIyr = year.toInt() in 2010..2020
            }
            val hgtMatch = passportFields["hgt"]?.let { Regex("^(\\d+)(cm|in)$").find(it) }
            if (hgtMatch != null) {
                val (height, unit) = hgtMatch.destructured
                hasValidHgt = when (unit) {
                    "cm" -> height.toInt() in 150..193
                    "in" -> height.toInt() in 59..76
                    else -> false
                }
            }
            val hasValidHcl = passportFields["hcl"]?.let { Regex("#[0-9a-f]{6}$").find(it) } != null
            val hasValidEcl = passportFields["ecl"]?.let { Regex("(amb|blu|brn|gry|grn|hzl|oth)$").find(it) } != null
            val hasValidPid = passportFields["pid"]?.let { Regex("^(\\d{9})$").find(it) } != null
            if (hasValidByr && hasValidIyr && hasValidEyr && hasValidHgt && hasValidHcl && hasValidEcl && hasValidPid) {
                validPassportCount++
            }
            passport = ""
        }
    }
    println("Total number of valid passport is $validPassportCount")
}
