<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Demostracion de eventos con JSF::::CJAVAPERU</title>
        </head>
        <body>
            <h:form>
                <h1><h:outputText value="Eventos con JSF en CJAVA"/></h1>
                <h:outputLabel value="Nombre"/>
                <h:inputText id="txtNombre" value="#{ventasMB.nombre}" 
                             required="true"/>
                <h:message for="txtNombre"/>
                <br/>
                <h:outputLabel value="Precio"/>
                <h:inputText id="txtPrecio" value="#{ventasMB.precio}" 
                             required="true"/>
                <h:message for="txtPrecio"/>
                <br/>
                <h:outputLabel value="Cantidad"/>
                <h:inputText id="txtCantidad" value="#{ventasMB.cantidad}" 
                             required="true"/>
                <h:message for="txtCantidad"/>
                <br/>
                <h:commandButton value="Agregar" 
                                 action="#{ventasMB.agregarItem}"/>
                <br/>
                <h:dataTable border="1" value="#{ventasMB.listaItems}"
                             var="fila">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Nombre"/>
                        </f:facet>
                        <h:outputText value="#{fila.nombre}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Precio"/>
                        </f:facet>
                        <h:outputText value="#{fila.precio}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Cantidad"/>
                        </f:facet>
                        <h:outputText value="#{fila.cantidad}"/>
                    </h:column>
                </h:dataTable>

            </h:form>
            
        </body>
    </html>
</f:view>

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    