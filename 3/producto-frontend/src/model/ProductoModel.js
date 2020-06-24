import CategoriaModel from "./CategoriaModel";

class ProductoModel {

    constructor(data) {
        this.IDPROD = data.idprod;
        this.NOMPROD = data.nomprod;
        this.PREPROD = data.preprod;
        this.IDCAT = data.idcat;
        this.ESTPROD = data.estprod;
        this.categoria = new CategoriaModel(data.categoria);
    }  

}

export default ProductoModel;