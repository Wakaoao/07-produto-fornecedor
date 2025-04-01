import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;

public class Util {

    private Produto[] produto = new Produto[5];
    private Fornecedor[] fornecedor = new Fornecedor[5];
    private int idxProduto = 0;
    private int idxFornecedor = 0;

    public void menu() {

        int opcao;
        String menu = "1. Cadastrar produto\n2. Pesquisar produto\n3. Pesquisar forncedor\n4. Finalizar";

        while(true) {
            opcao = parseInt(showInputDialog(menu));
            if(opcao == 4) {
                return;
            }
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    pesquisarProduto();
                    break;
                case 3:
                    pesquisarFornecedor();
                    break;
                default:
                    showMessageDialog(null, "Opção inválida");
            }
        }

    }

    private void cadastrarProduto() {

         String nome;
         double valorUnitario;
         int qtdEstoque;
         Fornecedor fornecedor = pesquisarFornecedor();

         if(fornecedor == null) {
             cadastrarFornecedor();
         }

         nome = showInputDialog("Nome do produto");
         valorUnitario = parseDouble(showInputDialog("Valor"));
         qtdEstoque = parseInt(showInputDialog("Quantidade em estoque"));
         produto[idxProduto] = new Produto(nome, valorUnitario, qtdEstoque, fornecedor);
         idxProduto++;

    }

    private Fornecedor cadastrarFornecedor() {

        Fornecedor fornecedor;
        String nome = showInputDialog("Nome");;
        int cnpj = parseInt(showInputDialog("CNPJ"));
        fornecedor = new Fornecedor(nome, cnpj);
        this.fornecedor[idxFornecedor] = fornecedor;
        idxFornecedor++;
        return fornecedor;

    }

    private void pesquisarProduto() {

        String nome = showInputDialog("Nome do produto");
        String aux = "";

        for(int i=0; i<idxProduto; i++) {
            if(produto[i].getNome().equals(nome)) {
                aux += "Fornecedor: " + produto[i].getFornecedor() + "\n";
                aux += "Perfil (tipo de tarifa): " + produto[i].getValoUnitario() + "\n";
                aux += "Quantidade em Estoque: " + produto[i].getQtdEstoque() + "\n";
            }

            showMessageDialog(null, "Produto não encontrado");

        }

    }

    private Fornecedor pesquisarFornecedor() {

        int cnpj = parseInt(showInputDialog("CNPJ do fornecedor"));

        for(int i=0; i<idxFornecedor; i++) {
            if(fornecedor[i].getCnpj() == cnpj) {
                return fornecedor[i];
            }
        }
        showMessageDialog(null, cnpj + " não cadastrado");
        return null;

    }

}
