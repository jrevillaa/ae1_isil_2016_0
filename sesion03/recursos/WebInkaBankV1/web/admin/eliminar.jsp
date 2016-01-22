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
        Actualizar datos de cliente
        <P></P>
        <form action="ServletController" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Codigo:</td>
                        <td><input type="text" name="txtCodigo" value="${cliente.codigoCliente}" /></td>
                    </tr>
                    <tr>
                        <td>Nombres:</td>
                        <td><input type="text" name="txtNombres" value="${cliente.nombres}" /></td>
                    </tr>
                    <tr>
                        <td>Apellidos</td>
                        <td><input type="text" name="txtApellidos" value="${cliente.apellidos}" /></td>
                    </tr>
                    <tr>
                        <td>Fecha Nacimiento:</td>
                        <td><input type="text" name="txtFechaNacimiento" value="${cliente.fechaNacimiento}" /></td>
                    </tr>
                    <tr>
                        <td>Login:</td>
                        <td><input type="text" name="txtLogin" value="${cliente.login}" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="txtPassword" value="${cliente.password}" /></td>
                    </tr>
                    <tr>
                        <td>Direccion:</td>
                        <td><input type="text" name="txtDireccion" value="${cliente.direccion}" /></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="txtEmail" value="${cliente.email}" /></td>
                    </tr>        
                    <tr>
                        <td>Telefono:</td>
                        <td><input type="text" name="txtTelefono" value="${cliente.telefono}" /></td>
                    </tr>           
                    <tr>
                        <td>Tipo documento:</td>
                        <td><select name="cmbTipoId">
                                <option value="DNI">DNI</option>
                                <option value="CE">CE</option>
                                <option value="Pasaporte">Pasaporte</option>
                                <option value="RUC">RUC</option>
                                <option value="${cliente.tipoId}" selected="">${cliente.tipoId}</option>
                            </select></td>
                    </tr>                
                    <tr>
                        <td>Nro documento:</td>
                        <td><input type="text" name="txtId" value="${cliente.id}" /></td>
                    </tr>                
                </tbody>
            </table>
            <!--Accion a realizar-->                    
            <input type="hidden"  name="hidAccion" value="eliminar"/>        
            <!--*****************-->            
            
            <input type="submit" value="Eliminar" />
        </form>
    </center>
</body>
</html>
