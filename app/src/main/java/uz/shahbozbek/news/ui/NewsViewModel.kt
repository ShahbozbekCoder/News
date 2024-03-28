package uz.shahbozbek.news.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import uz.shahbozbek.news.data.models.NewsApiData
import uz.shahbozbek.news.repository.NewsRepository
import uz.shahbozbek.news.util.Resource

class NewsViewModel(
    val newsRepository: NewsRepository
) : ViewModel() {

    val breakingNews:MutableLiveData<Resource<NewsApiData>> = MutableLiveData()
    var breakingNewsPage = 1

    init {
        getBreakingNews(countryCode = "us")
    }

    fun getBreakingNews(countryCode:String) = viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response = newsRepository.getBreakingNews(countryCode,breakingNewsPage)
        breakingNews.postValue(handleBreakingNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(response:Response<NewsApiData>):Resource<NewsApiData>{
        if (response.isSuccessful){
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
}