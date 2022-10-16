package com.example.offlinecaching_cif

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.offlinecaching_cif.databinding.ActivityMainBinding
import com.example.offlinecaching_cif.features.restaurants.RestaurantAdapter
import com.example.offlinecaching_cif.features.restaurants.RestaurantViewModel
import com.example.offlinecaching_cif.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //activity_main ==>> Activity_Main_Binding
    private lateinit var binding: ActivityMainBinding
    private val viewModel: RestaurantViewModel by viewModels()

    private val myAdapter: RestaurantAdapter by lazy { RestaurantAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            recyclerView.apply {
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                adapter = myAdapter
                setHasFixedSize(true)
            }

            lifecycleScope.launchWhenStarted {

                viewModel.restaurants.collectLatest {  result ->
                    myAdapter.differ.submitList(result.data)

                    binding.progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                    binding.textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                    binding.textViewError.text = result.error?.localizedMessage
                }
            }



        }
    }

}




