export class Usuario {

    '_id': string;
    'email': string;
    'name': string;
    'birthDay': Date;
    'createdAt': Date;

}

export class Curso {

    '_id': string;
    'author': string;
    'name': string;
    'image': string;
    'description': string;
    'price': number;

}

export class ID {

    '_id': string;

}

export class Compra {

    'email': string;
    'cursosComprar': ID[];

}

export class UsuarioCurso {

    '_id': string;
    'cursos': Curso[];

}

export class Venta {

    'usuarioCurso': UsuarioCurso;
    'usuario': Usuario;
}
