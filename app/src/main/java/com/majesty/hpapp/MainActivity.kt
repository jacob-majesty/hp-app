package com.majesty.hpapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.majesty.hpapp.ui.character_details.CharacterDetailActivity
import com.majesty.hpapp.ui.house_students.HouseStudentsActivity
import com.majesty.hpapp.ui.staff_list.StaffListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Botão para Buscar Personagem por ID
        findViewById<Button>(R.id.buttonSearchById).setOnClickListener {
            val intent = Intent(this, CharacterDetailActivity::class.java)
            startActivity(intent)
        }

        // Botão para Listar Professores
        findViewById<Button>(R.id.buttonListStaff).setOnClickListener {
            val intent = Intent(this, StaffListActivity::class.java)
            startActivity(intent)
        }

        // Botão para Listar Estudantes por Casa
        findViewById<Button>(R.id.buttonListStudents).setOnClickListener {
            val intent = Intent(this, HouseStudentsActivity::class.java)
            startActivity(intent)
        }
    }
}