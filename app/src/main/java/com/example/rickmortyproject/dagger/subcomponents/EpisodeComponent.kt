package com.example.rickmortyproject.dagger.subcomponents

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.dagger.modules.EpisodeModule
import com.example.rickmortyproject.view.fragments.EpisodeFragment
import com.example.rickmortyproject.view.dialogs.EpisodeFilterDialog
import com.example.rickmortyproject.view.recycler_view.EpisodePaginationRecyclerAdapter
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Named

@ExperimentalPagingApi
@Subcomponent(modules = [EpisodeModule::class])
interface EpisodeComponent {

    fun inject(episodeFragment: EpisodeFragment)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun fragmentContext(@Named("episodeContext") fragmentContext: Context): Builder
        @BindsInstance
        fun episodeItemClickListener(itemClickListener: EpisodePaginationRecyclerAdapter.EpisodeViewHolder.ItemClickListener): Builder
        @BindsInstance
        fun applyItemClickListener(applyClickListener: EpisodeFilterDialog.ApplyClickListener): Builder
        fun build(): EpisodeComponent
    }
}