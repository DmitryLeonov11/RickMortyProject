package com.example.rickmortyproject.model.repository

import com.example.rickmortyproject.MainCoroutineRule
import com.example.rickmortyproject.model.database.ItemsDatabase
import com.example.rickmortyproject.model.retrofit.RetrofitServices
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.Before
import org.junit.Rule

import org.mockito.Mockito

class LocationDetailsRepositoryTest {

    var mockRetrofitServices: RetrofitServices = mock()
    var mockItemsDatabase: ItemsDatabase = mock()


    lateinit var SUT: LocationDetailsRepository

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutinesRule = MainCoroutineRule()
    @ExperimentalCoroutinesApi
    val testDispatcher = StandardTestDispatcher()
    @Before
    fun setUp() {
        Mockito.reset(mockRetrofitServices)
        Mockito.reset(mockItemsDatabase)
    }
/*
    @ExperimentalCoroutinesApi
    @Test
    fun getLocation() = runBlocking {
        val locationId = 2

        SUT = LocationDetailsRepository(mockRetrofitServices, mockItemsDatabase, testDispatcher)
        val returnLocation = Location(2, "Abadango", "Cluster", "unknown", arrayOf("https://rickandmortyapi.com/api/character/6"), "https://rickandmortyapi.com/api/location/2", "2017-11-10T13:06:38.182Z")
        whenever(mockRetrofitServices.getOneLocation(locationId)).thenReturn(returnLocation)
        val expected = flow {
            emit(ApiState.success(LocationDto(2, "Abadango", "Cluster", "unknown", "6")))
        }.flowOn(testDispatcher)
        val result = SUT.getLocation(locationId)
        assertEquals(result, expected)
    }*/

}