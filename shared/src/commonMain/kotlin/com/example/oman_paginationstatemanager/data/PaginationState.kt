package com.example.oman_paginationstatemanager.data

data class PaginationState(
    val currentPage : Int = 1,
    val totalPages : Int = 10,
    val isFirstPage : Boolean = true,
    val isLastPage : Boolean= false,
    val hasPrevPage : Boolean= false,
    val visiblePages : List<Int> = emptyList()
)