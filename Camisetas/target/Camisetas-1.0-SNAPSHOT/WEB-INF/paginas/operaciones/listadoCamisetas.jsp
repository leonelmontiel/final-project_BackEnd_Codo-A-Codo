<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR"/>
<section id="camisetas">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <div class="card text-center bg-warning mb-3">
                    <div class="card-body">
                        <h3>Cantidad de Camisetas</h3>
                        <h4 class="display-4">${cantidadCamisetas}</h4>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="card bg-secondary">
                    <div class="card-header text-white">
                        <h4>Listado de Camisetas</h4>
                    </div>
                    <table class="table table-striped table-dark">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Equipo</th>
                                <th>Número</th>
                                <th>Jugador</th>
                                <th>Talle</th>
                                <th>Precio</th>
                                <th>Cantidad</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="camiseta" items="${camisetas}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${camiseta.equipo}</td>
                                    <td>${camiseta.numero}</td>
                                    <td>${camiseta.jugador}</td>
                                    <td>${camiseta.talle}</td>
                                    <td><fmt:formatNumber value="${camiseta.precio}" type="currency"/></td>
                                    <td>${camiseta.stock}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idcamiseta=${camiseta.idcamiseta}" class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-3">          

                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Precio Total de Camisetas</h3>
                        <h4 class="display-4"><fmt:formatNumber value="${precioTotal}" type="currency"/></h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/WEB-INF/paginas/operaciones/agregarCamiseta.jsp"/>