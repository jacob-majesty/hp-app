package com.majesty.hpapp.ui.house_students

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.majesty.hpapp.R
import com.majesty.hpapp.data.repository.HpRepository
import com.majesty.hpapp.ui.staff_list.StaffAdapter // Usando o adapter genérico

class HouseStudentsActivity : AppCompatActivity() {

    private lateinit var viewModel: HouseStudentsViewModel
    private lateinit var adapter: StaffAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var errorTextView: TextView
    private lateinit var editTextHouseName: EditText
    private lateinit var buttonFetchStudents: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house_students)

        recyclerView = findViewById(R.id.recyclerViewStudents)
        progressBar = findViewById(R.id.progressBarStudents)
        errorTextView = findViewById(R.id.textViewStudentsError)
        editTextHouseName = findViewById(R.id.editTextHouseName)
        buttonFetchStudents = findViewById(R.id.buttonFetchStudents)

        adapter = StaffAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val repository = HpRepository()
        val factory = HouseStudentsViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[HouseStudentsViewModel::class.java]

        buttonFetchStudents.setOnClickListener {
            val houseName = editTextHouseName.text.toString().trim()
            viewModel.fetchStudentsByHouse(houseName)
        }
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

            adapter.updateList(state.studentsList)
        }
    }
}