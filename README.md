# HP App - Android

Aplicativo Android desenvolvido em Kotlin que consome a **Harry Potter API** (HP-API) para exibir informações sobre personagens, professores e estudantes de Hogwarts.

## 🧭 Funcionalidades

- **Dashboard principal** com navegação para as funcionalidades
- **Buscar personagem por ID**
- **Listar todos os professores** de Hogwarts
- **Listar estudantes por casa** (Grifinória, Sonserina, etc.)
- **Encerrar aplicativo**

## 🛠️ Tecnologias Utilizadas

- Kotlin
- Android SDK (API 28)
- Corrotinas (Coroutines)
- Retrofit/HttpURLConnection (para consumo da API)
- ViewBinding/DataBinding
- HP-API: https://hp-api.onrender.com/

## 📁 Estrutura do Projeto

```
app/
├── data/
│   ├── api/      # Configuração da API e serviços
│   └── model/    # Modelos de dados (Data Classes)
├── ui/
│   ├── dashboard/     # Activity principal
│   ├── character/     # Busca de personagem por ID
│   ├── teachers/      # Lista de professores
│   └── students/      # Lista de estudantes por casa
└── utils/             # Utilitários e extensões
```

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/jacob-majesty/hp-app.git
   ```

2. Abra o projeto no Android Studio

3. Execute em um emulador ou dispositivo físico com API 28 ou superior

## 📄 Endpoints Utilizados

- `/character/{id}` - Personagem específico
- `/staff` - Todos os professores
- `/house/{house}` - Estudantes por casa

---

**Nota:** Este projeto foi desenvolvido para a disciplina de Desenvolvimento Mobile II, com foco em corrotinas e consumo de APIs REST.
