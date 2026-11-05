import java.util.Locale;
import java.util.Scanner;

public class FarmaciaVivaBem2 {

    // ================================================
    // 1. DECLARACAO DE VETORES E VARIAVEIS
    // ================================================

    static final int MAX_PRODUTOS = 50;
    static final int NUM_CATEGORIAS = 4;

    // Dados dos produtos
    static String[] nomes = new String[MAX_PRODUTOS];
    static String[] lotes = new String[MAX_PRODUTOS];
    static String[] codigos = new String[MAX_PRODUTOS];
    static String[] codigosBarras = new String[MAX_PRODUTOS];
    static String[] estados = new String[MAX_PRODUTOS];
    static int[] categorias = new int[MAX_PRODUTOS];   // valores de 1 a 4
    static int[] quantidades = new int[MAX_PRODUTOS];
    static int[] validadesMes = new int[MAX_PRODUTOS];
    static int[] validadesAno = new int[MAX_PRODUTOS];
    static double[] custos = new double[MAX_PRODUTOS];
    static double[] vendas = new double[MAX_PRODUTOS];
    static double[] margens = new double[MAX_PRODUTOS];

    // Categorias tributarias (indice = categoria - 1)
    static String[] nomesCategorias = new String[NUM_CATEGORIAS];
    static double[] taxasSimples = new double[NUM_CATEGORIAS];
    static double[] taxasIcms = new double[NUM_CATEGORIAS];
    static double taxaCartao;

    // Controle do sistema
    static int totalProdutos;
    static int perfilAcesso; // 0 = nenhum, 1 = atendente, 2 = gestor

    // Data de referencia
    static int mesAtual;
    static int anoAtual;

    static final Scanner scanner = new Scanner(System.in);
    static final Locale BR = Locale.forLanguageTag("pt-BR");

    // ================================================
    // 2. INICIALIZACAO
    // ================================================

    static void inicializar() {
        totalProdutos = 0;
        perfilAcesso = 0;

        mesAtual = 10;
        anoAtual = 2026;

        nomesCategorias[0] = "Medicamento Isento";
        nomesCategorias[1] = "Medicamento Generico";
        nomesCategorias[2] = "Perfumaria";
        nomesCategorias[3] = "Suplementos e Correlatos";

        taxasSimples[0] = 0;
        taxasIcms[0] = 0;

        taxasSimples[1] = 2.1;
        taxasIcms[1] = 0;

        taxasSimples[2] = 4;
        taxasIcms[2] = 18;

        taxasSimples[3] = 5;
        taxasIcms[3] = 18;

        taxaCartao = 3;
    }

    // ================================================
    // MAIN
    // ================================================

    public static void main(String[] args) {
        inicializar();
        login();
        menuPrincipal();
        System.out.println("Sistema encerrado.");
    }

    // ================================================
    // 3. LOGIN
    // ================================================

    static void login() {
        System.out.println("=================================");
        System.out.println("       FARMACIA VIVA BEM");
        System.out.println("=================================");

        do {
            String usuario = lerTexto("Digite o usuario:");
            String senha = lerTexto("Digite a senha:");

            if (usuario.equals("gestor") && senha.equals("123")) {
                perfilAcesso = 2;
                System.out.println("Acesso permitido: GESTOR");
            } else if (usuario.equals("atendente") && senha.equals("123")) {
                perfilAcesso = 1;
                System.out.println("Acesso permitido: ATENDENTE");
            } else {
                perfilAcesso = 0;
                System.out.println("Usuario ou senha invalidos.");
            }
        } while (perfilAcesso == 0);
    }

    // ================================================
    // 4. MENU PRINCIPAL
    // ================================================

