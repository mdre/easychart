net_easychart_charts_Chart = function () {
    console.log("-------------------");
    var domId = this.getState().domId;
    console.log("1 -------------------");
    this.c3script = this.getState().c3Script;
    console.log("2 -------------------");
    
    var contenedor = document.createElement('div');
    contenedor.setAttribute('id', domId);
    contenedor.setAttribute('style', 'height: 100%; width: 100%; weight: 100%');
    this.getElement().appendChild(contenedor);
    console.log(" - fin primer bloque -");
    //****************************************************
    
    this.onStateChange = function () {
        console.log("---- onStateChange.js!!! -------");
        console.log(this.c3script);
//        var c3exec = new Function(this.c3script);
        this.c3id = new Function(this.c3script);
        console.log("---- 1 -------");
//        this.c3id = c3exec();
        this.c3id();
        console.log("---- fin onStateChange -------");
        //this.c3chart = new c3chart(contenedor, c3script);
    };
};

