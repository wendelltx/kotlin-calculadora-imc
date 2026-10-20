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
- **`MainActivity`**: Activity principal do aplicativo responsável por inicializar o conteúdo com o tema da aplicação (`CalculadoraIMCTheme`) e definir a interface base do app.
- **`TipTimeLayout`**: Composable principal da tela. Organiza o layout em uma `Column` contendo os campos de entrada para peso e altura, opção para arredondamento do resultado, botão de cálculo e exibição do valor do IMC.
- **`EditNumberField`**: Composable reutilizável para renderizar campos de entrada de dados (`TextField`) customizados para valores numéricos, permitindo definir o rótulo (`label`) e as opções de teclado (`KeyboardOptions`).
- **`RoundTheTipRow`**: Composable responsável por exibir a opção de arredondamento do resultado, contendo o texto informativo e um componente `Switch`.
- **`ExibirImc`**: Composable responsável por apresentar o valor final do IMC e a classificação/faixa de peso correspondente.

---

## 5. Diagrama Textual da Hierarquia de Composables

```text
MainActivity
└── CalculadoraIMCTheme
    └── TipTimeLayout (Column)
        ├── Text ("Calcular IMC")
        ├── EditNumberField (Peso - kg)
        │   └── TextField
        ├── EditNumberField (Altura - m)
        │   └── TextField
        ├── RoundTheTipRow
        │   └── Row
        │       ├── Text ("Arredondar resultado")
        │       └── Switch
        ├── Button ("Calcular")
        │   └── Text ("Calcular")
        └── Text ("IMC: ...")

ExibirImc (Column)
├── Text ("IMC: ...")
└── Text ("Classificação: ...")
```

---

## 👤 Identificação do Aluno

- **Nome**: Wendell Teixeira
- **Turma**: Informática 3º Período
- **Instituição**: CEFET-MG

