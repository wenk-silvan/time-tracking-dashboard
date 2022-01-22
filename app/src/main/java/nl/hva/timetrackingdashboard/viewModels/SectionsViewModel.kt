package nl.hva.timetrackingdashboard.viewModels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nl.hva.timetrackingdashboard.models.RefreshError
import nl.hva.timetrackingdashboard.models.Section
import nl.hva.timetrackingdashboard.repositories.SectionsRepository

class SectionsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = SectionsRepository(application.applicationContext)

    var sections: LiveData<List<Section>> = repository.sections
    private val _errorText: MutableLiveData<String> = MutableLiveData()
    val errorText: LiveData<String> get() = _errorText

    /**
     * Gets List<Section> from the repository and updates LiveData
     */
    fun getSections() {
        viewModelScope.launch {
            try {
                repository.getSections()
            } catch (error: RefreshError) {
                _errorText.value = error.message
                Log.e("Error while fetching section data", error.cause.toString())
            }
        }
    }
}