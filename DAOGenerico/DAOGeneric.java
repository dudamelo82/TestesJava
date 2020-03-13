package DAOGenerico;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import MavenTeste.HibernateUtil;
import Model.UsuarioPessoa;

public class DAOGeneric<E> {

	private EntityManager entityManager = HibernateUtil.getEntityManager();

	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.persist(entidade);
		transaction.commit();

	}

	public E updateMerge(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalva = entityManager.merge(entidade);

		transaction.commit();

		return entidadeSalva;

	}

	public E pesquisar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		E e = (E) entityManager.find(entidade.getClass(), id);
		return e;

	}

	public void deletarPorId(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		entityManager.createNamedQuery(
				"delete from" + entidade.getClass().getSimpleName().toLowerCase() 
				+ "where id = " + id).executeUpdate();
		
		transaction.commit();

	}

}
