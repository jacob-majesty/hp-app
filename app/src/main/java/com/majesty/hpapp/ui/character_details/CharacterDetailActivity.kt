package com.majesty.hpapp.ui.character_details

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.majesty.hpapp.R
import com.majesty.hpapp.data.repository.HpRepository

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CharacterDetailViewModel
    private lateinit var editTextCharacterId: EditText
    private lateinit var buttonFetchCharacter: Button
    private lateinit var progressBarLoading: ProgressBar
    private lateinit var textViewResultName: TextView
    private lateinit var textViewResultHouse: TextView
    private lateinit var textViewError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        val repository = HpRepository()
        val factory = CharacterDetailViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[CharacterDetailViewModel::class.java]

        editTextCharacterId = findViewById(R.id.editTextCharacterId)
        buttonFetchCharacter = findViewById(R.id.buttonFetchCharacter)
        progressBarLoading = findViewById(R.id.progressBarLoading)
        textViewResultName = findViewById(R.id.textViewResultName)
        textViewResultHouse = findViewById(R.id.textViewResultHouse)
        textViewError = findViewById(R.id.textViewError)

        buttonFetchCharacter.setOnClickListener {
            val id = editTextCharacterId.text.toString().trim()
            viewModel.fetchCharacter(id)
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.state.observe(this) { state ->
            progressBarLoading.visibility = if (state.isLoading) View.VISIBLE else View.GONE

            textViewError.visibility = View.GONE

            state.character?.let { character ->
                textViewResultName.text = "Nome: ${character.name}"
                textViewResultHouse.text = "Casa: ${character.house ?: "N/A"}"
            }

            state.error?.let { errorMsg ->
                textViewResultName.text = "Nome: "
                textViewResultHouse.text = "Casa: "

                textViewError.text = "Erro: $errorMsg"
                textViewError.visibility = View.VISIBLE
            }
        }
    }
}