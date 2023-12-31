package com.example.rickmortyproject.model.repository

import androidx.paging.*
import com.example.rickmortyproject.model.mediator.EpisodeRemoteMediator
import com.example.rickmortyproject.model.database.ItemsDatabase
import com.example.rickmortyproject.model.dto.EpisodeForListDto
import com.example.rickmortyproject.model.retrofit.RetrofitServices
import kotlinx.coroutines.flow.Flow

class EpisodeRepository(
    private val mService: RetrofitServices,
    private val database: ItemsDatabase
) {

    @ExperimentalPagingApi
    fun getEpisodesFromMediator(queryData: MutableList<String>): Flow<PagingData<EpisodeForListDto>> {
        return Pager(PagingConfig(pageSize = 20, maxSize = 60),
            remoteMediator = EpisodeRemoteMediator(
                mService, database,
                queryData
            ),
            pagingSourceFactory = {
                database.getEpisodeDao().getSeveralForFilter(queryData[0], queryData[1])
            }).flow
    }
}