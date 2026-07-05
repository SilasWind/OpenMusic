package com.maxrave.windmusic.viewModel

import com.maxrave.domain.data.model.searchResult.albums.AlbumsResult
import com.maxrave.domain.data.model.searchResult.artists.ArtistsResult
import com.maxrave.domain.data.model.searchResult.playlists.PlaylistsResult
import com.maxrave.domain.data.model.searchResult.songs.Artist
import com.maxrave.domain.data.model.searchResult.songs.SongsResult
import com.maxrave.domain.data.model.searchResult.songs.Thumbnail
import com.maxrave.domain.data.model.searchResult.videos.VideosResult
import com.maxrave.domain.data.type.SearchResultType
import kotlin.test.Test
import kotlin.test.assertTrue

class SearchSuggestionsOrderingTest {
    @Test
    fun prioritizeSuggestionItems_placesPlaylistsBeforeSongsAndMixesFirst() {
        val items =
            listOf<SearchResultType>(
                SongsResult(
                    album = null,
                    artists = listOf(Artist(id = "", name = "Artist")),
                    category = null,
                    duration = "3:12",
                    durationSeconds = 192,
                    feedbackTokens = null,
                    isExplicit = false,
                    resultType = "Song",
                    thumbnails = listOf(Thumbnail(720, "https://example.com/song.jpg", 720)),
                    title = "Song",
                    videoId = "song-id",
                    videoType = null,
                    year = "",
                ),
                PlaylistsResult(
                    author = "YouTube Music",
                    browseId = "playlist-1",
                    category = "",
                    itemCount = "10",
                    resultType = "PLAYLIST",
                    thumbnails = listOf(Thumbnail(720, "https://example.com/playlist.jpg", 720)),
                    title = "Daily Mix",
                ),
                PlaylistsResult(
                    author = "YouTube Music",
                    browseId = "playlist-2",
                    category = "",
                    itemCount = "10",
                    resultType = "PLAYLIST",
                    thumbnails = listOf(Thumbnail(720, "https://example.com/playlist.jpg", 720)),
                    title = "Your Supermix",
                ),
                VideosResult(
                    artists = listOf(Artist(id = "", name = "Artist")),
                    category = null,
                    duration = "3:12",
                    durationSeconds = 192,
                    resultType = "Video",
                    thumbnails = listOf(Thumbnail(720, "https://example.com/video.jpg", 720)),
                    title = "Video",
                    videoId = "video-id",
                    videoType = null,
                    views = "1",
                    year = "",
                ),
                AlbumsResult(
                    artists = emptyList(),
                    browseId = "album-1",
                    category = "",
                    duration = "",
                    isExplicit = false,
                    resultType = "ALBUM",
                    thumbnails = listOf(Thumbnail(720, "https://example.com/album.jpg", 720)),
                    title = "Album",
                    type = "ALBUM",
                    year = "2024",
                ),
                ArtistsResult(
                    artist = "Artist",
                    browseId = "artist-1",
                    category = "",
                    radioId = "",
                    resultType = "ARTIST",
                    shuffleId = "",
                    thumbnails = listOf(Thumbnail(720, "https://example.com/artist.jpg", 720)),
                ),
            )

        val prioritized = prioritizeSuggestionItems(items)

        assertTrue(prioritized.first() is PlaylistsResult)
        assertTrue((prioritized.first() as PlaylistsResult).title.contains("Supermix", ignoreCase = true))
        assertTrue(prioritized.drop(1).first() is PlaylistsResult)
        assertTrue(prioritized.all { it !is SongsResult || it == prioritized.first() || prioritized.indexOf(it) > 1 })
    }
}
