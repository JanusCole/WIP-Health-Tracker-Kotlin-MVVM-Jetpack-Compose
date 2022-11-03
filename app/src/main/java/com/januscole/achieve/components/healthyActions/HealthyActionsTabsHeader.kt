package com.januscole.achieve.components.healthyActions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.januscole.achieve.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HealthyActionsTabsHeader(tabs: List<HealthyActionScreen>, pagerState: PagerState) {

    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        //backgroundColor = colorResource(id = R.color.cvs_brand_red),
        modifier = Modifier
            .fillMaxWidth()
            .height(25.dp),
        indicator = { tabPositions ->
            Modifier.pagerTabIndicatorOffset(pagerState = pagerState, tabPositions = tabPositions)
        }) {
        tabs.forEachIndexed { index, healthyActionTab ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = { Text(healthyActionTab.title) },
                //icon = {Icon(imageVector = tabItem.icons,contentDescription = null)},
                selectedContentColor = Color.White,
                unselectedContentColor = colorResource(id = R.color.cvs_brand_red),
                enabled = true,
                modifier = Modifier
                    .background(
                        if (pagerState.currentPage == index) {
                            colorResource(id = R.color.cvs_brand_red)
                        } else {
                            Color.White
                        }
                    )
            )
        }
    }
}