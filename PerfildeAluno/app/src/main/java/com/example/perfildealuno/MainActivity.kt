package com.example.perfildealuno

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var edtNome: EditText
    private lateinit var edtCurso: EditText
    private lateinit var edtIdade: EditText
    private lateinit var edtCidade: EditText
    private lateinit var btnVisualizar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Liga as variáveis aos componentes do layout activity_main.xml
        edtNome = findViewById(R.id.edtNome)
        edtCurso = findViewById(R.id.edtCurso)
        edtIdade = findViewById(R.id.edtIdade)
        edtCidade = findViewById(R.id.edtCidade)
        btnVisualizar = findViewById(R.id.btnVisualizar)

        // Evento: clique no botão "Visualizar Perfil"
        btnVisualizar.setOnClickListener {
            val nome = edtNome.text.toString().trim()
            val curso = edtCurso.text.toString().trim()
            val idade = edtIdade.text.toString().trim()
            val cidade = edtCidade.text.toString().trim()

            // Desafio 1: não abre a segunda tela se o nome estiver vazio
            if (nome.isEmpty()) {
                Toast.makeText(
                    this,
                    getString(R.string.msg_informe_nome),
                    Toast.LENGTH_SHORT
                ).show()
                edtNome.requestFocus()
                return@setOnClickListener
            }

            // A MainActivity (this) pede para abrir a PerfilActivity
            val intent = Intent(this, PerfilActivity::class.java)

            // Envia os dados dentro do próprio Intent
            intent.putExtra("NOME", nome)
            intent.putExtra("CURSO", curso)
            intent.putExtra("IDADE", idade)
            intent.putExtra("CIDADE", cidade)

            startActivity(intent)
        }
    }
}