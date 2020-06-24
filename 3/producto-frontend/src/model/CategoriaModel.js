class CategoriaModel {

    constructor(data) {
        if (data != null) {
            this.IDCAT = data.idcat;
            this.NOMCAT = data.nomcat;
            this.ESTCAT = data.estcat;
        }
    }
}

export default CategoriaModel;