    static void menuPrincipal() {
        int opcaoMenu = -1;

        while (opcaoMenu != 0) {
            System.out.println(" ");
            System.out.println("========== MENU PRINCIPAL ==========");
            System.out.println("1 - Consultar estoque");
            System.out.println("4 - Movimentar estoque");

            if (perfilAcesso == 2) {
                System.out.println("2 - Cadastrar produto");
                System.out.println("3 - Relatorio de validades");
                System.out.println("5 - Painel financeiro");
                System.out.println("6 - Configurar tributos");
            }

            System.out.println("0 - Sair");
            opcaoMenu = lerInteiro("Escolha uma opcao:");

            if (opcaoMenu == 1) {
                consultarEstoque();
            } else if (opcaoMenu == 2 && perfilAcesso == 2) {
                cadastrarProduto();
            } else if (opcaoMenu == 3 && perfilAcesso == 2) {
                relatorioValidades();
            } else if (opcaoMenu == 4) {
                movimentarEstoque();
            } else if (opcaoMenu == 5 && perfilAcesso == 2) {
                painelFinanceiro();
            } else if (opcaoMenu == 6 && perfilAcesso == 2) {
                configurarTributos();
            } else if (opcaoMenu != 0) {
                System.out.println("Opcao invalida ou acesso negado.");
            }
        }
    }

    // ================================================
    // OPCAO 1 - CONSULTAR ESTOQUE
    // ================================================

    static void consultarEstoque() {
        if (totalProdutos == 0) {
            System.out.println("Estoque vazio.");
            return;
        }

        for (int i = 0; i < totalProdutos; i++) {
            estados[i] = calcularEstado(i);

            // O codigo e o lote identificam o registro.
            System.out.println("Identificador: " + codigos[i] + lotes[i]);
            System.out.println("Codigo de barras: " + codigosBarras[i]);
            System.out.println("Produto: " + nomes[i]);
            System.out.println("Lote: " + lotes[i]);
            System.out.println("Categoria: " + nomesCategorias[categorias[i] - 1]);
            System.out.println("Quantidade: " + quantidades[i]);
            System.out.println("Preco de custo: R$ " + moeda(custos[i]));
            System.out.println("Preco de venda: R$ " + moeda(vendas[i]));
            System.out.println("Validade: " + validadesMes[i] + "/" + validadesAno[i]);
            System.out.println("Estado: " + estados[i]);
            System.out.println(" ");
        }
    }

    // ================================================
    // OPCAO 2 - CADASTRAR PRODUTO (SOMENTE GESTOR)
    // ================================================

    static void cadastrarProduto() {
        if (totalProdutos >= MAX_PRODUTOS) {
            System.out.println("Limite de 50 produtos atingido.");
            return;
        }

        String tempNome = lerTexto("Nome do produto:");
        String tempCodigo = lerTexto("Codigo do produto (exemplo: 19):");
        String tempBarras = lerTexto("Codigo de barras:");
        String tempLote = lerTexto("Lote de fabricacao (exemplo: L2012):");
        int tempQtd = lerInteiro("Quantidade disponivel:");
        int tempMes = lerInteiro("Mes de validade (1 a 12):");
        int tempAno = lerInteiro("Ano de validade:");
        double tempCusto = lerDecimal("Preco de custo:");
        double tempMargem = lerDecimal("Margem de lucro desejada (%):");

        System.out.println("1 - Medicamento Isento");
        System.out.println("2 - Medicamento Generico");
        System.out.println("3 - Perfumaria");
        System.out.println("4 - Suplementos e Correlatos");
        int tempCat = lerInteiro("Escolha a categoria:");

        // Verifica se o codigo e o lote ja existem.
        // Tambem impede o uso repetido do codigo de barras.
        boolean duplicado = false;

        for (int j = 0; j < totalProdutos; j++) {
            if (codigos[j].equals(tempCodigo) && lotes[j].equals(tempLote)) {
                duplicado = true;
            }
            if (codigosBarras[j].equals(tempBarras)) {
                duplicado = true;
            }
        }

        // Verificacao dos dados informados
        if (tempNome.isEmpty() || tempCodigo.isEmpty()
                || tempBarras.isEmpty() || tempLote.isEmpty()) {
            System.out.println("Erro: existem campos vazios.");

        } else if (tempQtd < 0 || tempCusto <= 0) {
            System.out.println("Erro: quantidade ou custo invalido.");

        } else if (tempMes < 1 || tempMes > 12) {
            System.out.println("Erro: mes de validade invalido.");

        } else if (tempAno < 2000) {
            System.out.println("Erro: ano de validade invalido.");

        } else if (tempMargem < 0) {
            System.out.println("Erro: margem invalida.");

        } else if (tempCat < 1 || tempCat > NUM_CATEGORIAS) {
            System.out.println("Erro: categoria invalida.");

        } else if (duplicado) {
            System.out.println("Codigo de barras ou identificacao duplicada.");

        } else {
            double precoCalculado = calcularPreco(
                    tempCusto,
                    taxasSimples[tempCat - 1],
                    taxasIcms[tempCat - 1],
                    taxaCartao,
                    tempMargem);

            int i = totalProdutos;
            totalProdutos++;

            nomes[i] = tempNome;
            codigos[i] = tempCodigo;
            codigosBarras[i] = tempBarras;
            lotes[i] = tempLote;
            categorias[i] = tempCat;
            quantidades[i] = tempQtd;
            validadesMes[i] = tempMes;
            validadesAno[i] = tempAno;
            custos[i] = tempCusto;
            margens[i] = tempMargem;
            vendas[i] = precoCalculado;
            estados[i] = calcularEstado(i);

            System.out.println("Produto cadastrado com sucesso.");
            System.out.println("Identificador: " + codigos[i] + lotes[i]);
            System.out.println("Preco sugerido: R$ " + moeda(vendas[i]));
            System.out.println("Estado: " + estados[i]);
        }
    }

