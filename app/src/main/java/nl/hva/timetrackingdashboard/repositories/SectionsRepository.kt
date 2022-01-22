package nl.hva.timetrackingdashboard.repositories

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import nl.hva.timetrackingdashboard.models.Section
import java.io.IOException

const val JSON_FILE = "data.json"

class SectionsRepository(private val context: Context) {
    private val _sections: MutableLiveData<List<Section>> = MutableLiveData()
    val sections: LiveData<List<Section>> get() = _sections

    fun getSections() {
        val jsonFileString = getJsonDataFromAsset(JSON_FILE)
        Log.i("data", jsonFileString!!)

        val gson = Gson()
        val listSectionType = object : TypeToken<List<Section>>() {}.type

        var tempSections: List<Section> = gson.fromJson(jsonFileString, listSectionType)
        tempSections.forEachIndexed { idx, section -> Log.i("data", "> Item $idx:\n$section") }
        _sections.value = tempSections
    }

    private fun getJsonDataFromAsset(fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context
                .assets
                .open(fileName)
                .bufferedReader()
                .use { it.readText() }
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return jsonString
    }
}