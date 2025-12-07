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

## Guia Mínimo de Funcionamento do HPApp
Para verificar o funcionamento básico do seu aplicativo, execute os seguintes testes:

| Passo | Ação no App | Resultado Esperado |
| :--- | :--- | :--- |
| **1. Busca por ID** | Insira o ID: **`9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8`** (Harry Potter). | O aplicativo deve exibir os detalhes de **Harry Potter**. |
| **2. Listar Professores** | Navegue até a tela "Professores" ou clique em "Listar Professores". | Uma lista de personagens com o cargo de **Professor** deve ser exibida. |
| **3. Busca por Casa** | Digite **`slytherin`** (em minúsculo) no campo de busca de estudantes por casa. | O aplicativo deve retornar uma lista contendo apenas os estudantes da casa **Slytherin**. |

Casas: gryffindor, slytherin, ravenclaw ou hufflepuff

## Imagens de funcionamento
<img width="361" height="763" alt="image" src="https://github.com/user-attachments/assets/1f569cfc-c6c6-4fcc-b116-1da204bada97" />

<img width="376" height="743" alt="image" src="https://github.com/user-attachments/assets/b963d976-8fa7-4fb2-a03e-c05566fd7cbe" />

<img width="385" height="716" alt="image" src="https://github.com/user-attachments/assets/360cfa5e-e50b-4e97-a800-7889b69a9fa9" />

<img width="374" height="735" alt="image" src="https://github.com/user-attachments/assets/0210d5b9-88dc-46c8-828b-fdb0810b6f0a" />

---

**Nota:** Este projeto foi desenvolvido para a disciplina de Desenvolvimento Mobile II, com foco em corrotinas e consumo de APIs REST.
