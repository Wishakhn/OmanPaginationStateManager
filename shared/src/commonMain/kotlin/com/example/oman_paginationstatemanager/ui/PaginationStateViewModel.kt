package com.example.oman_paginationstatemanager.ui

import com.example.oman_paginationstatemanager.data.PaginationState
import com.example.oman_paginationstatemanager.domain.CarDomainModel
import com.example.oman_paginationstatemanager.domain.GetCatsDataUsecase
import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.math.ceil

class PaginationStateViewModel(private val catsDataUseCase: GetCatsDataUsecase) : KMMViewModel() {


   private var _carsList: MutableStateFlow<List<CarDomainModel>> = MutableStateFlow(emptyList())
    val carsList = _carsList.asStateFlow()
    private var _focusedItem: MutableStateFlow<Int> = MutableStateFlow(0)
    val focusedItem = _focusedItem.asStateFlow()

    init {
        fetchCarsList()
    }
    private fun fetchCarsList() {
        viewModelScope.coroutineScope.launch {
            catsDataUseCase.invoke().collectLatest { list ->
                updateList(list)
            }
        }
    }


   private fun updateList(list: List<CarDomainModel>) {
        _carsList.update { emptyList() }
        _carsList.update { list }
    }

    fun paginationStateManager(totalRows : Int, rowsPerPage: Int, currentPage : Int) : PaginationState{
        // Calculate total pages
        val totalPages = ceil(totalRows.toDouble() / rowsPerPage).toInt()

        // Validate current page
        val currentPage = currentPage.coerceIn(1..totalPages)

        // Calculate pagination state
        val isFirstPage = currentPage == 1
        val isLastPage = currentPage == totalPages-1
        val hasPrevPage = currentPage > 1
        val hasNextPage = currentPage < totalPages

        // Calculate visible page numbers
        val visiblePageNumbers = mutableListOf<Int>()
        val startPage = currentPage - 2
        val endPage = currentPage + 2

        for (page in startPage..endPage) {
            if (page in 1..totalPages) {
                visiblePageNumbers.add(page)
            }
        }
        return PaginationState(
            currentPage =currentPage,
            totalPages =totalPages,
            isFirstPage =isFirstPage,
            isLastPage =isLastPage,
            hasPrevPage = hasPrevPage,
            visiblePages = visiblePageNumbers
        )

    }

    fun updateFocused(page : Int){
        _focusedItem.update { page }
    }
}