package com.example.rickmortyproject.viewmodel

import android.app.Dialog
import android.widget.CheckBox
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.rickmortyproject.R
import com.example.rickmortyproject.view.dialogs.Filter
import com.example.rickmortyproject.model.dto.EpisodeForListDto
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class EpisodeViewModel(
    private val dataSource: Flow<PagingData<EpisodeForListDto>>
) : ViewModel() {

    val episodeCodeFilter = MutableLiveData<Filter>()

    val episodes: Flow<PagingData<EpisodeForListDto>> by lazy {
        dataSource.cachedIn(viewModelScope)
    }

    fun onApplyClick(dialog: Dialog) {
        val checkEpisodeCode = dialog.findViewById<CheckBox>(R.id.checkBoxEpisodeCode)
        val editEpisodeCode = dialog.findViewById<EditText>(R.id.editTextEpisodeCode)
        episodeCodeFilter.value = Filter(checkEpisodeCode.isChecked, editEpisodeCode.text.toString())

        dialog.dismiss()
    }
}