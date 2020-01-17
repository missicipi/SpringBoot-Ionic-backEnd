package com.nelioalves.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.domain.Cidade;
import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.domain.Endereco;
import com.nelioalves.cursomc.domain.Estado;
import com.nelioalves.cursomc.domain.Pagamento;
import com.nelioalves.cursomc.domain.PagamentoComCartao;
import com.nelioalves.cursomc.domain.Pedido;
import com.nelioalves.cursomc.domain.unums.EstadoPagamento;
import com.nelioalves.cursomc.domain.unums.TipoCliente;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.repositories.CidadeRepository;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.repositories.EnderecoRepository;
import com.nelioalves.cursomc.repositories.EstadoRepository;
import com.nelioalves.cursomc.repositories.PagamentoRepository;
import com.nelioalves.cursomc.repositories.PedidoRepository;
import com.nelioalves.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Categoria cat1 = new Categoria(null, "Informatica"); Categoria cat2 = new
		 * Categoria(null, "Escritório");
		 * 
		 * Produto p1 = new Produto(null, "computador", 2000.00); Produto p2 = new
		 * Produto(null, "impressora", 800.00); Produto p3 = new Produto(null, "mouse",
		 * 60.00);
		 * 
		 * cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		 * cat2.getProdutos().addAll(Arrays.asList(p2));
		 * 
		 * p1.getCategorias().addAll(Arrays.asList(cat1));
		 * p2.getCategorias().addAll(Arrays.asList(cat2, cat1));
		 * p3.getCategorias().addAll(Arrays.asList(cat1));
		 * 
		 * categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		 * produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		 */

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "2354234523", TipoCliente.PESSOASFISICA);
		cli1.getTelefones().addAll(Arrays.asList("2342341243123", "23423524543"));
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "32423543", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "3105", "Sala80", "Centro", "234245", cli1, c2);

		cli1.getEndereco().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");// objeto para receber as data e converter no
																		// campo date do banco
		// melhor dizendo é uma máscara de formatação para gerar uma data

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2019 10:32"), cli1, e1);
		pedidoRepository.saveAll(Arrays.asList(ped1));
		/*
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		pagamentoRepository.saveAll(Arrays.asList(pagto1));*/
	}

}
