package datafactory;

import pojo.UsuarioPojo;

public class UsuarioDataFactory {
    public static UsuarioPojo usuarioLogar (){

        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setUsuarioLogin("admin");
        usuario.setUsuarioSenha("admin");

        return usuario;
    }
}
