import notesApp.Archive
import notesApp.Showing

fun main(args: Array<String>) {
    val show = Showing(::Archive)
    show.showArchives()

}