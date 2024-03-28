package uz.shahbozbek.news.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.shahbozbek.news.data.models.NewsApiData
import uz.shahbozbek.news.util.Constants.Companion.API_KEY

interface ApiInterface {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ):Response<NewsApiData>

    @GET("v2/everything")
    suspend fun searchNews(
        @Query("q")
        countryCode: String = "us",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ):Response<NewsApiData>

}