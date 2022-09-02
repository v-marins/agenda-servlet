package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The Class DAO.
 */
public class DAO {

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";

	/** The url. */
	private String URL = "jdbc:mysql://localhost:3306/dbagenda?useTimezone=true&serverTimezone=UTC";

	/** The user. */
	private String user = "root";

	/** The password. */
	private String password = "V1n1c1u$My5ql";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(URL, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	// CRUD CREATE
	public void inserirContato(Javabeans contato) {
		String sql = "insert into tblcontatos (nome,fone,email) values (?,?,?)";
		try {
			// Abrir conexão com banco
			Connection con = conectar();
			// Preparar para executar comando sql no BD através do Java
			PreparedStatement pstm = con.prepareStatement(sql);
			// Substituir (?) pelo conteúdo nas variáveis Javabeans
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getFone());
			pstm.setString(3, contato.getEmail());
			// Executa o comando sql
			pstm.executeUpdate();
			// Encerrar a conexão com o BD
			con.close();

		} catch (Exception e) {
			System.out.println(e);
			e.getStackTrace();
		}

	}

	/**
	 * Listar contatos.
	 *
	 * @return the array list
	 */
	// CRUD READ
	public ArrayList<Javabeans> listarContatos() {
		// Criando objeto para acessar a classe Javabeans
		ArrayList<Javabeans> contatos = new ArrayList<>();

		String sql = "select * from tblcontatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(sql);
			// Armazenar retorno do BD temporariamente
			ResultSet rs = pstm.executeQuery();
			// Laço Executado enquando houver contatos no rs
			while (rs.next()) {
				// Variaveis de apoio recebem dados do banco
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);

				// Populando o ArrayList
				contatos.add(new Javabeans(idcon, nome, fone, email));
			}
			con.close();
			return contatos;

		} catch (Exception e) {
			System.out.println(e);
			e.getStackTrace();
			return null;
		}
	}

	// CRUD UPDATE
	// Necessários 2 métodos, um para selecionar o contato e o outro para editar.

	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(Javabeans contato) {
		String sql = "select * from tblcontatos where idcon = ?";
		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, contato.getIdcon());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				// setar as variaveis no Javabeans
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			e.getStackTrace();
		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(Javabeans contato) {
		String sql = "update tblcontatos set nome=?,fone=?,email=? where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getFone());
			pstm.setString(3, contato.getEmail());
			pstm.setString(4, contato.getIdcon());
			pstm.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			e.getStackTrace();
		}
	}

	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	public void deletarContato(Javabeans contato) {
		String sql = "delete from tblcontatos where idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, contato.getIdcon());
			pstm.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
			e.getStackTrace();
		}
	}

}
