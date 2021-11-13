/*
	* < UNIME >
	* < B.S.I >
	* < PROGRAMAÇÃO ORIENTADA A OBJETOS 2 >
	* < PABLO ROXO >
	* < LUIS RICARDO SOUSA BORGES >
	*/

public class Curso {

	public static void main(String[] args) {
		BD bd = new BD();
		bd.conectar();
		
		EmpresaRepositorio empresaRepo = new EmpresaRepositorio(bd);
		
		TelaEmpresaListagem telaEmpresaListagem = new TelaEmpresaListagem(empresaRepo);
		telaEmpresaListagem.setVisible(true);
	}

}
