package modulos.produtos;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do Modulo de Produtos")
public class ProdutosTest {
    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        // abrir o navegador
        System.setProperty("webdriver.edge.driver", "C:\\Drivers\\edgedriver_win64\\msedgedriver.exe");
        this.navegador = new EdgeDriver();

        // Vou maximizar a tela
        this.navegador.manage().window().maximize();

        // Vou definir um tempo de espera padrão de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a pagina da lojinha WEB
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");


    }

    @Test
    @DisplayName("Nao é permitido Registrar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {

       String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .clickarEmAdicionarProduto()
                .inserirONomeDoProduto("Macbook Pro 2024")
                .inserirOValorDoProduto("0000")
                .inserirACordoProduto("Branco, Preto,Cinza")
                .submeterOFormularioDeAdiçãoDeProdutoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);


    }

    @Test
    @DisplayName("Nao é permitido registrar Registrar um produto com valor igual a 7.000,01")
    public void testNaoEPermitidoRegistrarProdutoComValorsuperiorASeteMilEUm() {

        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .clickarEmAdicionarProduto()
                .inserirONomeDoProduto("PlayStation 5")
                .inserirOValorDoProduto("700001")
                .inserirACordoProduto("Preto, Vermelho, Branco")
                .submeterOFormularioDeAdiçãoDeProdutoComErro()
                .capturarMensagemApresentada();


        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);



    }

    @Test
    @DisplayName("é permitido registrar Registrar um produto com valor entre 0,01")
    public void testEPermitidoRegistrarProdutoComValorEntreUmCentavo() {

        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .clickarEmAdicionarProduto()
                .inserirONomeDoProduto("PlayStation 5")
                .inserirOValorDoProduto("001")
                .inserirACordoProduto("Preto, Vermelho, Branco")
                .submeterOFormularioDeAdiçãoDeProdutoComSucesso()
                .capturarMensagemApresentada();


        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);



    }


    @Test
    @DisplayName("É Possivel Validar que o Produto Será salvo com o valor de 7.000,00")
    public void éPossivelSalvarumProdutoComOValorDeSeteMil(){
       String mensagemApresentada = new LoginPage(navegador)
                                    .informarOUsuario("admin")
                                    .informarASenha("admin")
                                    .submeterFormularioDeLogin()
                                    .clickarEmAdicionarProduto()
                                    .inserirONomeDoProduto("Motorola Edge 30 Pro")
                                    .inserirOValorDoProduto("7.000,00")
                                    .inserirACordoProduto("indigo, branco, Rosa")
                                    .submeterOFormularioDeAdiçãoDeProdutoComSucesso()
                                    .capturarMensagemApresentada();

        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);






    }

    @AfterEach
    public void afterEach(){
        // Fechar o navegador
        this.navegador.quit();

    }
}
