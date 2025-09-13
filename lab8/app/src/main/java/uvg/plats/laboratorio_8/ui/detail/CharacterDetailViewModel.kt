package uvg.plats.laboratorio_8.ui.detail

import androidx.lifecycle.ViewModel
import uvg.plats.laboratorio_8.data.Character
import uvg.plats.laboratorio_8.data.CharacterDb

class CharacterDetailViewModel : ViewModel() {
    private val db = CharacterDb()
    fun byId(id: Int): Character = db.getCharacterById(id)
}
