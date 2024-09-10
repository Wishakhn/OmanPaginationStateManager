package com.markaz.shared

import com.example.oman_paginationstatemanager.domain.GetCatsDataUsecase
import com.example.oman_paginationstatemanager.ui.PaginationStateViewModel
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertEquals

class PaginationStateManagerTest()  {
    private val useCase: GetCatsDataUsecase = mockk()
    private lateinit var viewModel: PaginationStateViewModel


    fun setUp() {
        viewModel = PaginationStateViewModel(useCase)
    }
    @Test
    fun `should calculate correct pagination state for basic case`() {
        val state = viewModel.paginationStateManager(100, 10, 5)
        assertEquals(10, state.totalPages)
        assertEquals(false, state.isFirstPage)
        assertEquals(false, state.isLastPage)
        assertEquals(true, state.hasPrevPage)
        assertEquals(listOf(3, 4, 5, 6, 7), state.visiblePages)
    }

    @Test
    fun `should handle edge cases correctly`() {
        val state1 = viewModel.paginationStateManager(5, 10, 1)
        assertEquals(1, state1.totalPages)
        assertEquals(true, state1.isFirstPage)
        assertEquals(true, state1.isLastPage)
        assertEquals(false, state1.hasPrevPage)
        assertEquals(listOf(1), state1.visiblePages)

        val state2 = viewModel.paginationStateManager(100, 10, 10)
        assertEquals(10, state2.totalPages)
        assertEquals(false, state2.isFirstPage)
        assertEquals(true, state2.isLastPage)
        assertEquals(true, state2.hasPrevPage)
        assertEquals(listOf(8, 9, 10), state2.visiblePages)
    }

    @Test
    fun `should clamp invalid page numbers`() {
        val state = viewModel.paginationStateManager(100, 10, 11)
        assertEquals(10, state.currentPage)
    }

    @Test
    fun `should handle zero rows per page`() {
        val state = viewModel.paginationStateManager(100, 0, 1)
        assertEquals(0, state.totalPages)
    }

    @Test
    fun `should handle negative values`() {
        val state = viewModel.paginationStateManager(-100, 10, 1)
        assertEquals(0, state.totalPages)
    }

    @Test
    fun `should ensure at least 5 visible pages`() {
        val state = viewModel.paginationStateManager(10, 10, 1)
        assertEquals(listOf(1, 2, 3, 4, 5), state.visiblePages)
    }

    @Test
    fun `should handle large datasets`() {
        val state = viewModel.paginationStateManager(10000, 10, 500)
        // Assert that the visible page numbers are within the expected range and contain at least 5 elements
    }

    // Add more test cases as needed, covering different scenarios and edge cases
}
