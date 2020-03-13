package MavenTeste;

import org.junit.Test;

import DAOGenerico.DAOGeneric;
import Model.UsuarioPessoa;

public class TesteHibernate {
	@Test
	public void testeHibernate() {
		DAOGeneric<UsuarioPessoa> daoGeneric = new DAOGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(null);
		pessoa.setNome("Duda");
		pessoa.setSobrenome("Melo");
		pessoa.setEmail("dudamelo82@gmail.com");
		pessoa.setLogin("duda123");
		pessoa.setSenha("duda123_");
		
		daoGeneric.salvar(pessoa);
	}

}
