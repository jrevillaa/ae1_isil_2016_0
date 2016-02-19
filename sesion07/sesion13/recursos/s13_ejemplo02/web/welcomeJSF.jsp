<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Demostracion de eventos con JSF</title>
        </head>
        <body>
            <h:form>
                <h1><h:outputText value="Eventos con JSF"/></h1>
                <h:selectOneMenu id="combo" value="#{datosMB.pais}"
                                 onchange="submit()"
                                 valueChangeListener="#{datosMB.cambioSeleccion}">
                    <f:selectItems value="#{datosMB.paises}"/>
                </h:selectOneMenu>
                <h:outputText id="seleccion" value="#{datosMB.seleccion}" /><br/>


                <h:selectOneMenu id="departamento" value="#{datosMB.departamento}"
                                 onchange="submit()"
                                 valueChangeListener="#{datosMB.cambioSeleccion}">
                    <f:selectItems value="#{datosMB.listaDepartamentos}"/>
                </h:selectOneMenu>
                <h:selectOneMenu id="provincia" value="#{datosMB.provincia}">
                    <f:selectItems value="#{datosMB.listaProvincias}"/>
                </h:selectOneMenu>

            </h:form>
            
        </body>
    </html>
</f:view>
