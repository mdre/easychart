/*
 * Variables a usar:
 *      chartId
 *      colData: ['data1', 100],['data2', 300],['data3', 200]
 *      dataLabel: ['data1', 'data2', 'data3']
 */

var chartId = c3.generate({
    bindto: '#chartId',
    data: {
        columns: [
            colData
        ],
        type: 'pie'
    },
    legend: {
        show: false
    }
});

function toggle(id) {
    chartId.toggle(id);
}

// utilizar el precontenedor
// eliminamos primero lo que existe dentro
 d3.select('#prechartId').selectAll('*').remove();
// y generamos el menú que queremos.
var leg = d3.select('#prechartId').insert('div', ':first-child').attr('class', 'c3-pie-with-top-legend-bar').selectAll('span')
    .data(dataLabel)
  .enter().append('span')
    .attr('data-id', function (id) { return id; })
    .html(function (id) { return id; })
    .each(function (id) {
        d3.select(this).style('background-color', chartId.color(id));
    })
    .on('mouseover', function (id) {
        chartId.focus(id);
    })
    .on('mouseout', function (id) {
        chartId.revert();
    })
    .on('click', function (id) {
        chartId.toggle(id);
    });

// actualizar el tamaño del gráfico
setTimeout(function () {
    chartId.resize();
}, 50);