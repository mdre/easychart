/*
 * Variables a usar:
 *      chartId
 *      colData
 *      catData
 */

var chartId=c3.generate({
    bindto: '#chartId',
    //    bindto: '#chart1',
    data: {
        columns: [colData],
        type: 'bar'
    },
    axis: {
        rotated: true,
        localtime: true,
        x: {
            type: 'category',
            categories: [catData]
        }
    },
    legend: {
        show: false
    }
});

// actualizar el tamaño del gráfico
setTimeout(function () {
    chartId.resize();
}, 50);