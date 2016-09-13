net_easychart_charts_Chart = function () {
    var domId = this.getState().domId;
    this.c3script = this.getState().c3Script;

    var preContenedor = document.createElement('div');
    preContenedor.setAttribute('id', 'pre' + domId);
    preContenedor.setAttribute('style', 'height: 100%; width: 100%; weight: 100%');

    var contenedor = document.createElement('div');
    contenedor.setAttribute('id', domId);
    contenedor.setAttribute('style', 'height: 100%; width: 100%; weight: 100%');


    if (document.getElementById(domId) != null) {
        this.getElement().removeChild(preContenedor);
        this.getElement().removeChild(contenedor);
    }
    this.getElement().appendChild(preContenedor);
    this.getElement().appendChild(contenedor);
    //****************************************************

    this.onStateChange = function () {
        if (document.getElementById(domId) != null) {
            this.getElement().removeChild(preContenedor);
            this.getElement().removeChild(contenedor);
        }
        this.getElement().appendChild(preContenedor);
        this.getElement().appendChild(contenedor);
        
        console.log(this.c3script);
//        var c3exec = new Function(this.c3script);
        this.c3id = new Function(this.c3script);
//        this.c3id = c3exec();
        this.c3id();
        //this.c3chart = new c3chart(contenedor, c3script);
    };
};

