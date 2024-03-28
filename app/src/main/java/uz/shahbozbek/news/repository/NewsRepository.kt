package uz.shahbozbek.news.repository

import uz.shahbozbek.news.data.db.ArticleDatabase
import uz.shahbozbek.news.util.RetrofitInstance

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

}