package com.maxrave.windmusic.di

import com.maxrave.windmusic.viewModel.AlbumViewModel
import com.maxrave.windmusic.viewModel.AnalyticsViewModel
import com.maxrave.windmusic.viewModel.ArtistViewModel
import com.maxrave.windmusic.viewModel.HomeViewModel
import com.maxrave.windmusic.viewModel.LibraryDynamicPlaylistViewModel
import com.maxrave.windmusic.viewModel.LibraryViewModel
import com.maxrave.windmusic.viewModel.LocalPlaylistViewModel
import com.maxrave.windmusic.viewModel.LogInViewModel
import com.maxrave.windmusic.viewModel.MoodViewModel
import com.maxrave.windmusic.viewModel.MoreAlbumsViewModel
import com.maxrave.windmusic.viewModel.NotificationViewModel
import com.maxrave.windmusic.viewModel.NowPlayingBottomSheetViewModel
import com.maxrave.windmusic.viewModel.PlaylistViewModel
import com.maxrave.windmusic.viewModel.PodcastViewModel
import com.maxrave.windmusic.viewModel.RecentlySongsViewModel
import com.maxrave.windmusic.viewModel.SearchViewModel
import com.maxrave.windmusic.viewModel.SettingsViewModel
import com.maxrave.windmusic.viewModel.SharedViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =
    module {
        single {
            SharedViewModel(
                get(),
                get(),
                get(),
                get(),
                get(),
                get(),
                get(),
                get(),
                get(),
            )
        }
        single {
            SearchViewModel(
                get(),
                get(),
            )
        }
        viewModel {
            NowPlayingBottomSheetViewModel(
                get(),
                get(),
                get(),
                get(),
            )
        }
        viewModel {
            LibraryViewModel(
                get(),
                get(),
                get(),
                get(),
                get(),
                get(),
                get(),
            )
        }
        viewModel {
            LibraryDynamicPlaylistViewModel(
                get(),
                get(),
            )
        }
        viewModel {
            AlbumViewModel(
                get(),
                get(),
            )
        }
        viewModel {
            HomeViewModel(
                get(),
                get(),
            )
        }
        viewModel {
            SettingsViewModel(
                get(),
                get(),
                get(),
                get(),
                get(),
            )
        }
        viewModel {
            ArtistViewModel(
                get(),
                get(),
            )
        }
        viewModel {
            PlaylistViewModel(
                get(),
                get(),
                get(),
            )
        }
        viewModel {
            LogInViewModel(
                get(),
            )
        }
        viewModel {
            PodcastViewModel(
                get(),
            )
        }
        viewModel {
            MoreAlbumsViewModel(
                get(),
            )
        }
        viewModel {
            RecentlySongsViewModel(
                get(),
            )
        }
        viewModel {
            LocalPlaylistViewModel(
                get(),
                get(),
                get(),
            )
        }
        viewModel {
            NotificationViewModel(
                get(),
            )
        }
        viewModel {
            MoodViewModel(
                get(),
                get(),
            )
        }
        viewModel {
            AnalyticsViewModel(
                get(),
                get(),
                get(),
                get(),
                get(),
            )
        }
    }