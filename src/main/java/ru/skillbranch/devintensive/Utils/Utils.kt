package ru.skillbranch.devintensive.Utils

object Utils {
    fun parseFullName(fullname:String?):Pair<String?, String?>{
        val parts: List<String>? = fullname?.split(" ")?.filter { !it.isBlank() }
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return (if (firstName.isNullOrEmpty()) null else firstName) to
                (if (lastName.isNullOrEmpty()) null else lastName)
    }
    fun toInitials(firstName: String?, lastName: String?): String? {
        val initials = (if (firstName.isNullOrBlank()) "" else firstName.substring(0, 1)) +
                if (lastName.isNullOrBlank()) "" else lastName.substring(0, 1)

        return (if (initials.isEmpty()) null else initials.toUpperCase())
    }

    fun getPluralForm(pluralForms: String, count: Int): String {
        val forms = pluralForms.split(";")
        when (count % 10) {
            1 -> if (count % 100 != 11)
                return forms[0]
            in 2..4 -> if (count % 100 !in 12..14) {
                return forms[1]
            }
        }

        return forms[2]
    }
}