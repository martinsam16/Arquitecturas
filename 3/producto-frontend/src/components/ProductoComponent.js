import React, { Component } from 'react';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import ProductoService from '../services/ProductoService';
import Button from '@material-ui/core/Button';
import DialogTitle from '@material-ui/core/DialogTitle';
import Dialog from '@material-ui/core/Dialog';


class ProductoComponent extends Component {

    render() {
        return (
            <Card>
                <CardActionArea onClick={this.props.mostrar}>
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="h2">
                            {this.props.producto.NOMPROD}
                        </Typography>
                        <Typography variant="body2" color="textSecondary" component="p">
                            S/. {this.props.producto.PREPROD}
                        </Typography>
                    </CardContent>
                </CardActionArea>
                <CardActions>
                    <Button size="small" color="secondary" onClick={this.props.borrar}>
                        Eliminar
                    </Button>
                </CardActions>
            </Card>
        );
    }
}

class ProductosComponent extends Component {

    constructor() {
        super();
        this.state = {
            listaProducto: [],
            open: false
        }
        this.servicioProducto = new ProductoService();
    }



    async componentDidMount() {
        const data = await this.servicioProducto.findAll();
        this.setState({ listaProducto: data });
    }


    eliminarProducto = producto => e => {
        console.log('[DELETE] ' + producto.IDPROD);
        this.servicioProducto.delete(producto.IDPROD);
        this.setState({
            listaProducto: this.state.listaProducto.filter(p => p !== producto),
        });
    };

    mostrarDetalle = producto => e => {
        this.setState({
            open: true
        })
        console.log(producto.IDPROD);
    }
    handleClose = () => this.setState({
        open: false
    })

    render() {

        return (

            <div>
                <Dialog  
                    open={this.state.open}
                    onClose={this.handleClose}
                >
                    <DialogTitle id="simple-dialog-title">Modificar</DialogTitle>
                    <Typography>Un formulario para modificar aqui xd</Typography>

                </Dialog  >
                {
                    this.state.listaProducto.map((p) => (
                        <div>
                            <ProductoComponent
                                producto={p}
                                mostrar={this.mostrarDetalle(p)}
                                borrar={this.eliminarProducto(p)}
                            />

                        </div>
                    ))
                }
            </div>
        );
    }
}

export default ProductosComponent;
