package uz.shahbozbek.news.data.models

data class NewsApiData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)