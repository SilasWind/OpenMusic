package com.maxrave.windmusic.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.maxrave.windmusic.expect.ui.PlatformBackdrop
import com.maxrave.windmusic.ui.navigation.destination.home.HomeDestination
import com.maxrave.windmusic.ui.navigation.destination.library.LibraryDestination
import com.maxrave.windmusic.ui.navigation.destination.search.SearchDestination
import com.maxrave.windmusic.viewModel.SharedViewModel
import org.jetbrains.compose.resources.StringResource
import windmusic.composeapp.generated.resources.Res
import windmusic.composeapp.generated.resources.home
import windmusic.composeapp.generated.resources.library
import windmusic.composeapp.generated.resources.search
import kotlin.reflect.KClass

@Composable
expect fun LiquidGlassAppBottomNavigationBar(
    startDestination: Any = HomeDestination,
    navController: NavController,
    backdrop: PlatformBackdrop,
    viewModel: SharedViewModel,
    isScrolledToTop: Boolean = false,
    onOpenNowPlaying: () -> Unit = {},
    reloadDestinationIfNeeded: (KClass<*>) -> Unit = { _ -> },
)

sealed class BottomNavScreen(
    val ordinal: Int,
    val destination: Any,
    val title: StringResource,
    val icon: @Composable () -> Unit,
) {
    data object Home : BottomNavScreen(
        ordinal = 0,
        destination = HomeDestination,
        title = Res.string.home,
        icon = {
            Icon(
                Icons.Rounded.Home,
                contentDescription = null,
            )
        },
    )

    data object Search : BottomNavScreen(
        ordinal = 1,
        destination = SearchDestination,
        title = Res.string.search,
        icon = {
            Icon(
                Icons.Rounded.Search,
                contentDescription = null,
            )
        },
    )

    data object Library : BottomNavScreen(
        ordinal = 2,
        destination = LibraryDestination,
        title = Res.string.library,
        icon = {
            Icon(
                imageVector = Icons.Filled.LibraryMusic,
                contentDescription = null,
            )
        },
    )
}