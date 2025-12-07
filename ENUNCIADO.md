# Desenvolvimento Mobile II - Trabalho Prático

## Objetivo

Desenvolver um aplicativo Android em **Kotlin** que consome a **Harry Potter API** (HP-API) para demonstrar o uso de **corrotinas** e **consumo de serviços web** (Web Services).

## 🔗 API Utilizada

**HP-API** disponível em:  
[https://hp-api.onrender.com/](https://hp-api.onrender.com/)

## 📋 Requisitos do Aplicativo

### 1. **Activity Principal - Dashboard**
- Deve apresentar uma tela inicial com botões distribuídos de forma equilibrada
- Cada botão deve levar a uma funcionalidade específica:
  - Listar um personagem específico (por ID)
  - Listar os professores da escola
  - Listar os estudantes de uma casa
  - Sair (fecha o aplicativo)

### 2. **Activity: Listar um Personagem Específico**
- Permitir que o usuário informe um **ID** para busca
- Utilizar o endpoint de busca específica da API
- Exibir em um `TextView` os campos:
  - `name` (nome do personagem)
  - `house` (casa do personagem)

### 3. **Activity: Listar os Professores da Escola**
- Apresentar em um `TextView` o **nome de todos os professores** de Hogwarts
- Utilizar o endpoint correspondente da API

### 4. **Activity: Listar os Estudantes de uma Casa**
- Criar uma interface com **Radio Buttons** contendo as casas de Hogwarts:
  - Gryffindor
  - Slytherin  
  - Hufflepuff
  - Ravenclaw
- Permitir que o usuário escolha **apenas uma** casa
- Exibir em um `TextView` os nomes de todos os estudantes da casa selecionada

### 5. **Sair**
- Fechar o aplicativo completamente

## Especificações Técnicas

- **Linguagem:** Kotlin
- **API Android:** 28 (ou superior)
- **Bibliotecas obrigatórias:**
  - Corrotinas (Coroutines) para operações assíncronas
  - Retrofit/HttpURLConnection/Ktor para consumo da API
- **Validações:** Todas as validações necessárias ficam a cargo da equipe
- **Interface:** Layouts responsivos e bem distribuídos

## 📁 Estrutura Esperada do Projeto

```
├── app/
│   ├── src/main/java/seupacote/
│   │   ├── DashboardActivity.kt
│   │   ├── CharacterActivity.kt
│   │   ├── TeachersActivity.kt
│   │   ├── StudentsActivity.kt
│   │   ├── data/
│   │   │   ├── api/
│   │   │   └── model/
│   │   └── utils/
│   └── res/
│       ├── layout/
│       └── values/
```

## Entrega

1. **Repositório no GitHub:**
   - Código fonte completo do projeto
   - README.md com instruções de execução
   - Este enunciado (enunciado.md)

2. **Documento de entrega contendo:**
   - Nome completo de todos os integrantes
   - Link para o repositório no GitHub


## Habilidades Avaliadas

- Consumo de API REST com Kotlin
- Uso de corrotinas para operações assíncronas
- Construção de interface Android
- Trabalho em equipe e organização de código
- Versionamento com Git

---
