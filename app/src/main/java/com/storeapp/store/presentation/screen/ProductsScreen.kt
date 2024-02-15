package com.storeapp.store.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.storeapp.store.presentation.screen.component.ProductsCard
import com.storeapp.store.presentation.util.component.LoadingDialog
import com.storeapp.store.presentation.util.component.MyTopAppBar

// untuk view model
@Composable
internal fun ProductsScreen() {
    val viewModel: ProductsViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()
    ProductsContent(state = state)
}

// untuk UI dan state
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsContent(
    state: ProductsViewState,
    modifier: Modifier = Modifier
) {
    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        topBar = {
            MyTopAppBar(title = "Products")
        },
        modifier = modifier
    ) { innerPadding ->
        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .padding(top = innerPadding.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalItemSpacing = 8.dp
        ) {
            items(state.success) { product ->
                ProductsCard(product = product)
            }
        }
    }
}