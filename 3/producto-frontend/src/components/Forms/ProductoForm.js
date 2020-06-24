import React, { Component } from 'react';
import ProductoService from '../../services/ProductoService';
import { TextField } from '@material-ui/core';
import CategoriaComponent from '../CategoriaComponent';

class ProductoForm extends Component {


    constructor() {
        super();
        this.servicioProducto = new ProductoService();
        this.state = {
            producto: {

            }
        }
    }

    componentDidMount() {

    }

    enviarProducto = producto => e => {
        this.setState({
            producto: producto
        });
        console.log(this.state.producto);

    }

    guardar = (producto) => {

    }

    render() {
        return (
            <form >
                <CategoriaComponent />
                <TextField id="standard-basic" label="Nombre"/>
            </form>
        );
    }
}

export default ProductoForm;