    // ================================================
    // OPCAO 3 - RELATORIO DE VALIDADES (SOMENTE GESTOR)
    // ================================================

    static void relatorioValidades() {
        int alertas = 0;

        for (int i = 0; i < totalProdutos; i++) {
            int diferenca = diferencaEmMeses(i);

            if (diferenca < 0) {
                estados[i] = "EXPIRADO";

                System.out.println("PRODUTO EXPIRADO: " + nomes[i]);
                System.out.println("Lote: " + lotes[i]);
                System.out.println("Validade: " + validadesMes[i] + "/" + validadesAno[i]);
                System.out.println("Retirar da venda e verificar descarte.");

                alertas++;

            } else if (diferenca <= 2) {
                estados[i] = "PERTO DO VENCIMENTO";

                System.out.println("PRODUTO PROXIMO DO VENCIMENTO: " + nomes[i]);
                System.out.println("Lote: " + lotes[i]);

                int desconto = (diferenca == 2) ? 10 : 20;
                double precoPromocional = vendas[i] - vendas[i] * desconto / 100.0;

                System.out.println("Desconto sugerido: " + desconto + "%");
                System.out.println("Preco promocional: R$ " + moeda(precoPromocional));

                alertas++;

            } else {
                estados[i] = "ATIVO";
            }
        }

        if (alertas == 0) {
            System.out.println("Nenhum alerta de validade.");
        }
    }

    // ================================================
    // OPCAO 4 - MOVIMENTAR ESTOQUE
    // ================================================

    static void movimentarEstoque() {
        if (totalProdutos == 0) {
            System.out.println("Estoque vazio.");
            return;
        }

        String codigoBusca = lerTexto("Digite o codigo do produto:");
        String loteBusca = lerTexto("Digite o lote do produto:");

        // Busca sequencial usando codigo e lote
        int i = -1;
        for (int k = 0; k < totalProdutos && i == -1; k++) {
            if (codigos[k].equals(codigoBusca) && lotes[k].equals(loteBusca)) {
                i = k;
            }
        }

        if (i == -1) {
            System.out.println("Produto nao encontrado.");
            return;
        }

        System.out.println("Produto: " + nomes[i]);
        System.out.println("Quantidade atual: " + quantidades[i]);

        if (perfilAcesso == 2) {
            System.out.println("1 - Entrada de produtos");
        }
        System.out.println("2 - Baixa de estoque");
        int tipoMov = lerInteiro("Tipo de movimentacao:");

        if (tipoMov == 1 && perfilAcesso != 2) {
            System.out.println("Somente o gestor pode registrar entradas.");

        } else if (tipoMov == 1 && perfilAcesso == 2) {
            int qtdMov = lerInteiro("Quantidade de entrada:");

            if (qtdMov > 0) {
                quantidades[i] += qtdMov;
                System.out.println("Entrada registrada.");
            } else {
                System.out.println("Quantidade invalida.");
            }

        } else if (tipoMov == 2) {
            int qtdMov = lerInteiro("Quantidade de saida:");

            if (qtdMov <= 0) {
                System.out.println("Quantidade invalida.");

            } else if (diferencaEmMeses(i) < 0) {
                estados[i] = "EXPIRADO";
                System.out.println("Produto vencido.");
                System.out.println("Baixa comercial bloqueada.");

            } else if (qtdMov > quantidades[i]) {
                System.out.println("Estoque insuficiente.");

            } else {
                quantidades[i] -= qtdMov;
                System.out.println("Baixa registrada.");
            }

        } else {
            System.out.println("Opcao invalida.");
        }

        System.out.println("Quantidade atual: " + quantidades[i]);
    }

