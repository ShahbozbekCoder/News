package uz.shahbozbek.news.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import uz.shahbozbek.news.R
import uz.shahbozbek.news.data.db.ArticleDatabase
import uz.shahbozbek.news.databinding.ActivityMainBinding
import uz.shahbozbek.news.repository.NewsRepository
import kotlin.text.Typography.dagger

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)

        viewModel = ViewModelProvider(this,viewModelProviderFactory)[NewsViewModel::class.java]

        val navHostFragment =supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        binding.bottomAppBar.setupWithNavController(navHostFragment.navController)
    }



}