package uz.shahbozbek.news.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.shahbozbek.news.repository.NewsRepository

class NewsViewModelProviderFactory(val newsRepository: NewsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }
}