    // ================================================
    // OPCAO 5 - PAINEL FINANCEIRO (SOMENTE GESTOR)
    // ================================================

    static void painelFinanceiro() {
        double valorCusto = 0;
        double valorVenda = 0;
        double valorSimples = 0;
        double valorIcms = 0;
        double valorCartao = 0;
        int unidadesTotais = 0;

        int[] qtdCategoria = new int[NUM_CATEGORIAS];
        int[] produtosCategoria = new int[NUM_CATEGORIAS];
        double[] custoCategoria = new double[NUM_CATEGORIAS];
        double[] vendaCategoria = new double[NUM_CATEGORIAS];
        double[] simplesCategoria = new double[NUM_CATEGORIAS];
        double[] icmsCategoria = new double[NUM_CATEGORIAS];

        for (int i = 0; i < totalProdutos; i++) {
            int c = categorias[i] - 1;
            double custoItem = custos[i] * quantidades[i];
            double vendaItem = vendas[i] * quantidades[i];

            unidadesTotais += quantidades[i];
            valorCusto += custoItem;
            valorVenda += vendaItem;
            valorSimples += custoItem * taxasSimples[c] / 100;
            valorIcms += custoItem * taxasIcms[c] / 100;
            valorCartao += custoItem * taxaCartao / 100;

            qtdCategoria[c] += quantidades[i];
            produtosCategoria[c]++;
            custoCategoria[c] += custoItem;
            vendaCategoria[c] += vendaItem;
            simplesCategoria[c] += custoItem * taxasSimples[c] / 100;
            icmsCategoria[c] += custoItem * taxasIcms[c] / 100;
        }

        double valorTributos = valorSimples + valorIcms;

        double resultadoEstimado = valorVenda - valorCusto
                - valorSimples - valorIcms - valorCartao;

        System.out.println("========== PAINEL FINANCEIRO ==========");
        System.out.println("Unidades em estoque: " + unidadesTotais);
        System.out.println("Valor total a custo: R$ " + moeda(valorCusto));
        System.out.println("Valor potencial de venda: R$ " + moeda(valorVenda));
        System.out.println("Simples estimado: R$ " + moeda(valorSimples));
        System.out.println("ICMS estimado: R$ " + moeda(valorIcms));
        System.out.println("Total estimado de tributos: R$ " + moeda(valorTributos));
        System.out.println("Taxas de cartao estimadas: R$ " + moeda(valorCartao));
        System.out.println("Resultado estimado: R$ " + moeda(resultadoEstimado));

        for (int j = 0; j < NUM_CATEGORIAS; j++) {
            System.out.println(" ");
            System.out.println("Categoria: " + nomesCategorias[j]);
            System.out.println("Tipos de produtos: " + produtosCategoria[j]);
            System.out.println("Unidades em estoque: " + qtdCategoria[j]);
            System.out.println("Valor a custo: R$ " + moeda(custoCategoria[j]));
            System.out.println("Valor de venda: R$ " + moeda(vendaCategoria[j]));
            System.out.println("Simples estimado: R$ " + moeda(simplesCategoria[j]));
            System.out.println("ICMS estimado: R$ " + moeda(icmsCategoria[j]));
        }

        System.out.println("Valores tributarios para simulacao academica.");
    }

