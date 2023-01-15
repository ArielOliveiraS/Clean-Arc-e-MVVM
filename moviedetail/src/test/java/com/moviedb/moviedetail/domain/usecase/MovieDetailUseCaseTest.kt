package com.moviedb.moviedetail.domain.usecase

import com.moviedb.moviedetail.domain.repository.MovieDetailRepository
import app.cash.turbine.test
import com.moviedb.moviedetail.data.models.MovieItem
import io.mockk.coEvery
import org.junit.Test
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.time.ExperimentalTime

@ExperimentalTime
internal class MovieDetailUseCaseTest {
    private val repository: MovieDetailRepository = mockk()
    private val useCase = MovieDetailUseCase(repository)
    private val movieId = 123


    @Test
    fun `invoke Should return a movieItem when is success `() = runBlocking {
        // Given
        val expected = createMovieDetailStub()
        coEvery { repository.getMovieDetails(movieId, any()) } returns flow { emit(expected) }

        // When
        val result = useCase(movieId)

        // Then
        result.test {
            assertEquals(expected, expectItem())
            expectComplete()
        }
    }

    @Test
    fun `when repository returns error invoke Should return error`() = runBlocking {
        // Given
        val error = Throwable()
        coEvery { repository.getMovieDetails(movieId, any()) } returns flow { throw error }

        // When
        val result = useCase(movieId)

        // Then
        result.test {
            assertEquals(expectError(), error)
        }
    }

}

internal fun createMovieDetailStub() =
    MovieItem(
        budget = 0,
        id = 123,
        overview = "",
        genre_id = listOf(),
        popularity = 0.0,
        posterPath = "",
        releaseDate = "",
        revenue = 0,
        runtime = 0,
        status = "",
        tagline = "",
        title = "",
        video = false,
        rating = 0.0
    )