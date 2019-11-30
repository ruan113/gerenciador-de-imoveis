package controle;import Model.*;import controle.*;import limite.*;public class ControlePrincipal {    //Controladores    public ControleImovel ctrImovel;    public ControleVenda ctrVenda;    public ControleCorretor ctrCorretor;        public ControleVendedor ctrVendedor;    //Limites    public LimitePrincipal lmtPrincipal;    public ControlePrincipal() {        //Inicializa os controladores fazendo com que possamos contrala-los        //por meio do controle principal        ctrImovel = new ControleImovel(this);        ctrVenda = new ControleVenda(this);        ctrCorretor = new ControleCorretor(this);                ctrVendedor = new ControleVendedor(this);        //Inicia o menu principal        lmtPrincipal = new LimitePrincipal(this);    }    //chama a classe RelatorioFaturamento e passa este controlador para o construtor da classe RelatorioFaturamento    public void relatorioFat(){        new RelatorioFaturamento(this);    }    public void relatorioPagto(){        new RelatorioPagamento(this);    }        public void relatorioImovel(){        new RelatorioImovel(this);    }        public void relatorioCorretor(){        new RelatorioCorretores(this);    }        public static void main(String[] args) {        new ControlePrincipal();    }}