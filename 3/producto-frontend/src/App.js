import React, { Component } from 'react';
import './App.css';
import ProductoForm from './components/Forms/ProductoForm';
import ProductosComponent from './components/ProductoComponent';


class App extends Component {

  componentDidMount() {
  }


  render() {
    return (
      <div>
        <ProductoForm />
        <ProductosComponent/>
      </div>
    );
  }
}


export default App;
