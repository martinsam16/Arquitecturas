import axios from 'axios';
import CategoriaModel from '../model/CategoriaModel';

class CategoriaService {

    constructor() {
        this.urlServicio = 'http://localhost:8081/api/categoria';
        this.listaCategoria = [];
    }

    findAll = async () => {
        await axios.get(this.urlServicio)
            .then((res) => {
                res.data.forEach(c => {
                    if (c.estcat === 'A') {
                        this.listaCategoria.push(new CategoriaModel(c));
                    }
                });
                console.log(this.listaCategoria);

            })
            .catch(console.log);

        return this.listaCategoria;
    }


    findOne = (id) => {
        axios.get(this.urlServicio + '/' + id)
            .then((res) => {
                this.categoria = new CategoriaModel(res.data);
            })
            .catch(console.log);
        return this.categoria;
    }

    save = (categoria) => {
        axios.post(this.urlServicio, categoria)
            .then(console.log)
            .catch(console.log);
    }

    update = (categoria) => {
        axios.put(this.urlServicio, categoria)
            .then(console.log)
            .catch(console.log);
    }

    delete = (id) => {
        axios.delete(this.urlServicio + '/' + id)
            .then(console.log)
            .catch(console.log);
    }

}

export default CategoriaService;