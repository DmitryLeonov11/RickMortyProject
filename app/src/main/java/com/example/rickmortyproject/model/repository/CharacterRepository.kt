package com.example.rickmortyproject.model.repository

import androidx.paging.*
import com.example.rickmortyproject.model.database.ItemsDatabase
import com.example.rickmortyproject.model.mediator.CharacterRemoteMediator
import com.example.rickmortyproject.model.dto.CharacterForListDto
import com.example.rickmortyproject.model.retrofit.RetrofitServices
import kotlinx.coroutines.flow.Flow

class CharacterRepository(
    private val mService: RetrofitServices,
    private val database: ItemsDatabase
) {

    @ExperimentalPagingApi
    fun getCharactersFromMediator(queryData: MutableList<String>): Flow<PagingData<CharacterForListDto>> {
        return Pager(PagingConfig(pageSize = 20, maxSize = 60),
            remoteMediator = CharacterRemoteMediator(
                mService,
                database,
                queryData
            ),
            pagingSourceFactory = {
                database.getCharacterDao().getSeveralForFilter(queryData[0], queryData[1], queryData[2], queryData[3], queryData[4])
            }).flow
    }
}