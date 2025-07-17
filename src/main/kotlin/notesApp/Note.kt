package notesApp

class Note(
    override var title: String,
    var description: String
) : Item(title) {

    private fun textEditing() : String{
        return description.split(".").joinToString("\n")
    }

    override fun getMap(): MutableMap<Int, out Item> {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "Заметка: $title\n" +
                "Текст:\n ${textEditing()}"
    }
}