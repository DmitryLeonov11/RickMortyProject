package com.example.rickmortyproject.dagger.subcomponents

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import com.example.rickmortyproject.dagger.modules.CharacterModule
import com.example.rickmortyproject.view.fragments.CharacterFragment
import com.example.rickmortyproject.view.dialogs.CharacterFilterDialog
import com.example.rickmortyproject.view.recycler_view.CharacterPaginationRecyclerAdapter
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Named

@ExperimentalPagingApi
@Subcomponent(modules = [CharacterModule::class])
interface CharacterComponent {

    fun inject(characterFragment: CharacterFragment)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun fragmentContext(@Named("characterContext") fragmentContext: Context): Builder
        @BindsInstance
        fun characterItemClickListener(itemClickListener: CharacterPaginationRecyclerAdapter.CharacterViewHolder.ItemClickListener): Builder
        @BindsInstance
        fun applyItemClickListener(applyClickListener: CharacterFilterDialog.ApplyClickListener): Builder
        fun build(): CharacterComponent
    }
}