import React, { Component } from 'react';
import TextField from '@material-ui/core/TextField';
import MenuItem from '@material-ui/core/MenuItem';
import CategoriaService from '../services/CategoriaService';


class CategoriaComponent extends Component {

    constructor() {
        super();
        this.state = {
            listaCategoria: []
        }
        this.servicioCategoria = new CategoriaService();
    }



    async componentDidMount() {
        const data = await this.servicioCategoria.findAll();
        this.setState({ listaCategoria: data });
    }


    render() {
        return (
            <TextField
                select
                label="Categoria"
                helperText="Seleccione">
                {
                    this.state.listaCategoria.map((categoria) => (
                        <MenuItem key={categoria.IDCAT} value={categoria.NOMCAT}>
                            {categoria.NOMCAT}
                        </MenuItem>
                    ))
                }
            </TextField>
        );
    }


}

export default CategoriaComponent;