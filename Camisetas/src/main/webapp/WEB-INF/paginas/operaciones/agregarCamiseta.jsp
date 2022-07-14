<div class="modal fade" id="agregarCamisetaModal" tabindex="-1" aria-labelledby="agregarCamisetaModal" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Camiseta</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Equipo</label>
                        <input type="text" class="form-control" name="equipo" required="">
                    </div>
                    <div class="form-group">
                        <label for="autor">Número</label>
                        <input type="number" class="form-control" name="numero">
                    </div>
                    <div class="form-group">
                        <label for="cantPaginas">Jugador</label>
                        <input type="text" class="form-control" name="jugador" required="">
                    </div>
                    <div class="form-group">
                        <label for="precio">Talle</label>
                        <input type="text" class="form-control" name="talle" required="">
                    </div>
                    <div class="form-group">
                        <label for="copias">Precio</label>
                        <input type="number" class="form-control" name="precio" required="">
                    </div>
                    <div class="form-group">
                        <label for="stock">Cantidad</label>
                        <input type="number" class="form-control" name="stock" required="">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
