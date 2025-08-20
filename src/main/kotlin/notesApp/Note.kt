package notesApp

class Note(
    var title: String,
    var description: String
) {

    private fun textEditing() : String{
        return description.split(".").joinToString("\n")
    }

    override fun toString(): String {
        return "Заметка: $title\n" +
                "Текст:\n ${textEditing()}"
    }
}