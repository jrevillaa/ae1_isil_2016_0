<html>
    <head>
        <title></title>
    </head>
    <body>
    <center>
        <table border="0">
            <tbody>
                <tr>
                    <td><a href="login.html">|Salir|</a></td>
                </tr>
            </tbody>
        </table>
        <P></P>
        Registro de clientes
        <P></P>
        <form action="mensaje.html" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Codigo:</td>
                        <td><input type="text" name="txtCodigo" value="" /></td>
                    </tr>
                    <tr>
                        <td>Nombres:</td>
                        <td><input type="text" name="txtNombres" value="" /></td>
                    </tr>
                    <tr>
                        <td>Apellidos</td>
                        <td><input type="text" name="txtApellidos" value="" /></td>
                    </tr>
                    <tr>
                        <td>Fecha Nacimiento:</td>
                        <td><input type="text" name="txtFechaNacimiento" value="" /></td>
                    </tr>
                    <tr>
                        <td>Login:</td>
                        <td><input type="text" name="txtLogin" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="txtPassword" value="" /></td>
                    </tr>
                    <tr>
                        <td>Direccion:</td>
                        <td><input type="text" name="txtDireccion" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="txtEmail" value="" /></td>
                    </tr>        
                    <tr>
                        <td>Telefono:</td>
                        <td><input type="text" name="txtTelefono" value="" /></td>
                    </tr>           
                    <tr>
                        <td>Tipo documento:</td>
                        <td><select name="cmbTipoId">
                                <option value="DNI">DNI</option>
                                <option value="CE">CE</option>
                                <option value="Pasaporte">Pasaporte</option>
                                <option value="RUC">RUC</option>
                            </select></td>
                    </tr>                
                    <tr>
                        <td>Nro documento:</td>
                        <td><input type="text" name="txtId" value="" /></td>
                    </tr>                
                </tbody>
            </table>

            <input type="submit" value="Guardar" />
        </form>
    </center>
</body>
</html>
