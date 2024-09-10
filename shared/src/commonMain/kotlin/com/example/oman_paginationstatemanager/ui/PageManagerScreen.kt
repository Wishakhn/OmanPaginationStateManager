package com.example.oman_paginationstatemanager.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oman_paginationstatemanager.PMAsyncImage
import com.example.oman_paginationstatemanager.domain.CarDomainModel
import org.koin.compose.koinInject

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerManagerScreen(viewModel: PaginationStateViewModel = koinInject()) {
    val list = viewModel.carsList.collectAsState()
    val scope = rememberCoroutineScope()
    val focusedItem = viewModel.focusedItem.collectAsState()
    val pagerState = rememberPagerState() {
        list.value.size
    }
    Column(
        modifier = Modifier.fillMaxSize().background(Color.LightGray),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Car List For buying", fontSize = 15.sp)
        }
        HorizontalPager(state = pagerState, modifier = Modifier.wrapContentHeight()) { page: Int ->
            ItemPaginationImage(list.value[page])
            viewModel.updateFocused(pagerState.currentPage)
          val results =   viewModel.paginationStateManager(totalRows = list.value.size, 1, pagerState.currentPage)
            println("The Pagination State: ${results}")
        }
        PageIndicator(
            pagerState.pageCount,
            pagerState.currentPage
        )

    }
}

@Composable
fun PageIndicator(
    totalPages: Int,
    selectedIndex: Int
) {
    LazyRow(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()

    ) {
        items(totalPages) { index ->
            Text(
                text = "${index + 1}",
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape)
                    .background(if (index == selectedIndex) Color.Green else Color.White),
                textAlign = TextAlign.Center
            )
            if (index != totalPages - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            }
        }
    }
}

@Composable
fun ItemPaginationImage(item: CarDomainModel) {
    Column(
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PMAsyncImage(
            data = item.carImage,
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.padding(horizontal = 10.dp).clip(RoundedCornerShape(8.dp))
                .height(300.dp).fillMaxWidth()
        ) {

        }
        Text(item.carName)
    }
}