<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
        Mantenimiento de clientes
        <P></P>
        <form id="frmPrincipal" action="ServletController" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>#</td>
                        <td>Codigo</td>
                        <td>Nombres</td>
												<td>Fecha Nac</td>
                    </tr>
                    <c:forEach var="item" items="${listaClientes}">
                        <tr>
                            <td><input type="radio" name="optSeleccion" value="${item.codigoCliente}"/></td>
                            <td>${item.codigoCliente}</td>
                            <td>${item.nombres} ${item.apellidos}</td>
														<td>${item.fechaNacimiento}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!--Accion a realizar-->
            <input type="hidden"  name="hidAccion" value=""/>
            <!--*****************-->

            <input type="button" value="Registrar" onclick="doAccion('registrarView')"/>
            <input type="button" value="Actualizar" onclick="doAccion('actualizarView')"/>
            <input type="button" value="Eliminar" onclick="doAccion('eliminarView')"/>
            <input type="button" value="Ver detalles" onclick="doAccion('detalleView')"/>
        </form>
    </center>

    <script language="javascript">
        function doAccion(accion){
            //alert(accion);
            if(accion=="registrarView"){
                frmPrincipal.hidAccion.value="registrarView";
                //Envio el formulario
                frmPrincipal.submit();               
            }
            else if(accion=="actualizarView"){                
                frmPrincipal.hidAccion.value="actualizarView";
                //Envio el formulario
                frmPrincipal.submit();
            } 
            else if(accion=="detalleView"){                
                frmPrincipal.hidAccion.value="detalleView";
                //Envio el formulario
                frmPrincipal.submit();
            }						

						else if(accion=="eliminarView"){
                frmPrincipal.hidAccion.value="eliminarView";
                //Envio el formulario
                frmPrincipal.submit();                
            }
            

        }
    </script>    
</body>
</html>
