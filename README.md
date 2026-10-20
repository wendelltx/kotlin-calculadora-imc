## Calculadora de IMC - LPDM Avaliação 2

## 1. Descrição
O aplicativo calcula o Índice de Massa Corporal (IMC) a partir de dados digitados pelo usuário, exibindo o resultado e uma classificação de acordo com a tabela de IMC.

## 2. Tecnologias Utilizadas
- **Linguagem:** Kotlin
- **UI Framework:** Jetpack Compose 
- **IDE:** Android Studio Ladybug 
- **Gerenciador de Dependências:** Gradle (Kotlin DSL com Version Catalog)
- **Mínimo SDK:** 24 (Android 7.0)
- **Target SDK:** 36

---

## 3. Como Compilar e Executar o Projeto


1. **Clonar o Repositório:**
   ```bash
   git clone https://github.com/wendelltx/kotlin-calculadora-imc.git
   ```
2. **Abrir no Android Studio:**
   - Abra o Android Studio.
   - Clique em `File > Open...` e selecione a pasta do projeto clonado (`kotlin-calculadora-imc`).
   - Aguarde o término do processo de sincronização do Gradle (*Gradle Sync*).


3. **Executar o App:**
   - Certifique-se de ter um emulador Android configurado ou um dispositivo físico conectado via Depuração USB.
   - Selecione o módulo `app` no menu superior de execução.
   - Clique no botão **Run** (ícone de play verde `▶`) ou utilize o atalho `Shift + F10`.


---


## 4. Estrutura de Arquivos e Composables

### `MainActivity.kt`
- **`MainActivity`**: Activity principal do aplicativo responsável por inicializar o conteúdo com o tema da aplicação (`LPDMavaliacao1Theme`) e definir o container base com `Scaffold`.
- **`CardPerfil`**: Função composable principal da tela. Organiza o layout em camadas utilizando `Box`, insere a foto de perfil, frase em destaque, nome, cargo, resumo profissional e a lista de contatos.
- **`ItemContato`**: Composable reutilizável criada para padronizar e renderizar cada linha de contato (ícone do Material Icons e texto correspondente), garantindo reutilização de código e alinhamento consistente.

---

## 5. Diagrama Textual da Hierarquia de Composables

```text
MainActivity
└── LPDMavaliacao1Theme
    └── Scaffold
        └── CardPerfil (Box)
            ├── Column (Alinhado ao Topo)
            │   ├── Image (Logotipo / Imagem superior)
            │   └── Text ("cartão pessoal profissional")
            │
            └── Column (Centralizado na tela)
                ├── Image (Foto de perfil circular com borda)
                ├── Text (Frase de impacto/saudação em destaque)
                ├── Text (Nome completo)
                ├── Text (Cargo / Título profissional)
                ├── Text ("Sobre mim:")
                ├── Text (Descrição/resumo profissional com borda)
                └── Column (Lista de Contatos)
                    ├── ItemContato (E-mail - Icons.Default.Email)
                    ├── ItemContato (Telefone - Icons.Default.Phone)
                    └── ItemContato (Rede Social / Web - Icons.Default.Share)
```

---

## 👤 Identificação do Aluno

- **Nome**: Wendell Teixeira
- **Turma**: Informática 3º Período
- **Instituição**: CEFET-MG

