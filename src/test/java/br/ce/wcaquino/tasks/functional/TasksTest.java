package br.ce.wcaquino.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		try {
			//clicar em Add todo
			driver.findElement(By.id("addTodo")).click();
					
			//Escrever descricao
			driver.findElement(By.id("task")).sendKeys("Task via Selenium");
			
			//Escrever data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			
			//Clicar salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar mensagem de sucesso
			String mensagem = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Success!", mensagem);
		} finally {
			//Fechar browser
			driver.quit();
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		try {
			//clicar em Add todo
			driver.findElement(By.id("addTodo")).click();
					
			//Escrever descricao
			//driver.findElement(By.id("task")).sendKeys("Task via Selenium");
			
			//Escrever data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			
			//Clicar salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar mensagem de sucesso
			String mensagem = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the task description", mensagem);
		} finally {
			//Fechar browser
			driver.quit();
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaSemData() {
		WebDriver driver = acessarAplicacao();
		try {
			//clicar em Add todo
			driver.findElement(By.id("addTodo")).click();
					
			//Escrever descricao
			driver.findElement(By.id("task")).sendKeys("Task via Selenium");
			
			//Escrever data
			//driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
			
			//Clicar salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar mensagem de sucesso
			String mensagem = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the due date", mensagem);
		} finally {
			//Fechar browser
			driver.quit();
		}
	}
	
	@Test
	public void naoDeveSalvarTarefaComDataPassada() {
		WebDriver driver = acessarAplicacao();
		try {
			//clicar em Add todo
			driver.findElement(By.id("addTodo")).click();
					
			//Escrever descricao
			driver.findElement(By.id("task")).sendKeys("Task via Selenium");
			
			//Escrever data
			driver.findElement(By.id("dueDate")).sendKeys("10/10/1991");
			
			//Clicar salvar
			driver.findElement(By.id("saveButton")).click();
			
			//Validar mensagem de sucesso
			String mensagem = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", mensagem);
		} finally {
			//Fechar browser
			driver.quit();
		}
	}

}
