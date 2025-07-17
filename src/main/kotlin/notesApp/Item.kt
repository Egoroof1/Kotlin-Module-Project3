package notesApp

abstract class Item (
    open val title: String
){
    abstract fun getMap() : MutableMap<Int, out Item>
}