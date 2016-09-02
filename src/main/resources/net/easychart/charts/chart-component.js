/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var chart = function (contenedor, c3script) {
    this.contenedor = contenedor;
    this.c3script = c3script;
    
    this.c3exec = new Function(this.c3script);
    this.c3id = this.c3exec();
    
}
