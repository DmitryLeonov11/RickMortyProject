package com.example.rickmortyproject.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_keys_episode")
class EpisodeRemoteKey(
    @PrimaryKey
    val episodeId: String,
    val prevKey: Int?,
    val nextKey: Int?
)