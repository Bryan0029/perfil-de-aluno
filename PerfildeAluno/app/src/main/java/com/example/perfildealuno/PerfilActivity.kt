package com.example.perfildealuno

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PerfilActivity : AppCompatActivity() {

    private lateinit var txtNome: TextView
    private lateinit var txtCurso: TextView
    private lateinit var txtIdade: TextView
    private lateinit var txtCidade: TextView
    private lateinit var btnVoltar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Liga as variáveis aos componentes do layout activity_perfil.xml
        txtNome = findViewById(R.id.txtNome)
        txtCurso = findViewById(R.id.txtCurso)
        txtIdade = findViewById(R.id.txtIdade)
        txtCidade = findViewById(R.id.txtCidade)
        btnVoltar = findViewById(R.id.btnVoltar)

        // Recupera os dados enviados pela MainActivity através do Intent
        val nome = intent.getStringExtra("NOME") ?: ""
        val curso = intent.getStringExtra("CURSO") ?: ""
        val idade = intent.getStringExtra("IDADE") ?: ""
        val cidade = intent.getStringExtra("CIDADE") ?: ""

        // Apresenta os dados nos TextViews
        txtNome.text = nome
        txtCurso.text = curso
        txtIdade.text = if (idade.isNotEmpty()) getString(R.string.sufixo_idade, idade) else ""
        txtCidade.text = cidade

        // Botão Voltar: encerra esta Activity e retorna para a MainActivity
        btnVoltar.setOnClickListener {
            finish()
        }
    }
}