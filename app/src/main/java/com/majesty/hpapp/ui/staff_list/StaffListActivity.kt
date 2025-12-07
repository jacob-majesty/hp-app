package com.majesty.hpapp.ui.staff_list

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.majesty.hpapp.R
import com.majesty.hpapp.data.repository.HpRepository

class StaffListActivity : AppCompatActivity() {

    private lateinit var viewModel: StaffListViewModel
    private lateinit var adapter: StaffAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var errorTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_list)

        recyclerView = findViewById(R.id.recyclerViewStaff)
        progressBar = findViewById(R.id.progressBarStaff)
        errorTextView = findViewById(R.id.textViewStaffError)

        adapter = StaffAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val repository = HpRepository()
        val factory = StaffListViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[StaffListViewModel::class.java]

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.state.observe(this) { state ->
            progressBar.visibility = if (state.isLoading) View.VISIBLE else View.GONE

            if (state.error != null) {
                errorTextView.text = "Erro: ${state.error}"
                errorTextView.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            } else {
                errorTextView.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            }

            if (state.staffList.isNotEmpty()) {
                adapter.updateList(state.staffList)
            }
        }
    }
}