package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdicionarProdutoPage {

    private WebDriver navegador;


    public AdicionarProdutoPage(WebDriver navegador){
        this.navegador=navegador;
    }


    public AdicionarProdutoPage inserirONomeDoProduto(String nomeDoProduto){

        navegador.findElement(By.id("produtonome")).sendKeys(nomeDoProduto);

        return this;
    }

    public AdicionarProdutoPage inserirOValorDoProduto(String valorDoProduto){

        navegador.findElement(By.name("produtovalor")).sendKeys(valorDoProduto);


        return this;
    }


    public AdicionarProdutoPage inserirACordoProduto(String cor){

        navegador.findElement(By.id("produtocores")).sendKeys(cor);

        return this;

    }


    public ListaDeProdutosPage submeterOFormularioDeAdiçãoDeProdutoComErro(){

        this.navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListaDeProdutosPage(navegador);
    }

    public EdiçãoProdutosPage submeterOFormularioDeAdiçãoDeProdutoComSucesso(){

        this.navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new EdiçãoProdutosPage(navegador);
    }


}