    // ================================================
    // OPCAO 6 - CONFIGURAR TRIBUTOS (SOMENTE GESTOR)
    // ================================================

    static void configurarTributos() {
        for (int j = 1; j <= NUM_CATEGORIAS; j++) {
            System.out.println(j + " - " + nomesCategorias[j - 1]);
            System.out.println("Simples Nacional: " + taxasSimples[j - 1] + "%");
            System.out.println("ICMS: " + taxasIcms[j - 1] + "%");
        }

        System.out.println("Taxa de cartao: " + taxaCartao + "%");
        System.out.println("1 - Alterar aliquota de categoria");
        System.out.println("2 - Alterar taxa de cartao");
        System.out.println("0 - Voltar");
        int opcaoConfig = lerInteiro("Escolha uma opcao:");

        if (opcaoConfig == 1) {
            int categoriaConfig = lerInteiro("Escolha a categoria (1 a 4):");

            if (categoriaConfig >= 1 && categoriaConfig <= NUM_CATEGORIAS) {
                System.out.println("1 - Simples Nacional");
                System.out.println("2 - ICMS");
                int tipoTaxa = lerInteiro("Escolha o tipo de aliquota:");

                double novaTaxa = lerDecimal("Nova aliquota (0 a 100):");

                if (novaTaxa >= 0 && novaTaxa <= 100) {
                    if (tipoTaxa == 1) {
                        taxasSimples[categoriaConfig - 1] = novaTaxa;
                    } else if (tipoTaxa == 2) {
                        taxasIcms[categoriaConfig - 1] = novaTaxa;
                    } else {
                        System.out.println("Tipo de aliquota invalido.");
                    }
                } else {
                    System.out.println("Aliquota invalida.");
                }
            } else {
                System.out.println("Categoria invalida.");
            }

        } else if (opcaoConfig == 2) {
            double novaTaxa = lerDecimal("Nova taxa de cartao (0 a 100):");

            if (novaTaxa >= 0 && novaTaxa <= 100) {
                taxaCartao = novaTaxa;
            } else {
                System.out.println("Taxa invalida.");
            }

        } else if (opcaoConfig != 0) {
            System.out.println("Opcao invalida.");
        }

        // Atualiza os precos dos produtos cadastrados
        for (int i = 0; i < totalProdutos; i++) {
            vendas[i] = calcularPreco(
                    custos[i],
                    taxasSimples[categorias[i] - 1],
                    taxasIcms[categorias[i] - 1],
                    taxaCartao,
                    margens[i]);
        }
    }

    // ================================================
    // 5. FUNCAO DE CALCULO DO PRECO
    // ================================================

    static double calcularPreco(double custo, double simples, double icms,
                                double cartao, double margem) {
        double valorSimples = custo * simples / 100;
        double valorIcms = custo * icms / 100;
        double valorCartao = custo * cartao / 100;
        double valorMargem = custo * margem / 100;

        return custo + valorSimples + valorIcms + valorCartao + valorMargem;
    }

    // ================================================
    // FUNCOES AUXILIARES
    // ================================================

    // Diferenca em meses entre a validade do produto i e a data atual
    static int diferencaEmMeses(int i) {
        int mesesAtual = anoAtual * 12 + mesAtual;
        int mesesValidade = validadesAno[i] * 12 + validadesMes[i];
        return mesesValidade - mesesAtual;
    }

    static String calcularEstado(int i) {
        int diferenca = diferencaEmMeses(i);
        if (diferenca < 0) {
            return "EXPIRADO";
        } else if (diferenca <= 2) {
            return "PERTO DO VENCIMENTO";
        }
        return "ATIVO";
    }

    static String moeda(double valor) {
        return String.format(BR, "%.2f", valor);
    }

    // ================================================
    // LEITURA DE DADOS
    // ================================================

    static String lerTexto(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine().trim();
    }

    static int lerInteiro(String mensagem) {
        while (true) {
            String entrada = lerTexto(mensagem);
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero inteiro.");
            }
        }
    }

    static double lerDecimal(String mensagem) {
        while (true) {
            String entrada = lerTexto(mensagem).replace(',', '.');
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero (ex.: 12.50).");
            }
        }
    }
}